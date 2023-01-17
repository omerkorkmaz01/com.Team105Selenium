package day10_FileTests;

import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class C01_FileInputStream {
    @Test
    public void test01() throws FileNotFoundException {

        String dosyaYolu="C:\\Users\\omerk\\Desktop\\java.docx";

        FileInputStream fis= new FileInputStream(dosyaYolu);

        /*
            File testlerinde dowloads'a indirelecek bir dosyanin
            indirildiginde test etmek
            veya masaustundeki bir dosyanin web'e yuklenebildigini test etmek isteriz

            Ancak herkesin bilgisarayinin ismi, kullanici isimleri gibi farkliliklar
            olacagindan testler tek bir bilgisarayda calisacak gibi yazilmak zorunda kalir

            Bu karisikligi onlemek amacıyla java
            2 basit kod blogu sunmustur.
         */

        System.out.println(System.getProperty("user.dir"));
        // C:\Users\omerk\IdeaProjects\com.Team105_JUnit

        System.out.println(System.getProperty("user.home"));
        // kullanicinin temel path'ini verir
        // C:\Users\omerk

        // Masaustune gitmek istersek
        // C:\Users\omerk + \Desktop eklememiz yeterlidir

        // Downloads'a gitmek istersek
        // C:\Users\omerk + \Downloads eklememiz yeterlidir

        // Kodlarimizin dinamik olmasi yani kisinin bilgisarayindaki
        // kullanici adi gibi detaylara takilmamasi icin
        // File testlerindeki kullanilacak dosya yolunu
        // user.home.... temel path'i calistigi bilgisaraydan olacak sekikde
        // olustururuz

        // String dosyaYolu="C:\\Users\\omerk\\Desktop\\java.docx";
        String dinamikDosyaYolu=System.getProperty("user.home")+ "\\Desktop\\java.docx";

    }
}
