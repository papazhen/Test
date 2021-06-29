package httpclient;

import org.apache.http.client.CookieStore;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.cookie.Cookie;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

public class MyCookiesForGet {
    private String url;
    private ResourceBundle bundle;
    private CookieStore store;

    @BeforeTest
    public void beforeTest(){
        //从配置文件中获取url
        bundle = ResourceBundle.getBundle("application", Locale.CHINA);
        url = bundle.getString("test.url");
    }

    @Test
    public void testGetCookies(){
        String rescult;
        //从配置文件中拼接url
        String uri = bundle.getString("getCookies.url");
        String testurl = url+uri;

        //逻辑代码
        HttpGet httpGet = new HttpGet(testurl);
        store = new BasicCookieStore();
        CloseableHttpClient client = HttpClients.custom().setDefaultCookieStore(store).build();
//        CloseableHttpClient client = HttpClients.createDefault();
        CloseableHttpResponse response = null;
        try {
            response = client.execute(httpGet);
            if (response.getStatusLine().getStatusCode() ==200){
                rescult = EntityUtils.toString(response.getEntity(),"utf8");
                System.out.println(rescult.length());
                System.out.println(rescult);
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
                client.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        //获取cookies
        List<Cookie> cookies = store.getCookies();
       for(Cookie cookie :cookies ){
           String name=cookie.getName();
           String value=cookie.getValue();
           System.out.println("cookie name =" + name);
           System.out.println("Cookie value=" + value);
       }

    }
}
