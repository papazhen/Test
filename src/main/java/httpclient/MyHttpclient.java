package httpclient;

import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;

import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.Test;

import java.io.IOException;

public class MyHttpclient {

    @Test
    public void test1(){
        //创建Httpclient对象
        CloseableHttpClient httpClient = HttpClients.createDefault();
        //创建HttpGet对象，设置url访问地址
        HttpGet httpGet = new HttpGet("http://www.baidu.com");
        CloseableHttpResponse response = null;
        try {
            //调用HttpClient对象的execute(HttpUriRequest request)发送请求，该方法返回一个HttpResponse
             response = httpClient.execute(httpGet);

            //调用getStatusLine().getStatusCode()可以获取响应状态码。
            if (response.getStatusLine().getStatusCode() ==200){
                //调用HttpResponse的getAllHeaders()、getHeaders(String name)等方法可获取服务器的响应头；调用HttpResponse的getEntity()方法可获取HttpEntity对象，
                // 该对象包装了服务器的响应内容
                String content = EntityUtils.toString(response.getEntity(), "utf8");
                System.out.println(content.length());
                System.out.println(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                response.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                //释放连接
                httpClient.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
}
