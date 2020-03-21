package jsoup;

import org.apache.commons.io.FileUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class JsoupFirstTest {
    /**
     * 解析url
     * @throws IOException
     */
    @Test
    public void testUrl() throws IOException {
        //解析URL地址,第一个参数是访问的url，第二个参数是访问的超时时间
        Document doc = Jsoup.parse(new URL("http://www.itcast.cn"), 1000);
        //使用标签选择器，获取title标签中的内容
        String title = doc.getElementsByTag("title").first().text();
        System.out.println(title);

    }

    /**
     * 解析字符串
     * @throws Exception
     */
    @Test
    public void testString() throws Exception{
        //使用工具类读取文件，获取字符串
        String content = FileUtils.readFileToString(new File("C:\\Users\\BaiZe\\Desktop\\index.html"), "utf8");
        //解析字符串
        Document doc = Jsoup.parse(content);
        String title = doc.getElementsByTag("title").first().text();
        System.out.println(title);
    }

    /**
     * 解析文件
     * @throws Exception
     */
    @Test
    public void testFile() throws Exception{
        //解析文件
        Document doc = Jsoup.parse(new File("C:\\Users\\BaiZe\\Desktop\\index.html"), "utf8");
        //解析字符串
        String title = doc.getElementsByTag("title").first().text();
        System.out.println(title);
    }

    /**
     * DOM解析元素
     * @throws Exception
     */
    @Test
    public void testDom() throws Exception{
        //解析url，获取Document对象
        Document doc = Jsoup.parse(new URL("http://www.itcast.cn"), 1000);
        //获取元素
        //1.根据ID查询元素获取getElementById
        //Element element = doc.getElementById("webim");

        //2.根据标签获取元素getElementByTag
        //Element element = doc.getElementsByTag("span").first();

        //3.根据class获取元素getElementByClass
        //Element element = doc.getElementsByClass("dlstyle").first();

        //4.根据属性获取元素getElementByAttribute
        //Element element = doc.getElementsByAttribute("abc").first();
        Element element = doc.getElementsByAttributeValue("href", "http://sh.itcast.cn").first();

        //打印元素的内容
        System.out.println("获取到的元素内容========"+element.text());
    }

    /**
     * 选择器解析
     * @throws Exception
     */
    @Test
    public void testSelector() throws Exception{
        //解析url地址，获取document对象
        Document doc = Jsoup.parse(new URL("http://www.itcast.cn"), 1000);

        //tagname: 通过标签查找元素，比如span
//        Elements elements = doc.select("span");
//        for (Element element : elements) {
//            System.out.println(element.text());
//        }

        //#id:通过ID查找元素，比如:#city_id
//        Element element = doc.select("#city_bj").first();
//        System.out.println(element);

        //.class:通过class名称查找元素，比如:.class_a
//        Element element = doc.select(".class_a").first();
//        System.out.println(element);

        //[attribute]:利用属性查找元素，比如：[abc]
//        Element element = doc.select("[abc]").first();
//        System.out.println(element);

        //[attr=value]:利用属性值来查找元素，例如：[class=]
        Elements elements = doc.select("[class=wrap]");
        for (Element element : elements) {
            System.out.println(element.text());
        }
    }

    @Test
    public void testSelector2() throws Exception{
        //解析url地址，获取document对象
        Document doc = Jsoup.parse(new URL("http://www.itcast.cn"), 1000);

        //el#id:元素+ID，比如： h3#city_bj
        //Element element = doc.select("h3#city_bj").first();

        //el.class:元素+class,比如： li.class_a
        //Element element = doc.select("li.class_a").first();

        //el[attr]:元素+属性名,比如:span[abc]
        //Element element = doc.select("span[abc]").first();

        //任意组合：比如：span[abc].s_name
        //Element element = doc.select("span[abc].s_name").first();

        //ancestor child:查找某个元素下子元素，比如: .city_con li 查找"city_con"下的所有li
//        Elements elements = doc.select(".city_con li");
//        for (Element element : elements) {
//            System.out.println(element.text());
//        }

        //parent > child： 查找某个父元素下的直接子元素,比如
        //.city_con > ul > li 查找city_con第一级(直接子元素)的ul，再找所有ul下的第一级li
//        Elements elements = doc.select(".city_con > ul > li");
//        for (Element element : elements) {
//            System.out.println(element.text());
//        }

        //parent ? *： 查找某个父元素下所有直接子元素
        Elements elements = doc.select(".city_con > ul > *");
        for (Element element : elements) {
            System.out.println(element.text());
        }

        //System.out.println(element);

    }

}
