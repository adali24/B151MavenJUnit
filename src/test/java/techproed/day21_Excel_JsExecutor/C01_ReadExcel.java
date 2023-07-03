package techproed.day21_Excel_JsExecutor;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.junit.Assert;
import org.junit.Test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class C01_ReadExcel {
    @Test
    public void readExcel() throws IOException {

//Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
        FileInputStream fis = new FileInputStream("src/test/java/techproed/resources/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        System.out.println(workbook.getSheet("Sheet1").getRow(0).getCell(1).toString());


//3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
        String birinciSatirIkinciSutun = workbook.getSheet("Sheet1").getRow(2).getCell(0).toString();
        System.out.println(birinciSatirIkinciSutun);
        Assert.assertEquals("France", birinciSatirIkinciSutun);

//Kullanılan satır sayısın bulun
        System.out.println("Kullanilan satir sayisi = " + workbook.getSheet("Sheet1").getPhysicalNumberOfRows());
        // not = getPhysicalNumberOfRows() methodu kullanilan yani ici dolu olan satirlarin sayisini verir index 1 den baslar

// Sayfadaki satir sayisini yazdiriniz
        System.out.println("Sayfadaki satir sayisi = " + workbook.getSheet("Sheet1").getLastRowNum());
        // not = getLastRowNum()) methodu sayfadaki satir sayisini verir ve index 0 dan baslar

//Ülke-Başkent şeklinde verileri yazdırın
        for (int i = 0; i < workbook.getSheet("Sheet1").getPhysicalNumberOfRows(); i++) {
            for (int j = 0; j < workbook.getSheet("Sheet1").getRow(0).getPhysicalNumberOfCells(); j++) {
                System.out.print(workbook.getSheet("Sheet1").getRow(i).getCell(j) + "\t");
            }
            System.out.println();
        }
    }

    @Test
    public void test2() throws IOException {
        FileInputStream fis = new FileInputStream("src/test/java/techproed/resources/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        Map<String,String> ulkeBaskent= new LinkedHashMap<>();
        for (int i = 0; i < workbook.getSheet("Sheet1").getPhysicalNumberOfRows(); i++) {
            String ulke = workbook.getSheet("Sheet1").getRow(i).getCell(0).toString();
            String sehir = workbook.getSheet("Sheet1").getRow(i).getCell(1).toString();
            ulkeBaskent.put(ulke,sehir+"\n");
        }
        System.out.println(ulkeBaskent);

    }

    @Test
    public void test03() throws IOException {
        FileInputStream fis = new FileInputStream("src/test/java/techproed/resources/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        Map<String, String> ulkeBaskent = new LinkedHashMap<>();
        for (int i = 0; i <= workbook.getSheet("Sheet1").getLastRowNum()+1; i++) {
            if (workbook.getSheet("Sheet1").getRow(i) != null){//-->Satırlar boş değilse
                String ulke = workbook.getSheet("Sheet1").getRow(i).getCell(0).toString();
                String sehir = workbook.getSheet("Sheet1").getRow(i).getCell(1).toString();
                ulkeBaskent.put(ulke, sehir + "\n");
            }
        }
        System.out.println(ulkeBaskent);
        /*
        Döngüde boş olan hücreye geldiği için nullpointerException hatası alıyoruz.
        if bloğu içinde boş olmayan satırları al diyerek (workbook.getSheet("Sheet1").getRow(i) != null)
        bu sorunu çözmüş oluyoruz.
         */
    }
}