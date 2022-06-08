package QA.Test;

import QA.BrowserTestBase;
import QA.Enums.*;
import QA.Jenkins.SmokeTest;
import QA.utilities.ConfigurationReader;
import QA.utilities.ReusableMethods;

import java.sql.*;
import java.util.EnumMap;
import java.util.EnumSet;
public class Enum_Test extends BrowserTestBase {

    @SmokeTest
    public void dummy() {
//        myForm_enum(Form.A_FORMU);
//        myForm("","","","");
//        switchcase(Form.A_FORMU);
//        forEach();
//       values_valueOf();
//       enumSet();
//       enumMap();
//       testtekullanim();
//       ordinal();
//       Form.enumMethods.enumMethod_Salary(Form.A_FORMU);

    }
    //////////////////////////////////////  obje olusturarark tek parametre ile method olusturma.  ///////////////////

    public void myForm_enum(Form form){
        System.out.println(form.getEmail());
        System.out.println(form.getFirstname());
        System.out.println(form.getLastname());
        System.out.println(form.getPassword());
    }

    public void myForm(String email, String Lastname, String firstName, String password){
        System.out.println("email = " + email);
        System.out.println("email = " + Lastname);
        System.out.println("email = " + firstName);
        System.out.println("email = " + password);

    }


    /////////////////////////////////////   SWITCH CASE    ///////////////////////////////////////////////

    public void switchcase(Form form){
        switch (form){
            case A_FORMU:
            case B_FORMU:
            case C_FORMU:
                System.out.println("Form = " + form.name()+" password: "+form.getPassword());
                break;
        }
    }


    //////////////////////////////////   FOR EACH /VALUES    /////////////////////////////////////////////////

    public void forEach(){
        for (Form form:Form.values()
             ) {
            System.out.println(form.name());

        }

    }
////////////////////////////////////  VALUES/VALUE OF   /////////////////////////////////////////////
    public void values_valueOf(){
        Form[] values = Form.values();
        System.out.println(values.length);
        System.out.println(Form.valueOf("A_FORMU"));
    }

    ////////////////////////  ENUMSET   ///////////////////////////////////////////////////////////

    public void enumSet(){
        EnumSet <Form> enumSet=EnumSet.of(Form.A_FORMU,Form.B_FORMU,Form.C_FORMU);
        System.out.println(enumSet);

    }

    /////////////////////////// ENUMMAP    ///////////////////////////////////////////////////////////
    public void enumMap(){
        EnumMap<Form, String> enumMap=new EnumMap<Form, String>(Form.class);

        enumMap.put(Form.A_FORMU,"FORM A");
        enumMap.put(Form.B_FORMU,"FORM B");
        enumMap.put(Form.C_FORMU,"FORM C");
        System.out.println(enumMap);
    }
    /////////////////////////////////////  ordinal   /////////////////////////////////////
    public void ordinal(){
        System.out.println("Form.A_FORMU.ordinal() = " + Form.A_FORMU.ordinal());
        System.out.println("Form.B_FORMU.ordinal() = " + Form.B_FORMU.ordinal());
        System.out.println("Form.C_FORMU.ordinal() = " + Form.C_FORMU.ordinal());

    }


    /////////////////////////////////  testte kullanim ornekleri ///////////////////////////

    public void testtekullanim(){
        ReusableMethods.visitURL(LINKS.GOOGLE);
        System.out.println(Driver.getDriver().getCurrentUrl());
        System.out.println(urunler.KARPUZ.getProductName());
        System.out.println(USERINFO.LOGIN_TEST.getEmail());


        System.out.println(APIENDPOINT.DEMO.getGet());
    }

    ///////////////////////////////////////////  SQL QUERY YAPARKEN    //////////////////////
    public void testtekullanim2() throws SQLException {
        String sql = "SELECT * FROM `attendance` ORDER BY `attendance`.`created` DESC"; //ENUM KULLANILABILIR
        try (
                Connection conn = DriverManager.getConnection(
                        ConfigurationReader.getProperty("database_url"),
                        ConfigurationReader.getProperty("database_username"),
                        ConfigurationReader.getProperty("database_password")
                );
                Statement stmt = conn.createStatement();
                ResultSet rs = stmt.executeQuery(SQL_QUERY.SELECET_EVENT_CHECK_OUT.getSql()))
        {
            while (rs.next()) {

                }

            }
        }}

