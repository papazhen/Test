package httpclient;

import com.alibaba.fastjson.JSONObject;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.HashMap;

public class TestDemo {
        @Test
        public void testUtilDoGet(){
            String result =  HttpClientUtil.doGet("https://www.baidu.com");
            System.out.println(result);
        }

        @Test
        public void testUtilDoGeWithtParam(){
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("age","2");
            String result = HttpClientUtil.doGet("https://reqres.in/api/users",param);
            System.out.println(result);
        }

        @Test
         public void testUtilDoPost(){
            String result = HttpClientUtil.doPost("https://reqres.in/api/users");
            System.out.println(result);
        }
        @Test
        public void testUtilDoPostWithParam(){
            HashMap<String, String> param = new HashMap<String, String>();
            param.put("name","morpheus");
            param.put("job","leader");
            String result = HttpClientUtil.doPost("https://reqres.in/api/users",param);
            System.out.println(result);
        }

        @Test
        public void testUtil(){
            String result = HttpClientUtil.doPost("http://api.stage.qjy1.com/common/api/v1/new/index");
            System.out.println(result);
        }

        @Test
        public void testUtil1(){
        HashMap<String, String> param = new HashMap<String, String>();
        param.put("email","eve.holt@reqres.in");
        param.put("password","cityslicka");
        String result = HttpClientUtil.doPost("https://reqres.in/api/login",param);
        System.out.println(result);
        //结果转换为json格式
        JSONObject resultJson = (JSONObject) JSONObject.parse(result);
        System.out.println(resultJson);
        //json里取出一个参数结果的值
        Object token = resultJson.get("token");
        System.out.println(token);
        //比较两个值
        Assert.assertEquals("token","QpwL5tke4Pnpja7X4","asdasdas");
    }
}

