package day13_writeExcel_Screenshot;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.RemoteWebElement;
import utilities.ReusableMethods;
import utilities.TestBase;

import javax.print.DocFlavor;
import java.io.File;
import java.io.IOException;

public class C03_TakeScreenshotTumSayfa extends TestBase {

    @Test
    public void test01() throws IOException {
        // amazon'a gidip
        driver.get("https://www.amazon.com");
        // Nutella aratin
        WebElement aramaKutusu=driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Nutella"+ Keys.ENTER);
        // arama sonuclarinin Nutella icerdigini test edin
        WebElement aramaSonucElementi= driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String expectedKelime="Nutella";
        String actualKelime="Nutella";
        String actualAramaSonucu= aramaSonucElementi.getText();

        Assert.assertTrue(actualAramaSonucu.contains(expectedKelime));
        // Tum sayfanin screenshot'ini alin

       ReusableMethods.tumSayfaScreenshotCek(driver);

        ReusableMethods.bekle(5);
    }
}
