package techproed.day08_C03_BeforeClassAfterClass_Assertion;

import org.junit.*;

public class C01_BeforeClassAfterClass {
    /*
    @BeforeClass ve @AfterClass methodlari static olmak zorundadir
     */

    @BeforeClass
    public static void beforeClass() throws Exception {
        System.out.println("Her classtan once beforeclass methodu birkez calisir");
    }

    @AfterClass
    public static void afterClass() throws Exception {
        System.out.println("Her class'dan sonra AfterClass Methodu bir kez calisir");
    }

    @Before
    public void setUp() throws Exception {
        System.out.println("Her methoddan once Before methodu bir kez calisir");
    }

    @After
    public void tearDown() throws Exception {
        System.out.println("Her method'dan sonra After(tearDown) method'u bir kez çalışır");
    }
    @Test
    public void test01() {
        System.out.println("Test01 methodu çalıştı");
    }
    @Test
    public void test02() {
        System.out.println("Test02 methodu çalıştı");
    }
    @Test
    public void test03() {
        System.out.println("Test03 methodu çalıştı");
    }
}