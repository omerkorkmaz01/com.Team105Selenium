package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_BestBuyAssertion {

    /*
    1) Bir class olusturun: BestBuyAssertions
    2) https://www.bestbuy.com/ Adresine gidin farkli test method'lari olusturacak
    3) asagidaki testleri yapin
    ✧Sayfa URL'inin https://www.bestbuy.com/'a esit oldugunnu test edin
    ✧titleTest => Sayfa basliginin "Rest" icermedigini(contains) test edin
    ✧logoTest => BestBuy logosunun goruntulendigini test edin
    ✧FrancaisLinkTest =>Fransizca Linkin goruntulendigini test edin
     */
    static WebDriver driver;

    @BeforeClass
    public static void setUp(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.bestbuy.com/");
    }
    @AfterClass
    public static void teardown(){
        driver.close();
    }
    @Test
    public void test01(){
        // ✧Sayfa URL'inin https://www.bestbuy.com/'a esit oldugunu test edin

        String exceptedUrl="https://www.bestbuy.com/";
        String actualUrl= driver.getCurrentUrl();

        Assert.assertEquals(exceptedUrl,actualUrl);
    }

    @Test
    public void test02(){
        // ✧titleTest => Sayfa basliginin "Rest" icermedigini(contains) test edin

        String exceptedIcermeyenKelime="Rest";
        String actualTitle= driver.getTitle();

        Assert.assertFalse(actualTitle.contains(exceptedIcermeyenKelime));
    }
    @Test
    public void test03(){
        // ✧logoTest => BestBuy logosunun goruntulendigini test edin
        WebElement logoElementi= driver.findElement(By.xpath("(//img[@class='logo'])[1]"));
        Assert.assertTrue(logoElementi.isDisplayed());

    }

    @Test
    public void test04(){
        // ✧FrancaisLinkTest =>Fransizca Linkin goruntulendigini test edin
        WebElement fransizcaLinki= driver.findElement(By.xpath("//*[text()='Français']"));
        Assert.assertTrue(fransizcaLinki.isDisplayed());
    }

}
