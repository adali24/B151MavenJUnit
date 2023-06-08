package techproed.day09_DropdownMenu;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C03_Dropdown {
    WebDriver driver;
    @Before
    public void setUp() throws Exception {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://testcenter.techproeducation.com/index.php?page=dropdown");
    }

    @Test
    public void test01() {
//programming languages ddm den istediginiz 4 secenegi seciniz
        WebElement diller = driver.findElement(By.xpath("(//select)[6]"));
        Select select = new Select(diller);
        select.selectByIndex(0);
        select.selectByIndex(2);
        select.selectByIndex(3);
        select.selectByIndex(4);

//Eger sadece secili olan option'lari yani secenekleri yazdirmak istersek
        System.out.println("*******************lambda ile***********");
        select.getAllSelectedOptions().forEach(w-> System.out.println(w.getText()));// lambda ile
        System.out.println("*******************forEch ile***********");
        for (WebElement e :select.getAllSelectedOptions()) {
            System.out.println(e.getText());
        }
        //Seçeneklerden 4 tane seçtiğimizi doğrulayalım
        Assert.assertEquals(4,select.getAllSelectedOptions().size());

        //Sectigimiz seceneklerden ilkini yazdiralim , ilk secenegin Java oldugunu dogrulayalim
        System.out.println("Sectigimiz seceneklerden ilki = "+select.getFirstSelectedOption().getText());
        Assert.assertEquals("Java",select.getFirstSelectedOption().getText());

        //Sectigimiz seceneklerin hepsini kaldiralim
        select.deselectAll();

        //sendKeys() methodu ile istedigimiz bir secenegi gonderelim
   //     diller.sendKeys("C#");

        //visibleText olarak secim yapacagimiz bir method olusturup programming languages ddm'den bir secenek secelim
        selectVisibleText(diller,"Java");


    }

    public void selectVisibleText(WebElement ddm,String secenek){
    Select select =new Select(ddm);
    select.selectByVisibleText(secenek);
    }
}
