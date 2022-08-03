package QA.Pages;

import QA.BrowserTestBase;
import QA.Enums.LINKS;
import QA.utilities.ReusableMethods;
import QA.utilities.driver.DriverFactoryImplementation;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class ProductsPage extends BrowserTestBase {
    public ProductsPage() {
        PageFactory.initElements(DriverFactoryImplementation.getInstance().getDriver(), this);
    }

    @FindBy(css = "h2.title.text-center")
    public WebElement all_products;

    @FindBy(xpath = "//input[@id='search_product']")
    public WebElement search_products_button;

    @FindBy(xpath = "//button[@id='submit_search']")
    public WebElement submit_search_button;

    @FindBy(xpath = "//div[@class='productinfo text-center']/p")
    public WebElement product_name;

    @FindBy(xpath = "//p")
    public List<WebElement> products;

    @FindBy(xpath = "//div[@class='brands_products']/h2")
    public WebElement brand_header;

    @FindBy(xpath = "//ul[@class='nav nav-pills nav-stacked']//a")
    public List<WebElement> all_brands;
    @FindBy(xpath = "//ul[@class='nav nav-pills nav-stacked']//li")
    public List<WebElement> all_brands_button;

    @FindBy(xpath = "//h2[@class='title text-center']")
    public WebElement brand_title;


    List<String> totalProcducts = new ArrayList<>();
    List<String> allBrandsList = new ArrayList<>();


    public String enterProduct() {

        //ReusableMethods.visitURL(LINKS.PRODUCTS);
       // products.forEach(t -> System.out.println(t.getText()));
        products.stream().filter(t -> t.getText().length() > 0).forEach(t -> totalProcducts.add(t.getText()));
        //System.out.println(totalProcducts.size());

        totalProcducts.remove(totalProcducts.get(totalProcducts.size() - 1));
        totalProcducts.remove(totalProcducts.get(totalProcducts.size() - 1));
        //System.out.println(totalProcducts.size());
        //System.out.println(totalProcducts);

        Random random = new Random();
        return totalProcducts.get(random.nextInt(totalProcducts.size()));

    }

    public void isVisible(String text) {

        System.out.println(text);
        //System.out.println(Driver.getDriver().getCurrentUrl());
        WebElement element = Driver.getDriver().findElement(By.xpath("//p[text()='" + text + "']"));
        //DriverFactoryImplementation.getInstance().getDriver().findElement(By.xpath("//p[text()="+text+"]"));
        Assertions.assertTrue(element.isDisplayed());


    }

    public String getProductName() {
        return product_name.getText();
    }


    public boolean isAllBrandVisible() {
        //ReusableMethods.visitURL(LINKS.PRODUCTS);
       // all_brands.forEach(t -> Assertions.assertTrue(t.isDisplayed()));
        //System.out.println(all_brand.getText() + "is visible");

        try {
            all_brands.forEach(t -> t.isDisplayed());
            return true;
        } catch (NoSuchElementException var2) {
            return false;
        }

    }

    public void clickAnyBrand(String text) {

        all_brands_button.stream().filter(t -> t.getText().toLowerCase().contains(text.toLowerCase())).limit(1).forEach(t -> t.click());
        System.out.println(brand_title.getText());
        Assertions.assertTrue(brand_title.getText().toLowerCase().contains(text.toLowerCase()));

    }



    @Test
    public void showAlltheProducts(){
        ReusableMethods.visitURL(LINKS.PRODUCTS);

        products.stream().forEach(t -> totalProcducts.add(t.getText()));
        System.out.println(totalProcducts.size());
        System.out.println(totalProcducts);

//        products.stream().filter(t -> t.getText().length() > 0).forEach(t -> totalProcducts.add(t.getText()));
//        totalProcducts.remove(totalProcducts.get(totalProcducts.size() - 1));
//        totalProcducts.remove(totalProcducts.get(totalProcducts.size() - 1));
//        System.out.println(totalProcducts.size());
//        System.out.println(totalProcducts);

    }
    @Test
    public void showAllBrands() {
        ReusableMethods.visitURL(LINKS.PRODUCTS);
       // all_brands_button.forEach(t -> allBrandsList.add(t.getText()));
      // System.out.println(allBrandsList);
       List<WebElement>  element = Driver.getDriver().findElements(By.xpath("//ul[@class='nav nav-pills nav-stacked']/li/a"));

        for (int i = 0; i <element.size() ; i=i+1) {
            System.out.println(element.get(i).getText().split("\n")[1]);
            //split("\n")[1]

        }


    }
}

