//package 单线程版本;
//
//import com.gargoylesoftware.htmlunit.BrowserVersion;
//import com.gargoylesoftware.htmlunit.TextPage;
//import com.gargoylesoftware.htmlunit.WebClient;
//import com.gargoylesoftware.htmlunit.html.DomText;
//import com.gargoylesoftware.htmlunit.html.HtmlElement;
//import com.gargoylesoftware.htmlunit.html.HtmlPage;
//
//import java.io.UnsupportedEncodingException;
//import java.sql.Connection;
//import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
//import org.ansj.domain.Term;
//import org.ansj.splitWord.analysis.NlpAnalysis;
//import org.omg.CORBA.DATA_CONVERSION;
//
//import javax.smartcardio.TerminalFactory;
//import javax.sql.DataSource;
//import java.io.IOException;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.ArrayList;
//import java.util.List;
//import java.util.concurrent.CountDownLatch;
//import java.util.concurrent.ExecutorService;
//import java.util.concurrent.Executors;
//
//public class Single {
//   private static class Job implements Runnable {
//        private String url;
//        private DataSource datasource;
//        //private MessageDigest messageDigest;
//private  CountDownLatch countDownLatch;
//        Job(String url, DataSource dataSource,CountDownLatch countDownLatch) {
//            this.url = url;
//            //this.messageDigest = messageDigest;
//            this.datasource = dataSource;
//            this.countDownLatch=countDownLatch;
//        }
//
//        @Override
//        public void run() {
//            WebClient webclient = new WebClient(BrowserVersion.CHROME);
//            webclient.getOptions().setCssEnabled(false);
//            webclient.getOptions().setJavaScriptEnabled(false);
//
//            MessageDigest messageDigest = null;
//            try {
//                messageDigest = MessageDigest.getInstance("SHA-256");
//            } catch (NoSuchAlgorithmException e) {
//                e.printStackTrace();
//            }
//
//            HtmlPage htmlPage = null;
//            try {
//                htmlPage = webclient.getPage(url);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            String xpath;
//            DomText domTest;
//            //标题
//            xpath = "//div[@class='cont']/h1/text()";
//            domTest = (DomText) htmlPage.getBody().getByXPath(xpath).get(0);
//            String title = domTest.asText();
//            //朝代
//            xpath = "//div[@class='cont']/p[@class='source']/a[1]/text()";
//            domTest = (DomText) htmlPage.getBody().getByXPath(xpath).get(0);
//            String dynasty = domTest.asText();
//            //作者
//            xpath = "//div[@class='cont']/p[@class='source']/a[2]/text()";
//            domTest = (DomText) htmlPage.getBody().getByXPath(xpath).get(0);
//            String author = domTest.asText();
//            //正文
//            xpath = "//div[@class='cont']/div[@class='contson']";
//            HtmlElement element = (HtmlElement) htmlPage.getByXPath(xpath).get(0);
//            String content = element.getTextContent().trim();
//            //计算sha-256(避免下载重复诗词)
//            String s = title + content;
//            try {
//                messageDigest.update(s.getBytes("UTF-8"));
//            } catch (UnsupportedEncodingException e) {
//                e.printStackTrace();
//            }
//            byte[] bytes = messageDigest.digest();
//            StringBuilder sha256 = new StringBuilder();
//            for (byte a : bytes) {
//                sha256.append(String.format("%02x", a));
//            }
//            //计算分词
//            List<Term> termList = new ArrayList<>();
//            termList.addAll(NlpAnalysis.parse(title).getTerms());
//            termList.addAll(NlpAnalysis.parse(content).getTerms());
//            List<String> words = new ArrayList<>();
//            //去除特殊字符
//            for (Term t : termList) {
//                if (t.getNatureStr().equals("w")) {//w是标点符号
//                    continue;
//                }
//                if (t.getNatureStr().equals("null")) {
//                    continue;
//                }
//                if (t.getNatureStr().length() < 2) {
//                    continue;
//                }
//                words.add(t.getRealName());
//            }
//            String insertWords = String.join(",", words);//拼接分词
//            //将数据写入到数据库中
//            try(Connection connection=datasource.getConnection()) {
//                String sql = "INSERT INTO tangpoetry(sha256, dynasty,title,author,content,words)values(?,?,?,?,?,?)";
//                PreparedStatement statement = connection.prepareStatement(sql);
//                statement.setString(1, sha256.toString());
//                statement.setString(2, dynasty);
//                statement.setString(3, title);
//                statement.setString(4, author);
//                statement.setString(5, content);
//                statement.setString(6, insertWords);
//                statement.executeUpdate();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//
//    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, SQLException, InterruptedException {
//        ExecutorService pool= Executors.newFixedThreadPool(30);
//
//
//       //获取列表页
//        WebClient webclient = new WebClient(BrowserVersion.CHROME);
//        webclient.getOptions().setCssEnabled(false);
//        webclient.getOptions().setJavaScriptEnabled(false);
//        String baseUrl = "https://so.gushiwen.org";
//        String pathUrl = "/gushi/tangshi.aspx";
//        HtmlPage page = webclient.getPage(baseUrl + pathUrl);
//        //解析列表页，获取详情页url
//        List<HtmlElement> urls = page.getBody().getElementsByAttribute("div", "class", "typecont");
//        List<String> list = new ArrayList<>();
//        for (HtmlElement e : urls) {
//            List<HtmlElement> li = e.getElementsByTagName("a");
//            for (HtmlElement h : li) {
//                String s = h.getAttribute("href");
//                list.add(baseUrl + s);
//            }
//        }
//
//        MysqlConnectionPoolDataSource msqldatasource = new MysqlConnectionPoolDataSource();
//        msqldatasource.setServerName("127.0.0.1");
//        msqldatasource.setUseSSL(false);
//        msqldatasource.setPort(3306);
//        msqldatasource.setUser("root");
//        msqldatasource.setPassword("mysql");
//        msqldatasource.setDatabaseName("2020-1-9-唐诗");
//        msqldatasource.setCharacterEncoding("UTF-8");
//
////        Connection connection = msqldatasource.getConnection();
////        String sql = "INSERT INTO tangpoetry(sha256, dynasty,title,author,content,words)values(?,?,?,?,?,?)";
////        PreparedStatement statement = connection.prepareStatement(sql);
////        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
//        //解析详情页
//        CountDownLatch countDownLatch=new CountDownLatch(list.size());
//        for (String url : list) {
//            Thread thread=new Thread(new Job(url,msqldatasource,countDownLatch));
//            thread.start();
//            countDownLatch.await();
//            pool.shutdown();
////            HtmlPage htmlPage=webclient.getPage(url);
////            String xpath;
////            DomText domTest;
////            //标题
////            xpath = "//div[@class='cont']/h1/text()";
////            domTest=(DomText) htmlPage.getBody().getByXPath(xpath).get(0);
////            String title=domTest.asText();
////            //朝代
////            xpath="//div[@class='cont']/p[@class='source']/a[1]/text()";
////            domTest=(DomText)htmlPage.getBody().getByXPath(xpath).get(0);
////            String dynasty=domTest.asText();
////            //作者
////            xpath = "//div[@class='cont']/p[@class='source']/a[2]/text()";
////           domTest = (DomText) htmlPage.getBody().getByXPath(xpath).get(0);
////          String author = domTest.asText();
////            //正文
////            xpath = "//div[@class='cont']/div[@class='contson']";
////            HtmlElement element=(HtmlElement)htmlPage.getByXPath(xpath).get(0);
////            String content=element.getTextContent().trim();
////            //计算sha-256(避免下载重复诗词)
////            String s=title+content;
////            messageDigest.update(s.getBytes("UTF-8"));
////            byte[]bytes=messageDigest.digest();
////            StringBuilder sha256=new StringBuilder();
////            for(byte a:bytes){
////                sha256.append(String.format("%02x",a));
////            }
////            //计算分词
////            List<Term>termList=new ArrayList<>();
////            termList.addAll(NlpAnalysis.parse(title).getTerms());
////            termList.addAll(NlpAnalysis.parse(content).getTerms());
////            List<String>words=new ArrayList<>();
////            //去除特殊字符
////            for(Term t:termList){
////                if(t.getNatureStr().equals("w")){//w是标点符号
////                    continue;
////                }
////                if(t.getNatureStr().equals("null")){
////                    continue;
////                }
////                if(t.getNatureStr().length()<2){
////                    continue;
////                }
////                words.add(t.getRealName());
////            }
////            String insertWords=String.join(",",words);//拼接分词
////            //将数据写入到数据库中
////            statement.setString(1, sha256.toString());
////           statement.setString(2, dynasty);
////           statement.setString(3, title);
////           statement.setString(4, author);
////          statement.setString(5, content);
////          statement.setString(6, insertWords);
////          statement.executeUpdate();
////            }
//        }
//
//    }
//}
