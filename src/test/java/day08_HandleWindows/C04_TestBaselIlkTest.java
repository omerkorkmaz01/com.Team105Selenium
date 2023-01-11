package day08_HandleWindows;

import org.junit.Assert;
import org.junit.Test;
import utilities.ReusableMethods;
import utilities.TestBase;

public class C04_TestBaselIlkTest extends TestBase {

    @Test
    public void test01() {

        // amazon'a gidin
        driver.get("https://www.amazon.com");

        // amazona'a gittiginizi test edin

        String exceptedKelime= "amazon";
        String actualUrl= driver.getCurrentUrl();

        Assert.assertTrue(actualUrl.contains(exceptedKelime));

        ReusableMethods.bekle(3);
    }
}
