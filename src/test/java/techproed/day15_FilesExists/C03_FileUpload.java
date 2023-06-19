package techproed.day15_FilesExists;

import com.google.common.io.Files;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import techproed.utilities.TestBase;

public class C03_FileUpload extends TestBase {
    @Test
    public void test01() {
        //https://the-internet.herokuapp.com/upload adresine gidelim
        driver.get("https://the-internet.herokuapp.com/upload");

        //chooseFile butonuna basalim\
        WebElement dosyaSec = driver.findElement(By.xpath("//*[@id='file-upload']"));
/*
    Eger dosyaSec butonuna basmamiz istenirse ve otomasyon ile bu butona click yapmak istedigimizde exception aliyorsak
    direk upload istedigimiz dosya yolunu alip sendKeys() methodu ile dosyayi sayfaya upload yapabiliriz
 */
        //Yuklemek istediginiz dosyayi secelim.
        dosyaSec.sendKeys("C:/Users/sadec/Downloads/b10 all test cases, code.docx");

        //Upload butonuna basalim.
        driver.findElement(By.xpath("//*[@id='file-submit']")).click();

        //"File Uploaded!" textinin goruntulendigini test edelim.
        WebElement dogrulama = driver.findElement(By.xpath("//*[@id='uploaded-files']"));
        dogrulama.click();
        Assert.assertTrue(dogrulama.isDisplayed());

    }
}
