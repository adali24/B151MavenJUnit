package techproed.day17_Exceptions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C01_NoSuchElementException extends TestBase {
    @Test
    public void test01() {

        /*
        NO_SUCH_ELEMENT_EXCEPTION
            -Bir webelementin locate'ini yanlis aldigimizda, elementi bulamayacagi icin bu
            exception'i aliriz
         */

        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']\n")).click();

        //arama kutusunda qa aratalım
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@class='eelementor-search-form__input']"));
        aramaKutusu.sendKeys("qa", Keys.ENTER);
        /*normal locatemiz //*[@type='search'] bu sekilde iken NoSuchElementException alabilmek icin locate'i bozduk
        //*[@type='ssearch'] ve exception'i aldigimizi gorduk. Dolayisiyla bu hatayi handle edebilmek icin
        duzgun locate almamiz gerekiyor
         */

        //sayfa başlığının qa içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("qa"));
    }

    @Test
    public void test02() {
        //techproeducation sayfasına gidelim
        driver.get("https://techproeducation.com");
        driver.findElement(By.xpath("//i[@class='eicon-close']\n")).click();

        //arama kutusunda qa aratalım
        WebElement aramaKutusu = driver.findElement(By.cssSelector("//*[@class='elementor-search-form__input']"));
        aramaKutusu.sendKeys("qa", Keys.ENTER);

         /*
org.openqa.selenium.NoSuchElementException:
  normal locatimiz //*[@type='search'] bu şekilde iken nosuchelementexception alabilmek için locate'i bozduk
//*[@type='ssearch'] ve exception'ı aldığımızı gördük. Dolayısıyla bu hatayı handle edebilmek için
düzgün locate almamız gerekiyor. Webelement bir iframe içinde olabilir, bir buttona tıkladığımızda yeni bir
pencere açılabilir yada alert çıkabilir bu gibi durumlarda da nosuchelementexception alırız
 */
        //sayfa başlığının qa içerdiğini test edelim
        Assert.assertTrue(driver.getTitle().contains("qa"));
    }

}

