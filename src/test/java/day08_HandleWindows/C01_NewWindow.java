package day08_HandleWindows;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_NewWindow {

    /*
    selenium 4 ile yeni bir windows konusunda yeni bir ozellik geldi

     istersek kontrollu olarak driver icin yeni bir window veya tab olusturabiliriz
     bu durumda driver'imiz otomatik olarak yeni sayfaya gecmis olur

     Testin ilerleyen asamalarinda yeniden veya eski sayfalara donus gorevi varsa
     o sayfada iken o sayfanin window degeri alinip kaydedilir
     ve o sayfaya gecmek istendiginde
     driver.switchTo().window(istenenSayfaninWindowDegeri)
     kodu ile o sayfaya gecis yapilir
     */
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @After
    public void teardown(){
        driver.quit();
    }

    @Test
    public void test01() throws InterruptedException {
        driver.get("https://www.amazon.com");

        Thread.sleep(3000);

        // Testin ilerleyen asamalarinda yeniden amazon sayfasina donmek gerekiyorsa
        // amazon sayfasindayken bu winow'un windo handle degerini alip kaydetmeliyiz

        String ilkSayfaHandleDegeri=driver.getWindowHandle();

        // yeni bir tab'da wisequarter.com'a gidin ve gittiginiz test edin

        driver.switchTo().newWindow(WindowType.TAB);

        driver.get("https://www.wisequarter.com");

        String actualUrl= driver.getCurrentUrl();
        String exceptedKelime= "wisequarter";
        Assert.assertTrue(actualUrl.contains(exceptedKelime));
        Thread.sleep(3000);

        // wisequarter testini yaptıüiktan sonra
        // yeniden amazon'un acik oldugu tab'a gecin
        // ve amazon anasayfadan acik oldugunu test edin

        driver.switchTo().window(ilkSayfaHandleDegeri);
        actualUrl= driver.getCurrentUrl();
        exceptedKelime= "amazon";
        Assert.assertTrue(actualUrl.contains(exceptedKelime));
        Thread.sleep(3000);
    }

}
