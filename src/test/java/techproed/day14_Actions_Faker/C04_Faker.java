package techproed.day14_Actions_Faker;

import com.github.javafaker.Faker;
import org.junit.Test;


public class C04_Faker  {
    @Test
    public void test1() {
  /*
        Faker class'indan sahte verileri kullanabilmek icin obje olusturmamiz gerekir
 */
        Faker faker =new Faker();

        //faker objesini kullanarak bir isim yazdiralim
        System.out.println("Isim ="+faker.name().firstName());


        //faker objesini kullanarak bir lastName yazdiralim
        System.out.println("Soyisim ="+faker.name().lastName());

        //faker objesini kullanarak bir fullName yazdiralim
        System.out.println("Full name"+faker.name().fullName());

        //faker objesini kullanarak bir adress yazdiralim
        System.out.println("Full adres= "+faker.address().fullAddress());

        //faker objesini kullanarak bir tel_no yazdıralım
        System.out.println("Cep_No : "+faker.phoneNumber().cellPhone());
        System.out.println("Tel_No : "+faker.phoneNumber().phoneNumber());

        //Rastgele 15 haneli bir numara yazdıralım
        System.out.println("Rastgele 15 haneli bir numara : "+faker.number().digits(15));

        //Meslek pozisyonu
        System.out.println(faker.job().position());


    }
}
