//package lab;
//
//import com.alibaba.fastjson.JSONArray;
//import dapaixing.DBConfig;
//
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.IOException;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//
//@WebServlet("/rank.json")
//public class RankSv extends HttpServlet  {
//    @Override
//    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        resp.setContentType("apalication/json,charset=utf-8") ;
//
//        String condition=req.getParameter("condition");
//        if(condition==null){
//            condition="8";
//        }
//        JSONArray json=new JSONArray();
//        try {
//            Connection connection= DBConfig.getConnection();
//            String sql="SELECT author,count(*)as cnt from tangpoetry ordey by author having cnt>=? group by cnt desc";
//            PreparedStatement statement=connection.prepareStatement(sql);
//            statement.setString(1,condition);
//            ResultSet result=statement.executeQuery();
//            while(result.next()){
//                String author=result.getString("author");
//                int con=result.getInt("cnt");
//                JSONArray js=new JSONArray();
//                js.add(author);
//                js.add(con);
//                json.addAll(js);
//            }
//            resp.getWriter().write(json.toJSONString());
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//
//    }
//}
