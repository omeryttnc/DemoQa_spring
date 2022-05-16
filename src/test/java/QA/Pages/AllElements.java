package QA.Pages;

public class AllElements {
    private HomePage homePage;


public HomePage getHomePage(){
    if (homePage == null) {
        homePage = new HomePage();
    }
    return homePage;
}






}

