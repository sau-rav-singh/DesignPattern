package TestRunner;

import org.testng.annotations.Test;

public class TestNGTest {

    @Test(expectedExceptions = NumberFormatException.class, enabled = true)
    public void testNumberFormatException() {
        Integer str = Integer.parseInt("abc"); // This will throw a NumberFormatException
        System.out.println(str);
    }

}