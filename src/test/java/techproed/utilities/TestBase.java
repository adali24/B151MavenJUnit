package techproed.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.*;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestBase {
/*
     TestBase class'indan obje olusturmanin onune gecmek icin bu class'i abstract yapabiliriz
     TestBase testBase new = TestBase(); yani bu sekilde obje olusturmanin onune gecmis oluruz
     Bu class'a extends yaptigimiz test class'larindan ulabiliriz
 */

    protected WebDriver driver;

    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() throws Exception {
        //  driver.quit();
    }

    // Hard wait (Bekleme methody)
    public void bekle(int saniye) {
        try {
            Thread.sleep(saniye * 1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    //Selenium Wait/Expilicit Wait

    //visibilityOf(element) methodu
    public void visibleWait(WebElement element, int saniye) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(saniye));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    // visibilityOfElementLocated(locator)) methodu
    public void visibleWait(By locator, int saniye) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(saniye));
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    //AlertWait methodu
    public void alertWait(int saniye) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(saniye));
        wait.until(ExpectedConditions.alertIsPresent());
    }

    // FluentWait visible methodu
    public void visibleFluentWait(WebElement element, int saniye, int milisaniye) {
        new FluentWait<>(driver).withTimeout(Duration.ofSeconds(saniye)).
                pollingEvery(Duration.ofMillis(milisaniye)).
                until(ExpectedConditions.visibilityOf(element));
    }


    //AcceptAlert
    public void acceptAlert() {
        driver.switchTo().alert().accept();
    }

    //DismissAlert
    public void dismissAlert() {
        driver.switchTo().alert().dismiss();
    }

    //GetTextAlert
    public String getTextAlert() {
        return driver.switchTo().alert().getText();
    }

    //SentKeysAlert
    public void sentKeysAlert(String text) {
        driver.switchTo().alert().sendKeys(text);
    }

    //DropDown VisibleText
    public void selectVisibleText(WebElement ddm, String text) {
        Select select = new Select(ddm);
        select.selectByVisibleText(text);
    }

    //DropDown Index
    public void selectIndex(WebElement ddm, int index) {
        Select select = new Select(ddm);
        select.selectByIndex(index);
    }

    //DropDown Value
    public void selectValue(WebElement ddm, String value) {
        Select select = new Select(ddm);
        select.selectByValue(value);
    }

    // SwitchTo Window
    public void switchToWindow(int index) {
        List<String> pencereler = new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(pencereler.get(index));

    }

    // SwitchTo Window 2
    public void switchWindow(int index) {

        driver.switchTo().window(driver.getWindowHandles().toArray()[index].toString());


    }
    //Tüm Sayfa Resmi (ScreenShot)
    public void tumSayfaResmi(){
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/techproed/TumSayfaResmi/screenShot" + tarih + ".jpeg";
        TakesScreenshot ts = (TakesScreenshot) driver;
        try {
            FileUtils.copyFile(ts.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    //WebElement Resmi (Webelement ScreenShot)
    public void webElementResmi(WebElement element){
        String tarih = new SimpleDateFormat("_hh_mm_ss_ddMMyyyy").format(new Date());
        String dosyaYolu = "src/test/java/techproed/ElementResmi/WEscreenShot" + tarih + ".jpeg";
        try {
            FileUtils.copyFile(element.getScreenshotAs(OutputType.FILE),new File(dosyaYolu));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


}