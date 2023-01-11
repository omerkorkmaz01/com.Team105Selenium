package day07_dropdown_isAlerts;

import com.fasterxml.jackson.databind.ser.std.AsArraySerializerBase;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C01_handleDropdownMenu {

    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

    }
    @Test
    public void test01() throws InterruptedException {

        // ilgili araylari yapip
        // amazon anasayfasina gidin
        // arama kutusu yanindaki dropdown menuden book secin
        // arama kutusuna java yazdirip aramayi yapin
        // title'in book ve java icerdigini test edin

        driver.get("https://www.amazon.com");

        // Dropdown menuden istedigimiz option'i secebilmek icin
        // oncelikle Select class'indan bir obje olusturmaliyiz
        // ancak select objesi olusturmak icin select class'inin constructor'i
        // handle edeceğimiz webelemnt'i istediginden
        // select objesi olusturmadan once dropdown webelementini locate etmeliyiz

        WebElement dropdownWebElementi=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));

        // 2- Select class'indan obje olusturmak
        Select select= new Select(dropdownWebElementi);

        // 3- Select objesini kullanarak istedigimiz method/method'lari calistirin
        // select.selectByValue("search-alias=stripbooks-intl-ship");
        // select.selectByIndex(5);

        select.selectByVisibleText("Books");

        WebElement aramaKutusu= driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("Java"+ Keys.ENTER);

        String exceptedKelime="Java";
        String actualTitle= driver.getTitle();

        Assert.assertTrue(actualTitle.contains(exceptedKelime));

        /*
            Locate ettigimiz elementi bulamazsa NoSuchElementException
            sayfa yenilendigi icin var olan bir elementi kullanamazsa
            StaleElementException verir
            bu durumda locate ve secme islemini yeniden yaparsak kodumuz calisir.
         */


        // dropdown menuden Books seceneginin secildigini test edin

        dropdownWebElementi=driver.findElement(By.xpath("//select[@id='searchDropdownBox']"));
        select= new Select(dropdownWebElementi);
        select.selectByVisibleText("Books");


        String actualsecilenOption = select.getFirstSelectedOption().getText();
        String exceptedSecilecekOption="Books";

        Assert.assertEquals(exceptedSecilecekOption,actualsecilenOption);

        // Dropdown menudeki secenek sayisinin 24 oldugunu test edin

        List<WebElement> optionsWebElementListesi= select.getOptions();

        int actualOptionsSayisi= optionsWebElementListesi.size();
        int exceptedOptionsSayisi=28;

        Assert.assertEquals(exceptedOptionsSayisi,actualOptionsSayisi);

        Thread.sleep(5000);
    }
}
