import org.junit.*;

public class TestClass {




    @Test
    public void test1() {
        System.out.println("Test 1");
        Assert.assertEquals("Diese Nachricht ist nie zu sehen","Richitger Text","Richitger Text");
    }

    @Test
    public void test2() {
        System.out.println("Test 2");
        Assert.assertEquals("Diese Nachricht ist immer zu sehen","Falscher Text","Richitger Text");
    }
}
