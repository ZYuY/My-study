package bin;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.IOException;
import java.util.List;

public class 列表页下载提取Demo {
    public static void main(String[] args)throws IOException {
        WebClient webclient=new WebClient(BrowserVersion.CHROME);
        //关闭了浏览器的js执行引擎,不再执行网页中的js脚本
        webclient.getOptions().setJavaScriptEnabled(false);
        //关闭了浏览器的css执行引擎，不再执行css布局
        webclient.getOptions().setCssEnabled(false);
        //列表页的访问功能
        HtmlPage page=webclient.getPage("https://so.gushiwen.org/gushi/tangshi.aspx");
        HtmlElement body=page.getBody();
        List<HtmlElement> elements=body.getElementsByAttribute("div","class","typecont");
        int count=0;
        for(HtmlElement e:elements){
            List<HtmlElement>aelements=e.getElementsByTagName("a");
            for(HtmlElement ae:aelements){
                System.out.println( ae.getAttribute("href"));
                count++;
            }
        }
        System.out.println(count);
    }
}
