package testngreport;

import org.testng.annotations.*;

public class TestNGReportDemo {

    @BeforeClass
    public void setUp(){
        System.out.println("beforeClass——>>>>>>来自TestNGReportDemo类");
    }
    @AfterClass
    public void tearDown(){

        System.out.println("afterClass——>>>>>>来自TestNGReportDemo类");
    }
    @BeforeMethod
    public void beforeMethod() {

        System.out.println("beforeMethod——>>>>>>来自TestNGReportDemo类>>>>beforeMethod");
    }
    @AfterMethod
    public void afterMethod() {

        System.out.println("afterMethod——>>>>>>来自TestNGReportDemo类>>>>afterMethod");
    }
    @Test
    public void testAdd(){

        System.out.println("这是TestNGReportDemo类中的第一个测试方法------------->>>>>>");
    }
    @Test
    public void testMethod(){

        System.out.println("这是TestNGReportDemo类中的第二个测试方法------------->>>>>>");
    }

}
