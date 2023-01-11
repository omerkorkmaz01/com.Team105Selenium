package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_RadioButton {

    // Gereki yapiyi olusturun ve asagidaki gorevi tamamlayin.
    WebDriver driver;
    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.manage().window().maximize();
    }
    @After
    public void teardown() {
       // driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        // a. Verilenweb sayfasina gidin.
        //    https://facebook.com
        driver.get("https://facebook.com");
        // b. Cookies'i kabul edin
        driver.findElement(By.xpath("//button[@title='Only allow essential cookies']")).click();
        // c. Create on account button'una basin
        driver.findElement(By.xpath("//a[@class='_42ft_4jy0_6lti_4jy6_4jy2_selected_51sy']")).click();
        // d. Radio button elementlerini locate edin ve size uygun olani secin
        driver.findElement(By.xpath("(//input[@type='radio'])[2]")).click();
        Thread.sleep(4000);
    }

}
