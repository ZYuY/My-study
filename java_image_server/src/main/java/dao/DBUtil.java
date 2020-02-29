package dao;


import com.mysql.jdbc.jdbc2.optional.MysqlDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
    private static final String  url="jdbc:mysql://127.0.0.1:3306/image_picture?characterEncoding=utf8&&useSSL=true";
    private  static  final  String USERNAME="root";
    private static  final  String PASSWORD="mysql";
    private  static DataSource dataSource=null;
    public  static  DataSource getDataSource(){
        //通过这个方法来创建DataSource的实例
        if(dataSource==null) {
            synchronized (DBUtil.class) {
                if (dataSource == null) {
                    dataSource = new MysqlDataSource();
                    MysqlDataSource tmpdataSource=(MysqlDataSource )dataSource;
                    tmpdataSource.setURL(url);
                    tmpdataSource.setUser(USERNAME);
                    tmpdataSource.setPassword(PASSWORD );
                    }
                }
            }
            return dataSource;
        }
        public  static Connection getConnection() {
            try {
                return  getDataSource() .getConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        }
        public  static  void close(Connection connection, PreparedStatement statement, ResultSet resultSet)  {
                try {
                    if(resultSet!=null)
                    resultSet.close();
                    if(statement!=null){
                        statement.close();
                    }
                    if(connection!=null){
                        connection.close();
                    }
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
