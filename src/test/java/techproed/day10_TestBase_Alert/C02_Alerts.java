package techproed.day10_TestBase_Alert;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C02_Alerts extends TestBase {
    /*
    Eğer bir sayfadaki bir buttona tıkladığımızda bir uyarı penceresi çıkıyorsa ve bu çıkan pencereye sağ klip
 yapıp locate alamıyorsak, bu bir js Alert'tür.
    js Alert'ü handle edebilmek için driver'ımızı o pencere geçirmemiz gerekir. Bunun için;
 driver objemizi kullanarak switchTo() methoduyla alert() methodunu kullanarak js alert'e geçiş yapmış oluruz
 accept() yada dismiss() methodlarıyla js Alert'ü onaylar yada iptal ederek kapatırız
 */



    @Test
    public void test1() {

        //https://testcenter.techproeducation.com/index.php?page=javascript-alerts adresine gidin.
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");
        bekle(2);


        //Bir metod olusturun: acceptAlert
        //1. butona tıklayın, uyarıdaki OK butonuna tıklayın ve result mesajının  “You successfully clicked an alert” oldugunu test edin.
        driver.findElement(By.xpath("(//button)[1]")).click();
        bekle(3);
        driver.switchTo().// gecmek icin kullanilan method
                alert(). // alert'e gecis yapar
                accept();// cikan alert'te ok yada tamam butonunu tiklar
        bekle(2);

        WebElement resultMessage =driver.findElement(By.xpath("(//p)[2]"));
        String istenenYazi ="You successfully clicked an alert";
        Assert.assertEquals(istenenYazi,resultMessage.getText());
    }

    @Test
    public void dismissAlert() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //Bir metod olusturun: dismissAlert
        //2. butona tıklayın, uyarıdaki Cancel butonuna tıklayın ve result mesajının ve “successfuly” icermedigini test edin.
        driver.findElement(By.xpath("(//button)[2]")).click();
        bekle(3);
        driver.switchTo().// gecmek icin kullanilan method
                alert().// alert'e gecis yapar
                dismiss();// cikan alert'te iptal butonunu tiklar

        WebElement resultMessage1 =driver.findElement(By.xpath("(//p)[2]"));
        String istenenMetin = "successfuly";
        Assert.assertFalse(resultMessage1.getText().contains(istenenMetin));
        bekle(2);

    }

    @Test
    public void sendKeysAlert() {
        driver.get("https://testcenter.techproeducation.com/index.php?page=javascript-alerts");

        //Bir metod olusturun: sendKeysAlert
        //3. butona tıklayın, uyarıdaki metin kutusuna isminizi yazin, OK butonuna
        driver.findElement(By.xpath("(//button)[3]")).click();
        bekle(3);

        driver.switchTo().alert().sendKeys("Hamit");
        bekle(3);
        driver.switchTo().alert().accept();
        bekle(5);
        //tıklayın ve result mesajında isminizin görüntülendiğini doğrulayın.
        WebElement resultMessage2 =driver.findElement(By.xpath("(//p)[2]"));
        String girilenMetin ="Hamit";
        Assert.assertTrue(resultMessage2.getText().contains(girilenMetin));
        bekle(5);



    }
}
