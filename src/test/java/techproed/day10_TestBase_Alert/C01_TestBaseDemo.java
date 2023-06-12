package techproed.day10_TestBase_Alert;

import org.junit.Assert;
import org.junit.Test;
import techproed.utilities.TestBase;

public class C01_TestBaseDemo extends  TestBase{
    @Test
    public void Test01() {
        //Techproeducation sayfasina gidelim
        driver.get("https://techproeducation.com");

        //Basligin Bootcamp icerdigini test edelim
        String actuelTitle =driver.getTitle();
        // 2 saniye bekle
        bekle(2);

        String expectedTitle ="Bootcamp";
        Assert.assertTrue(actuelTitle.contains("Bootcamp"));
        // diger yontem  assert actuelTitle.contains(expectedTitle);






    }
}
