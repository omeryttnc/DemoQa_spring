package QA.Pages;

public class AllElements {
    private HomePage homePage;
    private Login_SignUpPAGE login_signUpPAGE;


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




}

