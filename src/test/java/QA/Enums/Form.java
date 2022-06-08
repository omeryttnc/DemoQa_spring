package QA.Enums;

import QA.BrowserTestBase;

public enum Form {
    A_FORMU("ALIgjghjghjghjghjghjghj","KILIC","A@GMAIL.COM","12345"),
    B_FORMU("D","F","D","FF"),
    C_FORMU("DSFDSF","DFDSFl","FDSFDk","DFDFDF"),
    D_FORMU("DSFDSF","DFDSF","FDSFD@GMAIL.COM","DFDFDFDF");


    private String Firstname;
    private String Lastname;
    private String email;
    private String password;

    Form(String firstname, String lastname, String email, String password) {
        Firstname = firstname;
        Lastname = lastname;
        this.email = email;
        this.password = password;
    }

    public String getFirstname() {
        return Firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }


public static class enumMethods {
    public static void enumMethod_Salary(Form form) {
        double salary = 1000;
        switch (form){
            case A_FORMU:
                salary=salary+(salary*0.25);
                break;
                case B_FORMU:
                salary=salary+(salary*0.35);
                break;
                case C_FORMU:
                salary=salary+(salary*0.45);
                break;
                case D_FORMU:
                salary=salary+(salary*0.50);
                break;
        }
        System.out.println("salary = " + salary);
    }
}

}

