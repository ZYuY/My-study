package lin;

import com.gargoylesoftware.htmlunit.BrowserVersion;
import com.gargoylesoftware.htmlunit.WebClient;
import com.gargoylesoftware.htmlunit.html.HtmlElement;
import com.gargoylesoftware.htmlunit.html.HtmlPage;

import java.io.File;
import java.io.IOException;
import java.util.List;
public class HtmlDemo {
    //列表页下载提取Demo
    public static void main(String[] args) throws IOException {
        //无界面的浏览器（HTTP客户端）
        WebClient webclient=new WebClient(BrowserVersion.CHROME);
        //关闭了浏览器的js执行引擎,不再执行网页中的js脚本
        webclient.getOptions().setJavaScriptEnabled(false);
        //关闭了浏览器的css执行引擎，不再执行css布局
        webclient.getOptions().setCssEnabled(false);
        //列表页的访问功能
        HtmlPage page=webclient.getPage("https://so.gushiwen.org/gushi/tangshi.aspx");
        System.out.println(page);
        File file=new File("target\\唐诗三百首\\列表页.html");
        file.delete();
        page.save(file);
        //如何从html中提取我们需要的信息
       HtmlElement body= page.getBody();
      List<HtmlElement > elements=body.getElementsByAttribute("div","class","typecont");//元素  标签  标签的值
//
       HtmlElement divelement=elements.get(0);
        List<HtmlElement > aelements= divelement.getElementsByAttribute("a","target","_blank");
        for(HtmlElement e:aelements){
            System.out.println(e);
        }
        System.out.println(aelements.size());

        System.out.println(aelements.get(0).getAttribute("href"));
    }
}
