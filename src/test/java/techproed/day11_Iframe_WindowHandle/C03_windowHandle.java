package techproed.day11_Iframe_WindowHandle;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.WindowType;
import techproed.utilities.TestBase;

public class C03_windowHandle extends TestBase {
    @Test
    public void windowHandle() {
        /*
        Eger sayfaya gittikten sonra yeni sekme yada yeni bir pencereyle baska sayfaya gittikten sonra
        tekrar ilk actiginiz sayfaya dnmek isterseniz, ilk sayfaya driver.get() methoduyla gittikten sonra
        String bir degisken handle degerini assign ederseniz tekrar ilk acilan sayfaya donmek istediginizde
        driver.switchTo().window(ilksayfaHandleDegeri) ile gecis yapabilirsiniz
         */
        System.out.println("***********************  yeni pencerede acilir  *********************");

//Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techproedWindowHandle =driver.getWindowHandle();

//Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        String actualTitle = driver.getTitle();
        String expectedTitle = "Techpro Education | Online It Courses & Bootcamps";
        Assert.assertEquals(expectedTitle,actualTitle);

//Window 2'de (yeni bir pencerede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().
                newWindow(WindowType.WINDOW);//-->Yeni bir pencereye driver'i taşır
        //WindowType.TAB --> Yeni bir sekme açar
        driver.get("https://www.youtube.com");
        String youtubeWindowHandel= driver.getWindowHandle();

//Window 3'te https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.WINDOW).get("https://www.linkedin.com");
        String linkedinWindowHandel= driver.getWindowHandle();
bekle(1);
//techproeducation sayfasına geçiniz:
        driver.switchTo().window(techproedWindowHandle);
        bekle(3);

//youtube sayfasına geçiniz:
        driver.switchTo().window(youtubeWindowHandel);
        bekle(3);

//linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedinWindowHandel);
        bekle(3);
    }

    @Test
    public void tab() {
        System.out.println("***********************  tab ile acilir pencere *********************");
//Window 1'de https://www.techproeducation.com adresine gidiniz
        driver.get("https://www.techproeducation.com");
        String techproedWindowHandle =driver.getWindowHandle();

//Başlığın "Techpro Education | Online It Courses & Bootcamps" olduğunu doğrulayın
        String actualTitle = driver.getTitle();
        String expectedTitle = "Techpro Education | Online It Courses & Bootcamps";
        Assert.assertEquals(expectedTitle,actualTitle);

//Window 2'de (yeni bir pencerede) https://www.youtube.com sayfasını açınız:
        driver.switchTo().
                newWindow(WindowType.TAB);//-->Yeni bir pencereye driver'i taşır
        //WindowType.TAB --> Yeni bir sekme açar
        driver.get("https://www.youtube.com");
        String youtubeWindowHandel= driver.getWindowHandle();

//Window 3'te https://www.linkedin.com sayfasını açınız:
        driver.switchTo().newWindow(WindowType.TAB).get("https://www.linkedin.com");
        String linkedinWindowHandel= driver.getWindowHandle();
        bekle(1);
//techproeducation sayfasına geçiniz:
        driver.switchTo().window(techproedWindowHandle);
        bekle(3);

//youtube sayfasına geçiniz:
        driver.switchTo().window(youtubeWindowHandel);
        bekle(3);

//linkedIn sayfasına geçiniz:
        driver.switchTo().window(linkedinWindowHandel);
        bekle(3);
    }
}
