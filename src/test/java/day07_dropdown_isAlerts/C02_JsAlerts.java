package day07_dropdown_isAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_JsAlerts {

    // Gerekli olan ayarlamalari yapin
    // https://the.internet.herokuapp.com/javascript alerts adresine gidin
    // 3 test method'u oluturup her method'da bir JsAlert'e basin
    // ilgili method'lari kullanin

    static WebDriver driver;
    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @AfterClass
    public static void tearDown() throws InterruptedException {
        Thread.sleep(3000);
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the.internet.herokuapp.com/javascript_alerts");
        // 1. alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Alert']")).click();

        // Alert'deki yazinin "I am a JS Alert" oldugunu test edelim

        String actualAlertyazisi= driver.switchTo().alert().getText();
        String exceptedAlertYazisi="I am a JS Alert";
        Thread.sleep(3000);
        Assert.assertEquals(exceptedAlertYazisi,actualAlertyazisi);

        // OK tusuna basip alert'i kapatalim
        driver.switchTo().alert().accept();


    }

    @Test
    public void test02() throws InterruptedException {
        driver.get("https://the.internet.herokuapp.com/javascript_alerts");
        // 2.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Confirm']")).click();

        Thread.sleep(3000);

        // cancel'a basip, cikan sonuc yazisinin "You clicked: Cancel" oldugunu test edin
        driver.switchTo().alert().dismiss();

        String actualSonucYazisi= driver.findElement(By.xpath("//*[text()='You clicked: Cancel']"))
                                        .getText();
        String exceptedSonucYazisi="You clicked: Cancel";

        Assert.assertEquals(exceptedSonucYazisi,actualSonucYazisi);
    }

    @Test
    public void test03() throws InterruptedException {
        driver.get("https://the.internet.herokuapp.com/javascript_alerts");
        // 3.alert'e tiklayalim
        driver.findElement(By.xpath("//*[text()='Click for JS Prompt']")).click();

        // Cikan promt ekraninan "Abdullah" yazdiralim ve OK tusuna basarak alert'i kapatalim
        driver.switchTo().alert().sendKeys("Abdullah");
        Thread.sleep(3000);

        driver.switchTo().alert().accept();
        // Cikan sonuc yazisinin Abdullah icerdigini test edin
        String actualSonucYazisi= driver.findElement(By.xpath("//*[@id='result']"))
                .getText();
        String excepttedKelime="Abdullah";
        Assert.assertTrue(actualSonucYazisi.contains(excepttedKelime));
    }

}
