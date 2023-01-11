package day06_assertions;

import org.junit.Assert;
import org.junit.Test;

public class C02_Assertion {

    /*

    JUnit framework'u calistirilan testlerin passed veya failed olmasini raporlar
    Ancak raporlamanin dogru sonuc vermesi icin
    Test'lerin Assert class'indaki hazir method'larla yapilmasi gerekir

    Eger Assert class'i kullanilmazsa
    JUnit kodlarin sorunsuz olarak calisip bittigini raporlar
    C01'de failed olsa da kodlar sorunsuz calistigi icin
    testler yesil tik olarak isaretlendi

     */

    int P1yas1 = 60;
    int P2yas2 = 66;
    int P3yas3 = 70;

    @Test
    public void test01() {
        // emekli yasi 65 olduguna gore
        // P2'nin emekli olabilecegini test edin

        Assert.assertTrue(P2yas2 > 65);
    }
    @Test
    public void test02() {
        // emekli yasi 65 olduguna gore
        // P2'nin emekli olamayacagini test edin

        Assert.assertFalse(P1yas1 > 65);
    }
    @Test
    public void test03() {
        // emekli yasi 65 olduguna gore
        // P3'nin emekli olamayacagini test edin

        Assert.assertFalse("Girilen yas 65'den kucuk olamadigindan emekli olabilir", P3yas3 > 65);
    }
}
