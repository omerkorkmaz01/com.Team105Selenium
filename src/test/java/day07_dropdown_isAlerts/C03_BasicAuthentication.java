package day07_dropdown_isAlerts;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_BasicAuthentication {

    /*
    1- Bir class olusturun : BasicAuthentication
    2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
    3- Asagidaki yontem ve test datalarini kullnarak authentication'i yapin

    Html komutu : https://username:password@URL
        Username : admin
        password : admin

    4- Basarili sekilde sayafa girildigini dogrulayin
     */

    WebDriver driver;
    @Before
    public void setUp()throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }

    @After
    public void tearDown() {
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {

    //1- Bir class olusturun : BasicAuthentication
    //2- https://the-internet.herokuapp.com/basic_auth sayfasina gidin
        driver.get("https://the-internet.herokuapp.com/basic_auth");

        Thread.sleep(3000);
    //3- Asagidaki yontem ve test datalarini kullnarak authentication'i yapin

    //Html komutu : https://username:password@URL
    //    Username : admin
    //    password : admin
        driver.get("https://admin:admin@https://the-internet.herokuapp.com/basic_auth");
    //4- Basarili sekilde sayafa girildigini dogrulayin
        String actualSonucYazisi= driver.findElement(By.tagName("p")).getText();
        String exceptedKelime="Congratulations";

        Assert.assertTrue(actualSonucYazisi.contains(exceptedKelime));
        Thread.sleep(3000);

    }

}
