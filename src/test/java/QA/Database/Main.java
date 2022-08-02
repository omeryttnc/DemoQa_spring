package QA.Database;


import QA.Enums.DeliveryCost;
import QA.Enums.USERINFO;
import QA.Enums.urunler;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EnumSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.WebElement;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {

    }

    void login(String email, String pass) {
        System.out.println(email + " :" + pass);
    }

    void login2(USERINFO user) {
        System.out.println(user.getEmail() + " :" + user.getPassword());
        System.out.println(user.getToken() + " : " + user.getLat());
    }

    @Test
    public void enum_method() {

        for (USERINFO w : USERINFO.values()) {
            System.out.println(w.getEmail());
        }


    }


    @Test
    public void sssss() {
        String[] email = {"email1", "email21", "email41", "email31", "email51"};
        for (int i = 0; i < email.length; i++) {

            if (email[i].contains("3")) {
                Assertions.fail();
            }
        }

    }

    @ParameterizedTest
    @ValueSource(ints = {2,3,4,5,6})
    public void sdasde(int input) {
        System.out.println(input*5);
    }

    @ParameterizedTest
    @ValueSource(strings = {"omer","ali","kasim","mahmut"})
    public void sdsasde(String input) {

        System.out.println(input);

    }


    @ParameterizedTest
    @CsvSource({
            "promoco5,email,pass,5",
            "kasim,email2,pass2,56",
            "mahmut,email3,pass3,98"

    })
    public void asdsar(String name,String email,String pass, int age) {
        System.out.println(name +" : " + email+ " :  : " + age);



    }



    @ParameterizedTest
    @EnumSource(USERINFO.class)
    public void parametized_test(USERINFO user) {

        if (user.getEmail().contains("3")) {
            Assertions.fail();
        }
        System.out.println(user.getEmail());
    }

    @Test
    public void sss() {
        System.out.println(DeliveryCost.teslim(260));
    }

    @Test
    public void ss() {
        login(USERINFO.ALICI.getEmail(), USERINFO.ALICI.getPassword());
        System.out.println("*********");
        login2(USERINFO.ALICI);
    }

    @Test
    public void enum_deneme() {
        System.out.println(urunler.KARPUZ.getProductName());

    }

    @BeforeEach
    void urunEkliyoruz() {
        Products.addProduct(HUBS.VEGETABLE_HUB, HUBS.VEGETABLE.Elma.name(), 25.2, 100, true, true);
        Products.addProduct(HUBS.VEGETABLE_HUB, HUBS.VEGETABLE.Kayisi.name(), 15.2, 56, true, false);
        Products.addProduct(HUBS.VEGETABLE_HUB, HUBS.VEGETABLE.Ananas.name(), 228.2, 1400, true, true);
        Products.addProduct(HUBS.VEGETABLE_HUB, HUBS.VEGETABLE.Armut.name(), 0.22, 0, false, true);
        Products.addProduct(HUBS.VEGETABLE_HUB, HUBS.VEGETABLE.Ayva.name(), 25.2, 100, true, false);
        Products.addProduct(HUBS.VEGETABLE_HUB, HUBS.VEGETABLE.Muz.name(), 52.12, 0, true, false);
        Products.addProduct(HUBS.VEGETABLE_HUB, HUBS.VEGETABLE.Karpuz.name(), 208.2, 4, true, true);
        Products.addProduct(HUBS.VEGETABLE_HUB, HUBS.VEGETABLE.Cilek.name(), 0.02, 1, false, false);
        Products.addProduct(HUBS.VEGETABLE_HUB, HUBS.VEGETABLE.Kavun.name(), 25.52, 2, true, true);
        Products.addProduct(HUBS.VEGETABLE_HUB, HUBS.VEGETABLE.Erik.name(), 45.2, 0, false, false);
        Products.addProduct(HUBS.VEGETABLE_HUB, HUBS.VEGETABLE.Dut.name(), 28.42, 5, true, false);
        Products.addProduct(HUBS.VEGETABLE_HUB, HUBS.VEGETABLE.Kiraz.name(), 5, 100, false, true);
        Products.addProduct(HUBS.DAIRY_HUB, HUBS.DAIRY.Sut.name(), 207.2, 100, false, true);
        Products.addProduct(HUBS.DAIRY_HUB, HUBS.DAIRY.Yogurt.name(), 260.2, 4, false, false);
        Products.addProduct(HUBS.DAIRY_HUB, HUBS.DAIRY.Kaymak.name(), 220.2, 100, true, true);
        Products.addProduct(HUBS.DAIRY_HUB, HUBS.DAIRY.Ayran.name(), 204.2, 5, false, true);
        Products.addProduct(HUBS.COMPOST_HUB, HUBS.COMPOST.At_Tezegi.name(), 20.2, 100, false, true);
        Products.addProduct(HUBS.COMPOST_HUB, HUBS.COMPOST.Inek_Tezegi.name(), 230.2, 100, false, false);
        Products.addProduct(HUBS.COMPOST_HUB, HUBS.COMPOST.Balik_Tezegi.name(), 20.2, 100, false, true);
        Products.addProduct(HUBS.SEED_HUB, HUBS.SEED.Kavun_Cekirdegi.name(), 20.2, 100, false, true);
        Products.addProduct(HUBS.TREE_HUB, HUBS.TREE.Cam_Agaci.name(), 20.2, 100, false, true);
    }

    List<Integer> integerList = Arrays.asList(12, 545, 7, 989, 32, 21, 11, 214);


    // yazdirmalar daha sonra manupule edebilmek icin listelere aktarilacak ama simdilik yazdirmakla yetinecegiz

    // tum sut urunlerini yazdir
    // icinde a harfi gecen sut urunlerini yazdir
    // available sut urunlerini yazdir
    // available olup da organic olmayan urunleri yazdir
    // stock miktari 0 olan urunleri hub , product name olacak sekilde yazdir
    // en pahali urunleri hublariyla beraber yazdir


    /////////                            bonus-1                  ////////////////
    // Product daki sellItem methodu nu kullanarak urun satildiginda stockdan dusuldugune test et
    // note : sellItem methodu iki parametre istiyor biri urunun adi digeri de satilacak miktar

    /////////                            bonus-2                  ////////////////
    // Product daki total methodu nu kullanarak urun satildiginda hesaplanan fiyat dogru mu hesaplaniyor testi ni yap
    // note : total methodu iki parametre istiyor biri urunun adi digeri de satilacak miktar


    ///////                              max - bonus           /////////////////////
    // yaptigim sistemde en az bir tane bug var o bug nedir acaba ????


    @Test
    public void lambda_1() {
        // tum sut urunlerini yazdir
        for (int i = 0; i < Products.getProduct().size(); i++) {
            if (Products.getProduct().get(i).getHubs().toString().equals("DAIRY_HUB")) {

                System.out.println(Products.getProduct().get(i).getProductName());
            }
        }
        Products.getProduct().stream().filter(t -> t.getHubs().toString().equals(HUBS.DAIRY_HUB.name()))
                .forEach(t -> System.out.println(t.getProductName()));
    }

    @Test
    public void lambda_2() {
        // icinde a harfi gecen sut urunlerini yazdir
        Products.getProduct().stream().filter(t -> t.getHubs().toString().equals(HUBS.DAIRY_HUB.name()))
                .filter(t -> t.getProductName().contains("a"))
                .filter(t -> t.getProductQuantity() > 10)
                .forEach(t -> System.out.println(t.getProductName()));


    }

    Map<String, Integer> getMap() {
        Map<String, Integer> map = new HashMap<>();
        map.put("domates", 3);
        map.put("salatalik", 43);
        map.put("uzum", 35);
        map.put("kiraz", 37);
        map.put("maydanoz", 73);
        map.put("marul", 343);
        map.put("karpuz", 352);
        return map;
    }

    @Test
    public void lambda_3() {
        List<String> list = new ArrayList<>();
        // fiyati 50 ucuz olan urunlerin isimleri
//       for (Integer w : getMap().values()){
//           if (w < 50) {
//               System.out.println(getMap().values(w));
//           }
//
//       }

        getMap().entrySet().stream().filter(t -> t.getValue() < 50).forEach(t -> {

                    System.out.println(t.getKey());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }

                }
        );


        getMap().values().stream().filter(t -> t > 50).forEach(t -> System.out.println(t));

    }

    List<String> stringList = Arrays.asList("zomer", "mahmut", "okkes", "kasim", "zmurtaza", "mustafa");

    @Test
    public void lambda_4() {
        // ismi en uzun olan

        System.out.println(stringList.stream().map(String::length).sorted(Comparator.reverseOrder()).findFirst().get());
        System.out.println(stringList.stream().map(String::length).max(Comparator.naturalOrder()).get());

//sorted
        System.out.println(Products.getProduct().stream().sorted(Comparator.comparing(t -> t.getProductQuantity())).limit(1));

    }

    @Test
    public void lambda_5() {

//        HUBS.


        //sut urunlerinde organic olmayan product var mi ?
//        Products.getProduct().stream()                .filter(t->t.getHubs().toString().equals(HUBS.DAIRY_HUB.name())).anyMatch(t->t.);

    }

    @Test
    public void ornek() {

        Supplier<String> stringSupplier = () -> Assertions.fail();
        Consumer<String> stringConsumer = (t) -> t.toLowerCase();
        Predicate<WebElement> webElementPredicate = (t) -> t.getAttribute("value").equalsIgnoreCase("omer");
        Function<String, Integer> stringIntegerFunction = t -> t.length();
        stringList.stream().filter(t -> t.length() > 10).findAny().orElseGet(() -> Assertions.fail());

//stringList.stream().max(Comparator.naturalOrder())
        Stream<Products> sorted = Products.getProduct().stream().sorted(Comparator.comparing(t -> t.getProductName().length()));

//        for (int i = 0; i < 10; i++) {
//
//        System.out.println(stringList.stream().findFirst().orElseGet(()->"ss"));
//        System.out.println(stringList.stream().findFirst().orElse("something went wrong "));
//            System.out.println(stringList.stream().filter(t->t.length()>10).findAny().orElseThrow());
//        }
//        System.out.println("***************************");

//
//        Predicate<String> isim = (t)->t.toLowerCase().equals(HUBS.VEGETABLE_HUB.name());
//        System.out.println(getMap().keySet());
//        System.out.println(getMap().values());
//        System.out.println(Products.getProduct().get(0).getProductName());
//        System.out.println("***************************");
//        // ilk urunun quantity sini aliyorum
//        System.out.println(Products.getProduct().get(0).getProductQuantity());    // 100
//        //ilk urunden 10 tane alip kalan tutara bakiyorum
//        System.out.println(Products.sellItem(HUBS.VEGETABLE.Elma.name(), 10));  //90
//        //ilk urunden 2 tane alip fiyatini hesaplatiyorum
//        System.out.println(Products.total(HUBS.VEGETABLE.Elma.name(), 2));  // 50.4
    }

}
