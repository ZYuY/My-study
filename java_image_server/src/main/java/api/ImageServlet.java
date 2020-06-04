package api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dao.Image;
import dao.ImageDao;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@WebServlet("/image")
public class ImageServlet extends HttpServlet {
    /**
     * 查看图片属性: 既能查看所有, 也能查看指定
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 考虑到查看所有图片属性和查看指定图片属性
        // 通过是否 URL 中带有 imageId 参数来进行区分.
        // 存在 imageId 查看指定图片属性, 否则就查看所有图片属性
        // 例如: URL /image?imageId=100
        // imageId 的值就是 "100"
        // 如果 URL 中不存在 imageId 那么返回 null
        String imageId = req.getParameter("imageId");
        if (imageId == null || imageId.equals("")) {
            // 查看所有图片属性
            selectAll(req, resp) ;
        } else {
            // 查看指定图片
            selectOne(imageId, resp);
        }
    }

    private void selectAll(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        //作为请求头告诉服务端消息主体是序列化的JSON字符串。除低版本的IE，基本都支持。
        resp.setContentType("application/json; charset=utf-8");
        // 1. 创建一个 ImageDao 对象, 并查找数据库
        ImageDao imageDao = new ImageDao();
        List<Image> images = imageDao.selectAll();
        // 2. 把查找到的结果转成 JSON 格式的字符串, 并且写回给 resp 对象
        Gson gson = new GsonBuilder().create();
        //    jsonData 就是一个 json 格式的字符串了, 就和之前约定的格式是一样的了.
        //    重点体会下面这行代码, 这个方法的核心, gson 帮我们自动完成了大量的格式转换工作
        //    只要把之前的相关的字段都约定成统一的命名, 下面的操作就可以一步到位的完成整个转换
        String jsonData = gson.toJson(images);
        resp.getWriter().write(jsonData);//直接出现内容
    }

    private void selectOne(String imageId, HttpServletResponse resp) throws IOException {
        resp.setContentType("application/json; charset=utf-8");
        // 1. 创建 ImageDao 对象
        ImageDao imageDao = new ImageDao();
        Image image = imageDao.selectOne(Integer.parseInt(imageId));
        // 2. 使用 gson 把查到的数据转成 json 格式, 并写回给响应对象
        Gson gson = new GsonBuilder().create();
        String jsonData = gson.toJson(image);
        resp.getWriter().write(jsonData);
    }

    /**
     * 上传图片
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        // 1. 获取图片的属性信息, 并且存入数据库
        //  a) 需要创建一个 factory 对象 和 upload 对象, 这是为了获取到图片属性做的准备工作
        //     固定的逻辑
        FileItemFactory factory = new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        // b) 通过 upload 对象进一步解析请求(解析HTTP请求中奇怪的 body 中的内容)
        //    FileItem 就代表一个上传的文件对象.
        //    理论上来说, HTTP 支持一个请求中同时上传多个文件
        List<FileItem> items = null;
        try {
            items = upload.parseRequest(req);
        } catch (FileUploadException e) {
            // 出现异常说明解析出错!
            e.printStackTrace();
            // 告诉客户端出现的具体的错误是啥
            resp.setContentType("application/json; charset=utf-8");
            resp.getWriter().write("{ \"ok\": false, \"reason\": \"请求解析失败\" }");
            return;
        }
        //  c) 把 FileItem 中的属性提取出来, 转换成 Image 对象, 才能存到数据库中
        //     当前只考虑一张图片的情况
        FileItem fileItem = items.get(0);
        Image image = new Image();
        image.setImageName(fileItem.getName());
        image.setSize((int)fileItem.getSize());
        // 手动获取一下当前日期, 并转成格式化日期, yyyyMMdd => 20200218
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMdd");
        image.setUploadTime(simpleDateFormat.format(new Date()));
        image.setContentType(fileItem.getContentType());
        // MD5 暂时先不去计算 磁盘文件名用md5来命名
        image.setMd5(DigestUtils.md5Hex(fileItem.get()));
        // 自己构造一个路径来保存, 引入时间戳是为了让文件路径能够唯一
        image.setPath("./image/" + image.getMd5());
        // 存到数据库中
        ImageDao imageDao = new ImageDao();

        // 看看数据库中是否存在相同的 MD5 值的图片, 不存在, 返回 null
        Image existImage = imageDao.selectByMd5(image.getMd5());

        imageDao.insert(image);

        // 2. 获取图片的内容信息, 并且写入磁盘文件
        if (existImage == null) {
            File file = new File(image.getPath());//创建指定路径的文件
            try {
                //将FileItem对象中的内容保存到某个指定的文件中
                //最主要的用途是把上传的文件内容保存在本地文件系统中。
                fileItem.write(file);
            } catch (Exception e) {
                e.printStackTrace();

                resp.setContentType("application/json; charset=utf-8");
                resp.getWriter().write("{ \"ok\": false, \"reason\": \"写磁盘失败\" }");
                return;
            }
        }

        // 3. 给客户端返回一个结果数据
//        resp.setContentType("application/json; charset=utf-8");
//        resp.getWriter().write("{ \"ok\": true }");
        resp.sendRedirect("index.html");
    }

    /**
     * 删除指定图片
     * @param req
     * @param resp
     * @throws ServletException
     * @throws IOException
     */
    @Override
    /**
     * //  web.xml就是告诉服务器tomcat你的项目有哪些服务信息
     * 从Servlet的第一次请求开始（因为这时Servlet对象还没有创建），先执行new的操作（构造方法），
     * 再调用init()进行初始化。接着等待请求的到来，一旦有请求到来，service()方法被调用，
     * 根据请求类型决定调用doGet()/doPost()。只要有请求到来就会重复service()-->doGet()/doPost()这一过程。
     * 当服务器重启或者关闭时，destroy()方法被调用，进行销毁Servlet对象工作
     * ————————————————
     */
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        resp.setContentType("application/json; charset=utf-8");
        // 1. 先获取到请求中的 imageId
        String imageId = req.getParameter("imageId");
        if (imageId == null || imageId.equals("")) {
            resp.setStatus(200);
            resp.getWriter().write("{ \"ok\": false, \"reason\": \"解析请求失败\" }");
            return;
        }
        // 2. 创建 ImageDao 对象, 查看到该图片对象对应的相关属性(这是为了知道这个图片对应的文件路径)
        ImageDao imageDao = new ImageDao();
        Image image = imageDao.selectOne(Integer.parseInt(imageId));
        if (image == null) {
            // 此时请求中传入的 id 在数据库中不存在.
            resp.setStatus(200);
            resp.getWriter().write("{ \"ok\": false, \"reason\": \"imageId 在数据库中不存在\" }");
            return;
        }
        // 3. 删除数据库中的记录
        imageDao.delete(Integer.parseInt(imageId));
        // 4. 删除本地磁盘文件
        File file = new File(image.getPath());
        Image existImage = imageDao.selectByMd5(image.getMd5());
        if (existImage == null) {
            file.delete();
            resp.setStatus(200);
            resp.getWriter().write("{ \"ok\": true }");
        }
    }
}
