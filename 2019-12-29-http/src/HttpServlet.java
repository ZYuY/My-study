import java.io.UnsupportedEncodingException;

public abstract class HttpServlet {
    public abstract void doGet(Request req, Response resp) throws UnsupportedEncodingException;

}
