package dao;

import common.JavaImageServerException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class ImageDao {
    /**
     * 把image对象插入到数据库中
     * @param image
     */
    Connection  connection=null;
    PreparedStatement statement=null;
    public  void insert(Image image)  {
        //1.获取数据库连接
        try{
         connection=DBUtil.getConnection();
        //2.创建并拼装SQL语句
        String sql="insert into image_table values(null,?,?,?,?,?,?)";
             statement=connection.prepareStatement(sql);
            statement.setString(1,image.getImageName());
            statement.setInt(2,image.getSize());
            statement.setString(3,image.getUploadTime());
            statement.setString(4,image.getContentType());
            statement.setString(5,image.getPath());
            statement.setString(6,image.getMd5());
            //3.执行SQL语句
            int ret=statement.executeUpdate();
            if(ret!=1){
                //程序出现问题需要抛出异常
                throw new JavaImageServerException("插入数据库出错");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JavaImageServerException e) {
            e.printStackTrace();
        }finally {
            DBUtil .close(connection,statement,null);
        }

        //4.关闭连接和statement对象
    }

    /**
     * 查找数据库中所有图片的信息
     * @return
     */
    public List<Image> sellectAll(){
        return null;
    }

    /**
     * 根据imageId查找指定的图片
     * @param imageId
     * @return
     */
    public  Image selectOne(int imageId){
        return null;
    }

    /**
     * 根据imageId删除指定图片
     * @param imageId
     */
    public void delete(int imageId){

    }
//如果mysql在云服务器上，需要打jar包，把jar包拷贝到云服务器上就可以执行了
    public static void main(String[] args) {
        //用于进行简单的测试
        //1.测试插入数据
        Image image=new Image();
        image.setImageName("1.png");
        image.setSize(100);
        image.setUploadTime("20200220");
        image.setContentType("/image/png");
        image.setPath("./data/1.png");
        image.setMd5("1232435");

        ImageDao imagedao=new ImageDao();
        imagedao.insert(image);

    }
}
