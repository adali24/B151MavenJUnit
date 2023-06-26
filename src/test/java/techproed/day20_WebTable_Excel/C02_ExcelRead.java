package techproed.day20_WebTable_Excel;

import org.apache.poi.ss.usermodel.*;
import org.junit.Assert;
import org.junit.Test;
import techproed.utilities.TestBase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class C02_ExcelRead  {
    /*
    EXCEL dosyasından veri okuyabilmemiz için öncelikle pom.xml dosyamıza poi ve poi.ooxml dependency'lerini
yüklememiz gerekir.
    Sonra üzerinde çalışacağımız excel dosyasını projemizde src>test>java>techpoed>resources package'i içine
kayarız.
 */
    @Test
    public void test01() throws IOException {

// 1- dosya yolunu aliriz
        String dosyaYolu= "src/test/java/techproed/resources/Capitals.xlsx";

// 2- Dosyayi okuyabilmemiz icin javada akisa almamiz gerekiyor
        FileInputStream  fis = new FileInputStream(dosyaYolu);

// 3 - Java ortaminda bir excel dosyasi olusturabilmek icin ;
        Workbook workbook = WorkbookFactory.create(fis); //  Akisa aldigimiz dosyayi okuyoruz

// 4 - Olusturdugumuz excel'den sayfa(sheet) secmemiz gerekir
        Sheet sheet =  workbook.getSheet("Sheet1");

// 5 - Belirttigimiz sayfadaki satir( row) bilgisini secmemiz gerekir
        Row row = sheet.getRow(0); //--> satirda index 0 (sifir) dan basladigi icin 1. satiri getirir.

// 6 - Belirttigimiz satirdaki hucre(Cell) bilgisini secmemiz gerekir
        Cell cell = row.getCell(0);

// Son olarak Cell bilgisini sout ile yazdirip exceldeki 1. satir 1. hucredeki veriyi gorebiliriz
        System.out.println(cell);

    }

    @Test
    public void test02() throws IOException {
        //PRATİK ÇÖZÜM
        //1. Satır ve 1. sütun daki bilgileri yazdıralım
        FileInputStream fis = new FileInputStream("src/test/java/techproed/resources/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        String birinciSatirBirinciSutun = workbook.getSheet("Sheet1").getRow(0).getCell(0).toString();
        System.out.println(birinciSatirBirinciSutun);
    }

    @Test
    public void test03() throws IOException {

//Capitals.xlsx dosyasından 1. satır 2. sütundaki hücreyi yazdırın
        FileInputStream fis = new FileInputStream("src/test/java/techproed/resources/Capitals.xlsx");
        Workbook workbook = WorkbookFactory.create(fis);
        System.out.println(workbook.getSheet("Sheet1").getRow(0).getCell(1).toString());


//3. Satır 1. sütun değerini yazdırın ve "France" olduğunu test edin
        String birinciSatirIkinciSutun = workbook.getSheet("Sheet1").getRow(2).getCell(0).toString();
        System.out.println(birinciSatirIkinciSutun);
        Assert.assertEquals("France",birinciSatirIkinciSutun);

//Kullanılan satır sayısın bulun
        System.out.println("Kullanilan satir sayisi = "+workbook.getSheet("Sheet1").getPhysicalNumberOfRows());
        // not = getPhysicalNumberOfRows() methodu kullanilan yani ici dolu olan satirlarin sayisini verir index 1 den baslar

// Sayfadaki satir sayisini yazdiriniz
        System.out.println("Sayfadaki satir sayisi = "+workbook.getSheet("Sheet1").getLastRowNum());
        // not = getLastRowNum()) methodu sayfadaki satir sayisini verir ve index 0 dan baslar

//Ülke-Başkent şeklinde verileri yazdırın
       for(int i=0 ; i< workbook.getSheet("Sheet1").getPhysicalNumberOfRows(); i++){
           for (int j = 0 ; j< workbook.getSheet("Sheet1").getRow(0).getPhysicalNumberOfCells(); j++){
               System.out.print(workbook.getSheet("Sheet1").getRow(i).getCell(j)+"\t");
           }
           System.out.println();
       }
    }
}
