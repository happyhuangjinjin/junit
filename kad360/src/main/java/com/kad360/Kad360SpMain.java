package com.kad360;

        import org.htmlparser.Node;
        import org.htmlparser.NodeFilter;
        import org.htmlparser.Parser;
        import org.htmlparser.filters.NodeClassFilter;
        import org.htmlparser.tags.LinkTag;
        import org.htmlparser.util.NodeList;

        import java.util.ArrayList;
        import java.util.Collections;
        import java.util.List;

public class Kad360SpMain {

    public static  String getCategories(){
        String html =  HttpUtils.sendGet("https://www.111.com.cn/categories/");
        return html;
    }

    public static List<String> processCategoriesHtml(String html){
        List<String> links = new ArrayList<String>();
        if(html!=null && !"".equals(html.trim())){
            try {
                Parser parser = new Parser(html);
                //定义一个Filter，过滤主题em
                NodeFilter afilter = new NodeClassFilter(LinkTag.class);//A过滤器
                NodeList nodeList =  parser.extractAllNodesThatMatch(afilter);
                for(int i=0; i<nodeList.size(); i++){
                    Node aNode =  nodeList.elementAt(i);
                    LinkTag aLinkTag =  (LinkTag)aNode;
                    if(aLinkTag.getLink()!=null && aLinkTag.getLink().contains("categories")){
                        links.add(aLinkTag.getLink());
                        System.out.println(aLinkTag.getLink());
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        return links;
    }

    public static String getDLS_Html(){
        String html =  HttpUtils.sendGet("https://www.111.com.cn/categories/965327-j1");
        return html;
    }

    public static List<String> processDLSHtml(String html){
        List<String> links = new ArrayList<String>();
        if(html!=null && !"".equals(html.trim())){
            try {
                Parser parser = new Parser(html);
                //定义一个Filter，过滤主题em
                NodeFilter afilter = new NodeClassFilter(LinkTag.class);//A过滤器
                NodeList nodeList =  parser.extractAllNodesThatMatch(afilter);
                for(int i=0; i<nodeList.size(); i++){
                    Node aNode =  nodeList.elementAt(i);
                    LinkTag aLinkTag =  (LinkTag)aNode;
                    if(aLinkTag.getLink()!=null && aLinkTag.getLink().contains("product")){
                        links.add(aLinkTag.getLink());
                        System.out.println(aLinkTag.getLink());
                    }
                }
            }catch (Exception e){
                e.printStackTrace();
            }

        }
        return links;
    }

    public static String getDLSDetail_Html(String url){
        String html =  HttpUtils.sendGet("https:"+url);
        return html;
    }

    public static void main(String[] args) {
//        processCategoriesHtml(getCategories());
        List<String> list = processDLSHtml(getDLS_Html());
        for( int i=0; i<list.size(); i++){
            getDLSDetail_Html(list.get(i));
            break;
        }
    }

}
