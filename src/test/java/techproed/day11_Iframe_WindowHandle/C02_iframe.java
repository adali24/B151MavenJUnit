package techproed.day11_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C02_iframe extends TestBase {
    @Test
    public void name() {
        //https://the-internet.herokuapp.com/iframe sayfasına gidiniz
        driver.get("https://the-internet.herokuapp.com/iframe");

        //Kalın yazının "Editor" kelimesini içerdiğini doğrulayınız
        String editor=driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(editor.contains("Editor"));

        //Textbox içindeki yazıyı siliniz.
        driver.switchTo().frame("mce_0_ifr");
         WebElement textBox=driver.findElement(By.xpath("//p"));
         textBox.clear();

//Sildiğiniz yazı yerine "Bu textbox iFrame içinde yer almaktadır" yazınız.
        textBox.sendKeys("Bu textbox iFrame içinde yer almaktadır");

//Sayfadaki "Elemental Selenium" yazısının görünür olduğunu doğrulayınız.
        driver.switchTo().defaultContent();
        WebElement elementalSeleniumLinki= driver.findElement(By.xpath("(//a)[3]"));
        Assert.assertTrue(elementalSeleniumLinki.isDisplayed());
        bekle(2);

    }
}
