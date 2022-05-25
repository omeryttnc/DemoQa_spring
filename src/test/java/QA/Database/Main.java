package QA.Database;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public class Main {

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

    List<String> stringList = Arrays.asList("omer", "mahmut", "okkes", "kasim", "murtaza", "mustafa");
    List<Integer> integerList = Arrays.asList(12, 545, 7, 989, 32, 21, 11, 214);


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
    public void ornek() {

        Supplier<String> stringSupplier = () -> Assertions.fail();
        Consumer<String> stringConsumer = (t)->t.toLowerCase();
        Predicate<WebElement>webElementPredicate = (t)->t.getAttribute("value").equalsIgnoreCase("omer");
        Function<String,Integer> stringIntegerFunction = t->t.length();
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
