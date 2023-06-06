package techproed.day08_C03_BeforeClassAfterClass_Assertion;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C07_AssertionClassWork {

     //1)https://amazon.com adresine gidin
     //2)Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleriyapin
     //    ○ title Test  => Sayfa başlığının “Amazon” kelimesini içerip içermediğini test edin
     //    ○ image Test => Amazon resminin görüntülendiğini (isDisplayed()) test edin
     //    ○ Search Box 'in erisilebilir oldugunu test edin(isEnabled())
     //    ○ wrongTitleTest => Sayfa basliginin “amazon” içermediğini doğrulayın

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://amazon.com");

    }

    @Test
    //    ○ title Test  => Sayfa başlığının “Amazon” kelimesini içerip içermediğini test edin
    public void titleTest() {
        String actiualTitle= driver.getTitle();
        String expectedTitle = "Amazon";
        Assert.assertTrue(actiualTitle.contains(expectedTitle));

    }

    @Test
    //    ○ image Test => Amazon resminin görüntülendiğini (isDisplayed()) test edin
    public void imageTest() {
        WebElement image = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(image.isDisplayed());
    }

    @Test
    //    ○ Search Box 'in erisilebilir oldugunu test edin(isEnabled())
    public void searchBoxTest() {
        WebElement searchBox= driver.findElement(By.id("twotabsearchtextbox"));
        Assert.assertTrue(searchBox.isEnabled());
    }

    @Test
    //    ○ wrongTitleTest => Sayfa basliginin “amazon” içermediğini doğrulayın
    public void wrongTitleTest() {
        String actiualTitle= driver.getTitle();
        String expectedTitle = "amazon";
        Assert.assertFalse(actiualTitle.contains(expectedTitle));
    }

    @After
    public void tearDown() throws Exception {
        driver.close();
    }
}

