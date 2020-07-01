package stepDefinition;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.*;

import java.util.concurrent.TimeUnit;

public class add_cart {

    WebDriver driver=null;
    WebDriverWait driverWait=null;


    private void init(){
        System.setProperty("webdriver.chrome.driver","chromedriver");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.navigate().to("https://www.bhinneka.com/");
        driverWait = new WebDriverWait(driver,10);

    }




    @Given("user is on home page")
    public void user_is_on_home_page() {

        init();

    }

    @When("user searching product")
    public void user_searching_product() {
        driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys("ROG");
        driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(Keys.ENTER);

    }

    @And("choose the product")
    public void choose_the_product() {

        driver.findElement(By.xpath("//p[contains(.,'ASUS ROG Zephyrus M GU502GU-I7662T [90NR0252-M02830] - Mylar Black')]")).click();

    }

    @Then("user add to cart")
    public void user_add_to_cart() {

        driver.findElement(By.id("btnBuy")).click();

    }

    @Then("the result is user must be logged")
    public void the_result_is_user_must_be_logged() {

        driver.findElement(By.className("swal-text")).toString().equals("Anda harus login sebelum melanjutkan.");
        driver.close();
        driver.quit();
    }


    @When("user go to check page cart")
    public void user_go_to_check_page_cart(){

        user_is_on_login_page();

        driver.findElement(By.xpath("//header[@id='bt-header']/div/div/div[3]/a/img")).click();

    }

    @Then("there is default caption for empty cart")
    public void there_is_default_caption_for_empty_cart(){
        driver.findElement(By.xpath("//div[3]/div/div/h2")).getText().equals("Keranjang Kosong");

    }



    @When("user is on login page")
    public void user_is_on_login_page() {

        init();
        driver.navigate().to("https://www.bhinneka.com/");

        driver.findElement(By.linkText("Login")).click();

        driver.findElement(By.id("email")).sendKeys("testing.hiring.00@gmail.com");
        driver.findElement(By.id("next")).click();
        driver.findElement(By.id("password")).sendKeys("P@ssw0rd");
        driver.findElement(By.xpath("//button[contains(.,'MASUK')]")).click();

    }

    @Then("User search product with keyword ROG")
    public void User_search_product_with_keyword_ROG() {
        driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys("ROG");
        driver.findElement(By.xpath("(//input[@type='search'])[2]")).sendKeys(Keys.ENTER);

    }


    @Then("user add 3 product to cart")
    public void user_add_3_product_to_cart() {
        driver.findElement(By.xpath("//p[contains(.,'ASUS ROG Zephyrus M GU502GU-I7662T [90NR0252-M02830] - Mylar Black')]")).click();
        driver.findElement(By.id("atc")).click();
        driver.findElement(By.xpath("//button[contains(.,'Kembali Berbelanja')]")).click();
        driver.navigate().back();
        driver.findElement(By.xpath("//p[contains(.,'ASUS ROG Strix III G531GD-I505G4T [90NR0263-M02000] - Metal Black')]")).click();
        new WebDriverWait(driver, 10).until(ExpectedConditions.elementToBeClickable(By.id("onesignal-popover-cancel-button"))).click();
        driver.findElement(By.id("atc")).click();
        driver.findElement(By.xpath("//button[contains(.,'Kembali Berbelanja')]")).click();
        driver.navigate().back();
        driver.findElement(By.xpath("//p[contains(.,'ASUS ROG Zephyrus GX531GM-I7614T [90NR0101-M00180]')]")).click();
        driver.findElement(By.id("atc")).click();
        driver.findElement(By.id("goToCart")).click();


    }



    @Then("the counter product in cart is 3")
    public void the_counter_product_in_cart_is_3() {
        driver.findElement(By.cssSelector(".col-lg-7 > p")).getText().equals("Total (3) Barang");
        driver.close();
        driver.quit();
    }


    @When("user is on cart page")
    public void user_is_on_cart_page(){

        user_is_on_login_page();

        driver.findElement(By.xpath("//header[@id='bt-header']/div/div/div[3]/a/img")).click();
    }

    @Then("user delete product in chart")
    public void user_delete_product_in_chart(){
        driver.findElement(By.xpath("//div[3]/div[2]/div/div/button/span")).click();
        driver.findElement(By.id("deleteconfirm")).click();
    }

    @Then("the counter product in cart is 2")
    public void the_counter_product_in_cart_is_2(){
        driver.findElement(By.cssSelector(".col-lg-7 > p")).getText().equals("Total (2) Barang");
        driver.close();
        driver.quit();

    }







}
