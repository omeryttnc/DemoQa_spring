package QA.Pages;

public class AllElements {
    private HomePage homePage;
    private Login_SignUpPAGE login_signUpPAGE;
    private ContactUsPage contactUsPage;
    private ProductPage productPage;
    private CartPage cartPage;

    
    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;

    }


    public Login_SignUpPAGE getlogin_signUpPAGE() {
        if (login_signUpPAGE == null) {
            login_signUpPAGE = new Login_SignUpPAGE();
        }
        return login_signUpPAGE;
    }
    public ContactUsPage getContactUsPage(){
        if (contactUsPage == null) {
            contactUsPage = new ContactUsPage();
        }
        return contactUsPage;
    }

public ProductPage getProductPage(){
    if (productPage==null){
        productPage=new ProductPage();
    }
    return productPage;}


public CartPage getCartPage(){
    if (cartPage==null){
        cartPage=new CartPage();
    }
    return cartPage;
}



}

