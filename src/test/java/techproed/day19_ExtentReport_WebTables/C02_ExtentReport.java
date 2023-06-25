package techproed.day19_ExtentReport_WebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import techproed.utilities.TestBase;

public class C02_ExtentReport extends TestBase {
    @Test
    public void test01() {

        extentReport("Chrome"," Amazon testi");
        extentTest=extentReports.createTest("Extentreport","Test raporu");


//amazon sayfasına gidiniz
        driver.get("https://amazon.com");
        extentTest.info("Amazon sayfasına gidildi");

//sayfanın resmini alınız
        tumSayfaResmi();
        extentTest.info("sayfanin ekran goruntusu alindi");

//arama kutusunda iphone aratınız
        driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']")).sendKeys("iphone", Keys.ENTER);
        extentTest.info("Iphone arattirildi");
        extentTest.pass("Sayfa kapatıldı");
        extentReports.flush();


    }
}
