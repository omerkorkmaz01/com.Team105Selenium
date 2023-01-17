package day10_FileTests;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import net.bytebuddy.implementation.auxiliary.MethodCallProxy;
import org.apache.commons.compress.parallel.FileBasedScatterGatherBackingStore;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.ReusableMethods;
import utilities.TestBase;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C02_FileDownloadTesti extends TestBase {
    @Test
    public void test01(){
        //2. https://the-internet.herokuapp.com/download adresine gidelim.
        driver.get("https://the-internet.herokuapp.com/download");
        //3. luminoslogo.png dosyasını indirelim
        driver.findElement(By.xpath("//a[text()='luminoslogo.png']")).click();
        ReusableMethods.bekle(5);

        //4. Dosyanın başarıyla indirilip indirilmediğini test edelim
        // Test icin oncelikle dosyanin indirildiginde dosyaYolu ne olacak bunu olusturmaliyiz

        String dosyaYolu=System.getProperty("user.home")+ "\\Downloads\\luminoslogo.png";

        // Bir dosyanin bilgisarayinizda var oldugunu test etmek icin
        // Java'daki Files class'indan yardim alacagiz

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }

    @Test
    public void test02(){
        // Masaustunde java.docx dosyasi oldugunu test edin

        // dinamik dosya yolu olusturalim

        String dosyaYolu= System.getProperty("user.home")+"\\Desktop\\java.docx";

        // Assert edelim

        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }

}
