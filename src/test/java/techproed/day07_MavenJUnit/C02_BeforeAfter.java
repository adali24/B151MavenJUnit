package techproed.day07_MavenJUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class C02_BeforeAfter {
/*
    Notasyonlara sahip methodlar oluşturabilmek için mause+sağtik+generate(kısayol alt+insert) yaparak
after methodu için teardown'u seçeriz.
before methodu için setup'ı seçeriz.
test methodu için de test'i seçeriz.
    Junit frameworkunde testlerimizi sıralama yapabilmek için ekstra bir notasyon yoktur
Eğer belli bir sıralamada çalıştırmak istersek method isimlerini alfabetik ve sayıl olarak belirtmemiz gerekir.
 */
    @After
    public void tearDown() throws Exception {
        System.out.println("Her test methodundan sonra bir kez calisir.");
    }

    @Before
    public void setUp()  {
        System.out.println("Her test methodundan once bir kez calisir.");
    }

    @Test
    public void test1() {
        System.out.println("Test1 methodu çalıştı");
    }
    @Test
    public void test2() {
        System.out.println("Test2 methodu çalıştı");
    }
    @Test
    public void test3() {
        System.out.println("Test3 methodu çalıştı");
    }
}
