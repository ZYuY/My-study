import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//import com.mysql.jdbc.Driver;
public class Text {
    /**
     * Connection  mysql的网络连接
     * Statement    MySQL语句
     * @param args
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
       //1.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获取连接的地址
        Connection connection = (Connection)DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/student?useSSL=false",
                "root",
                "mysql"
        );
        //-1 记得关闭连接

        System.out.println(connection);
        connection.close();
    }
}
