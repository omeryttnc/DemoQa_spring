package QA.Test.BackEnd;

public class TC0401_Test {
    /*
  Random bir user create ediniz. token ve id sini aliniz. bu user icin asagidaki durumlari assertion ediniz:
    1. yanlis userID girildiginde "User Id not correct!" mesajini vedigini ve status kodun 200 oldugunu dogrulayalim
    2. basic authorization ile delete mümkün degildir.
     status codun 401 gelen message'in User is unauthorized! oldugunu kontrol edelim
    3. bos token girerek status codun 401 gelen message'in User is unauthorized! oldugunu kontrol edelim
    4. yanlis token girerek status codun 401 gelen message'in User is unauthorized! oldugunu kontrol edelim
    5. dogru token ve dogru id ile user siline bilmektedir. gelen status kodun 204 oldugunu ve response nin
     {
        "code": "1200",
        "message": "User not authorized!"
    }
    oldugunu verify ediniz
     */
}
