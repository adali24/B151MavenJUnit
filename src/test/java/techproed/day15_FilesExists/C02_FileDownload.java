package techproed.day15_FilesExists;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import techproed.utilities.TestBase;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class C02_FileDownload extends TestBase {
    @Test
    public void test01() {
        /*
        NOT:
    Windows10 sürümlerinden önceki sürümler için pratik olarak dosya yolu almak istersek
    yolunu almak istediğimiz dosyanun üzerine gelip shift+sayKlik tusuna basarak yol olarak kopyala
    seçeneği ile dosya yolunu kopyalayabiliriz.
         */

//https://testcenter.techproeducation.com/index.php?page=file-
        driver.get("https://testcenter.techproeducation.com/index.php?page=file-");

//download adresine gidelim.
        driver.findElement(By.xpath("//*[text()='File Download']")).click();

//b10 all test cases dosyasını indirelim
        driver.findElement(By.xpath("//*[text()='b10 all test cases, code.docx']")).click();

//Dosyanın başarıyla indirilip indirilmediğini test edelim
        String dosyaYolu = "C:/Users/sadec/Downloads/b10 all test cases, code.docx";
        Assert.assertTrue(Files.exists(Paths.get(dosyaYolu)));

        try {
            Files.delete(Paths.get(dosyaYolu));
        } catch (IOException e) {

        }

    }
}
