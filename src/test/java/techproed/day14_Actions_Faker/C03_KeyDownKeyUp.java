package techproed.day14_Actions_Faker;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

import java.security.Key;

public class C03_KeyDownKeyUp extends TestBase {
    @Test
    public void test1() {
        //Google anasayfasına gidelim
        driver.get("https://google.com");
        driver.findElement(By.xpath("(//*[@class='QS5gu sy4vM'])[2]")).click();

        //arama kutusunda shift tusuna basılı olarak selenim yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
         WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        Actions actions = new Actions(driver);
        actions.keyDown(aramaKutusu, Keys.SHIFT).//--> Arama Kutusunda shift tuşuna bastık
                sendKeys("selenium").//-->selenium metnini shift tuşuna basılı kaldığı için büyük yazdı
                keyUp(Keys.SHIFT).//--> shift tusunu serbest bıraktık
                sendKeys("-java",Keys.ENTER).
                perform();
    }

    @Test
    public void test2() {
        //Google anasayfasına gidelim
        driver.get("https://google.com");
        driver.findElement(By.xpath("(//*[@class='QS5gu sy4vM'])[2]")).click();

        //arama kutusunda shift tusuna basılı olarak selenim yazdıralım ve shift tuşunu serbest bırakarak java yazdıralım
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys(Keys.SHIFT,"selenium",Keys.SHIFT,"java");
        aramaKutusu.submit();
         /*
    Mause işlemleri için actions class'ını kullanmamız gerekir. Fakat bir metin kutusundaki klavye işlemleri için
    actions class'ına kullanmadan sendKeys() methodu ile de istediğimiz bir metni büyük yazdırabilir,
    hatta bir den fazla klavye tuşlana bastırabiliriz. Yukardaki örnekte sendKeys() methodu ile Keys.SHIFT diyerek
    sonrasında yazdırmak istediğimiz metni küçük harfle yazmamıza rağmen büyük harflerle yazdırdı, tekrar Keys.SHIFT
    kullanarak shift tuşunu serbest bırakmış olduk
     */

    }

    @Test
    public void test3() {
//google sayfasına gidelim
        driver.get("https://google.com");
        driver.findElement(By.xpath("(//*[@class='QS5gu sy4vM'])[2]")).click();

// Arama kutusuna "Selenium" yazın ve Enter tuşuna basın
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='gLFyf']"));
        aramaKutusu.sendKeys("selenium");
        aramaKutusu.submit();

// Sayfayı bekleyin
bekle(2);

//Arattığımız kelimeyi arama kutusundan ctrl+x ile keselim
        driver.findElement(By.xpath("//*[@class='gLFyf']")).//-->sayfa yenilendiği için tekrar locate aldık
                sendKeys(Keys.CONTROL,"a");//-->Metni kesebilmemiz için önce ctrl+a ile seçmemiz gerekir
        driver.findElement(By.xpath("//*[@class='gLFyf']")).
                sendKeys(Keys.CONTROL,"x");//-->Seçilen metni ctrl+x ile kestik

        bekle(2);
        //Tekrar google sayfasına gidip kestiğimiz kelimeyi ctrl+v ile yapıştırıp tekrar aratalım
        driver.navigate().to("https://google.com");
        driver.findElement(By.xpath("//*[@class='gLFyf']"))
                .sendKeys(Keys.CONTROL,"v",Keys.ENTER);



    }
}
