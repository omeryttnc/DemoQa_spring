package QA.Pages;

public class AllElements {
    private HomePage homePage;
    private LoginSignUpPage login_signUpPAGE;
    private ContactUsPage contactUsPage;
    private ProductPage productPage;
    private CartPage cartPage;
    private ProductsPage productsPage;
    private CheckoutPage checkoutPage;
    private PaymentPage paymentPage;

    public HomePage getHomePage() {
        if (homePage == null) {
            homePage = new HomePage();
        }
        return homePage;

    }


    public LoginSignUpPage getlogin_signUpPAGE() {
        if (login_signUpPAGE == null) {
            login_signUpPAGE = new LoginSignUpPage();
        }
        return login_signUpPAGE;
    }

    public ContactUsPage getContactUsPage() {
        if (contactUsPage == null) {
            contactUsPage = new ContactUsPage();
        }
        return contactUsPage;
    }

    public ProductPage getProductPage() {
        if (productPage == null) {
            productPage = new ProductPage();
        }
        return productPage;
    }

    public ProductsPage getProductsPage() {
        if (productsPage == null) {
            productsPage = new ProductsPage();
        }
        return productsPage;
    }

    public CartPage getCartPage() {
        if (cartPage == null) {
            cartPage = new CartPage();
        }
        return cartPage;
    }

    public CheckoutPage getCheckoutPage() {
        if (checkoutPage == null) {
            checkoutPage = new CheckoutPage();
        }
        return checkoutPage;
    }

    public PaymentPage getPaymentPage(){
        if(paymentPage==null){
            paymentPage = new PaymentPage();
        }
        return paymentPage;
    }
}

