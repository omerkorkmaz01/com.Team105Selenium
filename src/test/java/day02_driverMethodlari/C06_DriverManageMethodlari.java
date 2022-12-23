package day02_driverMethodlari;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C06_DriverManageMethodlari {
    public static void main(String[] args) {

        System.setProperty("webdriver.chrome.driver", "src/drivers/chromedriver.exe");
        WebDriver driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        // impilicitly wait gittigimiz sayfa acilincaya kadar veya aradigimiz webelement buluncaya kadar
        // driver'in bekleyebilecegi max sureyi beliler

        // bu dortlu her test methodumuzun basina yazilacak


    }
}
