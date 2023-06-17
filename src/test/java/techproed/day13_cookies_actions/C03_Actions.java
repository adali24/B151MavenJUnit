package techproed.day13_cookies_actions;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import techproed.utilities.TestBase;

public class C03_Actions extends TestBase {

    @Test
    public void name() {
//Amazon a gidelim https://www.amazon.com/
        driver.get("https://www.amazon.com/");

//Sag ust bolumde bulunan "Account & Lists" menüsüne git  "Account" secenegine tikla
       WebElement accountList= driver.findElement(By.xpath("//*[@class='nav-line-2 ']"));
        Actions actions =new Actions(driver);
        actions.clickAndHold(accountList);


//Acilan sayfanin Title in "Your Account" icerdigini dogrula



    }
}
