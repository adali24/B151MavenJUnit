package techproed.day22_JSExecutor;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C03_GetAttribute extends TestBase {
    @Test
    public void tes01() {
        //  https://www.carettahotel.com/ a gidiniz
        driver.get("https://www.carettahotel.com/");
        driver.findElement(By.xpath("//*[@id='details-button']")).click();
        bekle(2);
        driver.findElement(By.xpath("//*[@id='proceed-link']")).click();
        driver.findElement(By.xpath("//*[@class='form-control checkin_date']")).click();

        //  Tarih kısmını JS ile locate ediniz.
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement date = (WebElement) js.executeScript("return document.getElementById('checkin_date')");
        bekle(1);
        date.clear();
        bekle(1);
        date.sendKeys("05/05/2023");
         /*
    Java Script kodlarıyla yazılmış webelementleri bizim bildiğimiz findElement() methoduyla locate edemeyebiliriz.
    js executor kullanarak ister html ister java script ile yazılmış olsun bir webelementin locatini js executor
    ile alabiliriz. Yukarıdaki örnekte sayfadaki tarih webelementini js executor ile locate ettik.
     */

        // Date webelemetinin Attribute degerlerini yazdiralim

    }
}
