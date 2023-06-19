package techproed.day15_FilesExists;

import org.bouncycastle.math.ec.rfc7748.X448;
import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C01_FilesExists {
    @Test
    public void test01() {
/*
    Bir web sitesini test ettiğimizde download işlemi yapıldığı zaman dosyanın bilgisayarımıza inip inmediğini
kontrol etmek varlığını doğrulamak için yada bilgisayarımızdaki herhangi bir dosyanın varlığını doğrulabilmek
için;
    Files class'ından exists() methodunu kullanarak parametre olarak Paths.get(dosyaYolu) methodunu kullanarak
dosyanın varlığını test edebiliriz. --> Files.exists(Paths.get(dosyaYolu)
Dolayısıyla bu işleme başlamadan önce varlığını test edeceğimiz dosyanın yolunu String bir değişkene
assing ederiz.
 */
        String dosyaYolu = "C:/Users/sadec/OneDrive/Masaüstü/1.pdf";
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
    }

    @Test
    public void test2() {
        String deneme = "C:/Users/sadec/Downloads/Video/Başörtüsü İkilemi.mp4";
        Assert.assertTrue(Files.exists(Paths.get(deneme)));
    }

    @Test
    public void test3() {
      /*
        Bir server'da farkli işlerim sistemleri ile aynı anda dosya varlığını test etmek istediğimiz zaman,
    daha dinamik olması açısından System.getProperty("os.name") bu şekilde işletim sistemi alır
    her işletim sistemin kullanıcı yolu farklı olacağından System.getProperty("user.home")
    bilgisayarımızdaki kullanıcı yolunu bu şekilde String bir değişkene farklıYol ismiyle System.getProperty("user.home")
    atayarak herseferinde farklı yolları almayla uğraşmamış oluruz. Dosya diyelimki masaüstünde ve her işletim
    sisteminde bize aynı yolu vereceği için bunuda ortakYol olarak bir String'e assing ederiz
     */
        String farkliYol = "";
        String isletimSistemiAdi = System.getProperty("os.name");//-->İşletim sistemimizin adını verir
        System.out.println(isletimSistemiAdi);
        System.out.println(System.getProperty("user.home"));//-->Bilgisayarımızdaki kullanıcı yolunu verir
        if (isletimSistemiAdi.contains("Win")) {
            farkliYol = System.getProperty("user.home");//-->Windows 10/-->C:\Users\Lenovo
        } else if (isletimSistemiAdi.contains("mac")) {
            farkliYol = "/Users/aycapolatkamali";//-->Mac işletim sistemi yolu
        }
        String ortakYol = "/OneDrive/Masaüstü/Yeni Text Document.txt";
        String dosyaYolu = farkliYol + ortakYol;
        System.out.println(Files.exists(Paths.get(dosyaYolu)));
        //  Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));
        try {
            Files.delete(Paths.get(dosyaYolu));
        } catch (IOException e) {
            System.out.println("dosya kayip ");
        }
        Assert.assertFalse(Files.exists(Paths.get(dosyaYolu)));
        try {
            Files.createFile(Paths.get(dosyaYolu));
        } catch (IOException e) {

        }
          /*
        Her seferinde test ettiğimiz sayfada download işlemi yapılıyorsa gereksiz dosya kalabalığını önlemek için
    yukardaki delete işlemini kullanabiliriz
     */
    }

    @Test
    public void test4() {
          /*
            Yukarıdaki methodlarda bilgisayarımızdaki dosya yolunun varlığını Files.exists()methoduyla test etmiştik
        Aynı işlemi aşağıdaki örnekteki gibi File class'ından obje oluşturarak da yapabiliriz.
         */

        String dosyaYolu = "C:/Users/sadec/OneDrive/Masaüstü/Yeni Text Document.txt";
        File file = new File(dosyaYolu);
        System.out.println(file.exists());
        Assert.assertTrue(file.exists());
    }
}
