//package 单线程版本;
//
//import com.gargoylesoftware.htmlunit.BrowserVersion;
//import com.gargoylesoftware.htmlunit.WebClient;
//import com.gargoylesoftware.htmlunit.html.DomText;
//import com.gargoylesoftware.htmlunit.html.HtmlElement;
//import com.gargoylesoftware.htmlunit.html.HtmlPage;
//import java.sql.Connection;
//import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;
//import org.ansj.domain.Term;
//import org.ansj.splitWord.analysis.NlpAnalysis;
//
//import java.io.IOException;
//import java.security.MessageDigest;
//import java.security.NoSuchAlgorithmException;
//import java.sql.PreparedStatement;
//import java.sql.SQLException;
//import java.util.AbstractList;
//import java.util.ArrayList;
//import java.util.List;
//
//public class SingleThreadCatch {
//    public static void main(String[] args) throws IOException, NoSuchAlgorithmException, SQLException {
//        WebClient client = new WebClient(BrowserVersion.CHROME);
//        client.getOptions().setJavaScriptEnabled(false);
//        client.getOptions().setCssEnabled(false);
//
//        String baseurl = "https://so.gushiwen.org";
//        String pathurl = "/gushi/tangshi.aspx";
//        List<String> detailUrlList = new ArrayList<>();//所有古诗的详情页的url
//        //列表页的解析
//        {
//            String url = baseurl + pathurl;
//            HtmlPage page = client.getPage(url);//获取诗词页面
//            List<HtmlElement> divs = page.getBody().getElementsByAttribute("div", "class", "typecont");
//            for (HtmlElement div : divs) {
//                List<HtmlElement> as = div.getElementsByTagName("a");
//                for (HtmlElement a : as) {
//                    String detailUrl = a.getAttribute("href");
//                    detailUrlList.add(baseurl + detailUrl);
//                }
//            }
//        }
//        MysqlConnectionPoolDataSource datasource=new MysqlConnectionPoolDataSource();
//        datasource.setServerName("127.0.0.1");
//        datasource.setPort(3306);
//        datasource.setUser("root");
//        datasource.setPassword("mysql");
//        datasource.setDatabaseName("2020-1-9-唐诗");
//        datasource.setUseSSL(false);
//        datasource.setCharacterEncoding("UTF-8");
//
//        Connection connection=datasource.getConnection();
//        String sql="INSERT INTO tangpoetry(sha256, dynasty,title,author,content,words)values(?,?,?,?,?,?)";
//        PreparedStatement statement=connection.prepareStatement(sql);
//
//
//        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
//
//        //详情页的请求和解析
//
//        for (String url : detailUrlList) {
//            HtmlPage page = client.getPage(url);
//            String xpath;
//            DomText domText;
//            //标题
//            xpath = "//div[@class='cont']/h1/text()";
//            domText = (DomText) page.getBody().getByXPath(xpath).get(0);
//            String title = domText.asText();
//            //朝代
//            xpath = "//div[@class='cont']/p[@class='source']/a[1]/text()";
//            domText = (DomText) page.getBody().getByXPath(xpath).get(0);
//            String dynasty = domText.asText();
//            //作者
//            xpath = "//div[@class='cont']/p[@class='source']/a[2]/text()";
//            domText = (DomText) page.getBody().getByXPath(xpath).get(0);
//            String author = domText.asText();
//            //正文
//            xpath = "//div[@class='cont']/div[@class='contson']";
//            HtmlElement element = (HtmlElement) page.getByXPath(xpath).get(0);
//            String content = element.getTextContent().trim();
//
//            //1.计算sha256
//            String s = title + content;
//            messageDigest.update(s.getBytes("UTF-8"));
//            byte[] result = messageDigest.digest();
//            StringBuilder sha256 = new StringBuilder();
//            for (byte b : result) {
//                sha256.append(String.format("%02x", b));
//            }
//            //2.计算分词
//            List<Term> termList = new ArrayList<>();
//            termList.addAll(NlpAnalysis.parse(title).getTerms());//标题分词
//            termList.addAll(NlpAnalysis.parse(content).getTerms());//正文分词
//            List<String> words = new ArrayList<>();
//            //去除特殊字符
//            for (Term term : termList) {
//                if (term.getNatureStr().equals("w")) {
//                    continue;
//                }
//                if (term.getNatureStr().equals("null")) {
//                    continue;
//                }
//                if (term.getNatureStr().length() < 2) {
//                    continue;
//                }
//                words.add(term.getRealName());
//            }
//            String insertWords = String.join(",", words);//拼接分词
//
//            statement.setString(1, sha256.toString());
//            statement.setString(2, dynasty);
//            statement.setString(3, title);
//            statement.setString(4, author);
//            statement.setString(5, content);
//            statement.setString(6, insertWords);
//
//            com.mysql.jdbc.PreparedStatement mysqlStatement = (com.mysql.jdbc.PreparedStatement) statement;
//            System.out.println(mysqlStatement.asSql());
//            statement.executeUpdate();
//
//
//        }
//    }
//}
//
