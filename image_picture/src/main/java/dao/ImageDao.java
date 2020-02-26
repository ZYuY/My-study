package dao;

import common.JavaImageServerException.JavaImageServerException;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class ImageDao {
    /**
     * 将image对象插入数据库表中
     */
    public  static void insert(Image image) {
        //1.建立连接
        Connection connection=DBUtil.getConnection();
        PreparedStatement statement=null;
        //2.构造mysql语句
        String sql="insert into image_table values(null,?,?,?,?,?,?)";
        try {
            statement=connection.prepareStatement(sql);
            statement.setString(1,image.getImageName());
            statement.setInt(2,image.getSize());
            statement.setString(3,image.getUploadTime());
            statement.setString(4,image.getContentType());
            statement.setString(5,image.getPath());
            statement.setString(6,image.getMd5());
            //3.执行sql语句
            int ret=statement.executeUpdate();
            if(ret!=1){
                //插入数据库异常
                throw new JavaImageServerException("插入数据库出错");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (JavaImageServerException e) {
            e.printStackTrace();
        } finally {
            //4.关闭连接
            DBUtil.close(connection,statement,null);
        }
    }
    /**
     *查询数据库中所有图片的信息
     */
    public  static List<Image>selectAll(){
        List<Image>lists=new ArrayList<>();
        //1.建立连接
        Connection connection=DBUtil.getConnection();
        PreparedStatement statement=null;
        //2.创建sql语句
        String sql="select * from image_table";
        ResultSet resultSet=null;
        try {
            statement=connection.prepareStatement(sql);
            //3.执行sql语句
            resultSet=statement.executeQuery();
            //4.处理结果集
            while(resultSet.next()){
                Image image=new Image();
                image.setImageId(resultSet.getInt("imageId"));
                image.setImageName(resultSet.getString("imageName"));
                image.setSize(resultSet.getInt("size"));
                image.setUploadTime(resultSet.getString("uploadTime"));
                image.setContentType(resultSet.getString("contentType"));
                image.setPath(resultSet.getString("path"));
                image.setMd5(resultSet.getString("md5"));
                lists.add(image);
            }
            return lists;
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            //5.关闭连接
            DBUtil.close(connection,statement,resultSet);
        }
        return null;
    }
}
