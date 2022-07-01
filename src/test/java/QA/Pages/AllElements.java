package QA.Pages;

public class AllElements {
    private HomePage homePage;
    private Login_SignUpPAGE login_signUpPAGE;

    private ProductsPage productsPage;


    // TODO: 03/06/2022  omer beye soralim neden null kullaniyoruz.
public HomePage getHomePage(){
    if (homePage == null) {
        homePage = new HomePage();
    }
    return homePage;
}


    public Login_SignUpPAGE getlogin_signUpPAGE(){
        if (login_signUpPAGE == null) {
            login_signUpPAGE = new Login_SignUpPAGE();
        }
        return login_signUpPAGE;
    }

    public ProductsPage getProductsPage(){
        if (productsPage == null) {
            productsPage = new ProductsPage();
        }
        return productsPage;
    }



}

