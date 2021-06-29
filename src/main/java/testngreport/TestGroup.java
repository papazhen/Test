package testngreport;

import org.testng.Reporter;
import org.testng.annotations.*;

import static org.testng.AssertJUnit.assertEquals;

public class TestGroup {
    @Test
    public void testCase1(){
        assertEquals(2+2, 4);
    }

    @Test
    public void testCase2(){
        assertEquals(5-3, 2);
    }

    @Test
    public void testCase3(){
        assertEquals(2/1, 2);
    }

    @Test
    public void testCase4(){
        assertEquals(3/1, 8);
    }

    @Test
    public void testCase5(){
        assertEquals(4/1, 4);
    }

    @Test
    public void logDemo(){
        Reporter.log("这是我自己的日志");
        throw new RuntimeException("这是我自己的异常");
    }


}
