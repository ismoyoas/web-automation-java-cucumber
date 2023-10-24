package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class addRemoveProduct {
    WebDriver driver;
    @Given("User open SwagLabs website")
    public void userOpenSwagLabsWebsite() throws InterruptedException {
        final String dir = System.getProperty("user.dir");
        String line = "=".repeat(100);
        System.out.println(line);
        System.out.println("Current dir = "+ dir);
        System.setProperty("webdriver.chrome.driver", dir + "/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(1000);
    }

    @And("User login using {string} credential")
    public void userLoginUsingCredential(String credValue) {
        driver.findElement(By.name("user-name")).sendKeys(credValue, Keys.ENTER);
        driver.findElement(By.name("password")).sendKeys("secret_sauce", Keys.ENTER);
        driver.findElement(By.name("login-button")).sendKeys(Keys.ENTER);
    }
    @When("User add Sauce Labs Backpack to Cart")
    public void userAddSauceLabsBackpackToCart() throws InterruptedException {
        System.out.println("[Add] Try to add Sauce Labs Backpack to Cart");
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        Thread.sleep(1000);
        String cartProds = driver.findElement(By.className("shopping_cart_badge")).getText();
        System.out.println("Number of product in Cart: "+ cartProds);
    }

    @And("User add Sauce Labs Fleece Jacket to Cart")
    public void userAddSauceLabsFleeceJacketToCart() throws InterruptedException {
        System.out.println("[Add] Try to add Sauce Labs Fleece Jacket to Cart");
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-fleece-jacket']")).click();
        Thread.sleep(500);
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        Thread.sleep(1000);
        String cartProds = driver.findElement(By.className("shopping_cart_badge")).getText();
        System.out.println("Number of product in Cart: "+ cartProds);
    }

    @And("User remove Sauce Labs Backpack from cart")
    public void userRemoveSauceLabsBackpackFromCart() throws InterruptedException {
        System.out.println("[Remove] Sauce Labs Backpack to Cart");
        driver.findElement(By.name("remove-sauce-labs-backpack")).click();
        Thread.sleep(1000);
    }

    @And("User back to catalogue product")
    public void userBackToCatalogueProduct() throws InterruptedException {
        System.out.println("[Return] Back to catalogue product");
        driver.findElement(By.name("continue-shopping")).click();
        Thread.sleep(1000);
    }

    @And("User add Sauce Labs Bike Light and Sauce Labs Onesie to Cart")
    public void userAddSauceLabsBikeLightAndSauceOnesieToCart() throws InterruptedException {
        System.out.println("[Add] Try to add Sauce Labs Bike Light to Cart");
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-bike-light']")).click();
        Thread.sleep(1000);
        System.out.println("[Add] Try to add Sauce Labs Onesie to Cart");
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-onesie']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//a[@class='shopping_cart_link']")).click();
        Thread.sleep(1000);
        String cartProds = driver.findElement(By.className("shopping_cart_badge")).getText();
        System.out.println("Number of product in Cart: "+ cartProds);
    }

    @And("User remove all of products from cart")
    public void userRemoveAllOfProductsFromCart() throws InterruptedException {
        System.out.println("[Remove] Try to remove Sauce Labs Backpackfrom Cart");
        driver.findElement(By.name("remove-sauce-labs-backpack")).click();
        Thread.sleep(1000);
        System.out.println("[Remove] Try to remove Sauce Labs Bike Light from Cart");
        driver.findElement(By.name("remove-sauce-labs-bike-light")).click();
        Thread.sleep(1000);
        System.out.println("[Remove] Try to remove Sauce Labs Onesie from Cart");
        driver.findElement(By.name("remove-sauce-labs-onesie")).click();
        Thread.sleep(1000);
    }

    @Then("User viewed products that wants to buy")
    public void userViewedProductsThatWantsToBuy() {
        String cartProds = driver.findElement(By.className("shopping_cart_badge")).getText();
        System.out.println("Now, the number of product in Cart: "+ cartProds);
        driver.close();
        driver.quit();
    }
}
