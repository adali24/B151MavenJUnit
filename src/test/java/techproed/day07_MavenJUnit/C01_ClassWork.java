package techproed.day07_MavenJUnit;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_ClassWork {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1.http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");
        Thread.sleep(1500);

        //2.Signin buttonuna tiklayin
        driver.findElement(By.xpath("//*[@id='signin_button']")).click();
        Thread.sleep(1500);

        //3.Login alanine "username" yazdirin
        WebElement userName = driver.findElement(By.xpath("//*[@type='text']"));
        userName.sendKeys("username");
        Thread.sleep(1500);

        //4.Password alanine "password" yazdirin
        WebElement password = driver.findElement(By.xpath("//*[@type='password']"));
        password.sendKeys("password");
        Thread.sleep(1500);

        //5.Sign in buttonuna tiklayin
        driver.findElement(By.xpath("//*[@type='submit']")).click();
        Thread.sleep(1500);
        driver.navigate().back();


        //6.online banking altinda Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//*[@id='online-banking']")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();
        Thread.sleep(1500);



//7.amount kismina yatirmak istediginiz herhangi bir miktari yazin
//8.tarih kismina "2020-09-10" yazdirin
//9.Pay buttonuna tiklayin
        driver.findElement(By.cssSelector("#sp_amount")).sendKeys("500", Keys.TAB,"2020-09-10",Keys.TAB,Keys.TAB,Keys.ENTER);


        //10."The payment was successfully submitted." mesajinin ciktigini control edin
        WebElement element = driver.findElement(By.xpath("(//*[.='The payment was successfully submitted.'])[2]"));
        if (element.isDisplayed()){
            System.out.println("test passed ");

        }else System.out.println("test failed = "+ element.getText());

        driver.close();

    }
}
