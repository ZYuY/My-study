import java.io.UnsupportedEncodingException;

public class helloServlet extends   HttpServlet {
    /**
     * cookie
     * @param req
     * @param resp
     */
    @Override
    public void doGet(Request req, Response resp) {
        resp.setStatus("200 OK") ;
        resp.setHeader("Content-Type","text/plain;charset=UTF-8");
        resp.setHeader("X-Teacher","peixinchen");
        resp.setHeader("X-student","201");
        String target=req.parameters.get("target");
        //两次状态通过Cookie保存下来
        String currentUser="未登录";
        String cookie=req.headers.get("Cookie");
        if(cookie!=null){
            currentUser=cookie.split("=")[1];
        }

        resp.setHeader("Set-Cookie", "target=" + target+";expires=Tue, 07-Apr-2020 08:46:16 GMT; Max-Age=8640000");
        resp.println("你好" + target);
        resp.println("当前用户"+currentUser);
    }
}
