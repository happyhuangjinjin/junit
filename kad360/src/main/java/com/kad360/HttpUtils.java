package com.kad360;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;

import java.io.IOException;

public class HttpUtils {

    public static String sendGet(String url){
        String result = null;
        //Creates CloseableHttpClient instance with default configuration.
        CloseableHttpClient httpCilent = HttpClients.createDefault();
        HttpGet httpGet = new HttpGet(url);
        try {
            CloseableHttpResponse response = httpCilent.execute(httpGet);
            result = EntityUtils.toString(response.getEntity()) ;
            System.out.println(result);
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                httpCilent.close();//释放资源
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        return result;
    }

    public static void main(String[] args) {
        sendGet("https://www.111.com.cn/categories/971295");
    }
}
