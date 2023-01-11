package day06_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C05_CheckBox {

    /*

     */
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
        driver.close();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://the.internet.herokuapp.com/checkboxes");

        WebElement cb = driver.findElement(By.xpath("(//input[@type='checkbox'])[1]"));
        WebElement cb2 = driver.findElement(By.xpath("(//input[@type='checkbox'])[2]"));
        // c. Checkbox1 secili degilse onay kutusuna tiklayin ve secili oldugunu test edin
        if (!cb.isSelected()) {
            cb.click();
        }

        Assert.assertTrue(cb.isSelected());

        // c. Checkbox2 secili degilse onay kutusuna tiklayin ve secili oldugunu test edin
        if (!cb2.isSelected()) {
            cb2.click();
        }
        Assert.assertTrue(cb2.isSelected());

        Thread.sleep(3000);
    }
}

