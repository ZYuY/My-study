package dao;


import common.JavaImageServerException;
import sun.security.pkcs11.Secmod;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ImageDao {
    /**
     * 把image对象插入到数据库中
     * @param image
     */
    public  void insert(Image image)  {
        Connection connection=null;
        PreparedStatement statement=null;
        //1.获取数据库连接
         connection=DBUtil.getConnection();
        //2.创建并拼装SQL语句
        String sql="insert into image_table values(null,?,?,?,?,?,?)";
        try{
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
    public List<Image> selectAll() throws SQLException {
        List<Image>images=new ArrayList<Image>();
        //1.获取数据库连接
        Connection connection=DBUtil.getConnection();
        //2.构造sql语句
        String sql="select *from image_table";
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        //3.执行sql语句
        try {
            statement=connection.prepareStatement(sql);
             resultSet=statement.executeQuery();
            //4.处理结果集
            while(resultSet.next()){
                Image image=new Image();
                image.setImageId(resultSet.getInt("imageId"));
                image.setImageName(resultSet.getString("imageName"));
                image.setSize(resultSet.getInt("size"));
                image.setUploadTime(resultSet.getString("uploadTime"));
                image.setContentType(resultSet.getString("contentType"));
                image.setPath(resultSet.getString("path")) ;
                image.setMd5(resultSet.getString("md5")) ;
                images.add(image);
            }
            return images;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //5.关闭连接
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }

    /**
     * 根据imageId查找指定的图片
     * @param imageId
     * @return
     */
    public  Image selectOne(int imageId) {
        //1.获取数据库连接
        Connection connection= DBUtil.getConnection();
        //2.构造sql语句
        String sql="select *from image_table where imageId=?";
        PreparedStatement statement=null;
        ResultSet resultSet=null;
        //3.执行sql语句
        try {
            statement=connection.prepareStatement(sql);
            statement.setInt(1,imageId);
            resultSet=statement.executeQuery();
            //4.处理结果集
            while(resultSet.next()){
                Image image=new Image();
                image.setImageId(resultSet.getInt("imageId"));
                image.setImageName(resultSet.getString("imageName"));
                image.setSize(resultSet.getInt("size"));
                image.setUploadTime(resultSet.getString("uploadTime"));
                image.setContentType(resultSet.getString("contentType"));
                image.setPath(resultSet.getString("path")) ;
                image.setMd5(resultSet.getString("md5")) ;
                return image;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //5.关闭连接
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }

    /**
     * 根据imageId删除指定图片
     * @param imageId
     */
    public void delete(int imageId){
        //1.获取数据库连接
        Connection connection=DBUtil.getConnection();
        //2.拼装sql语句
        String sql="delete from image_table where imageId=?";
        PreparedStatement statement=null;
        //3.执行sql语句
        try {
            statement=connection.prepareStatement(sql);
            statement.setInt(1,imageId);
           int ret=statement.executeUpdate();
           if(ret!=1){
               throw new JavaImageServerException("删除数据库操作失败");
           }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JavaImageServerException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close(connection,statement,null);
        }
        //4.关闭连接
    }
//如果mysql在云服务器上，需要打jar包，把jar包拷贝到云服务器上就可以执行了
    public static void main(String[] args) {
        //用于进行简单的测试
        //1.测试插入数据
//        Image image=new Image();
//        image.setImageName("1.png");
//        image.setSize(100);
//        image.setUploadTime("20200220");
//        image.setContentType("/image/png");
//        image.setPath("./data/1.png");
//        image.setMd5("1232435");
//
//        ImageDao imagedao=new ImageDao();
//        imagedao.insert(image);
        //2.测试查找图片信息
//        ImageDao imageDao=new ImageDao();
//        List<Image>lists= null;
//        try {
//            lists = imageDao.sellectAll();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        System.out.println(lists);
        //3.测试查找指定imageId图片的信息
//
        //4.测试删除图片
        ImageDao imageDao=new ImageDao();
        imageDao.delete(1);
        System.out.println(imageDao);
    }
}
