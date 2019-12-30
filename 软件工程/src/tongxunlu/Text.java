package tongxunlu;
import  java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Text {
    public static void main(String[] args) {
        Connection con;
        String driver="com.mysql.jdbc.Driver";
        String url="jdbc:mysql://localhost:3306/tongxunlu";
        String user="root";
        String password="mysql";
        try{
            Class.forName(driver);
            //1.连接数据库
            con= DriverManager.getConnection(url,user,password);
            //2/创建statement类对象，执行mysql语句
            Statement statement=con.createStatement();
            Contactmanage.access();


            //要执行的sql语句
            String sql="select * from person";
            //3.ResultSet类，用来存放获取的结果集
            ResultSet rs=statement.executeQuery(sql);
            String name=null;
            String id=null;
            while(rs.next()){
                //获取stuname这列数据
                name=rs.getString("name");
                System.out.println(name);
            }
        }catch(Exception  e){

        }finally{
            System.out.println("数据库数据获取成功");
        }
    }
}
