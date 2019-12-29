import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public  class LoginServlet extends HttpServlet {
    public void doGet(Request req, Response resp) throws UnsupportedEncodingException {
        String username = req.parameters.get("username");
        resp.setStatus("200 OK");
        resp.setHeader("Content-Type","text/html;charset=UTF-8") ;
//        String currentUser="未登录";
//        String cookie=req.headers.get("Cookie");
//        if(cookie!=null){
//            currentUser=cookie.split("=")[1];
//        }
        if (username == null) {
            resp.setStatus("401 Unauthorized");
            resp.println("<h1>请登录</h1>");
            return;
        }
       resp.setHeader("Set-Cookie", "username=" + username);
        resp.println("<h1>欢迎" + username + "光临</h1>");
        //resp.println("当前用户"+currentUser);
    }
}
