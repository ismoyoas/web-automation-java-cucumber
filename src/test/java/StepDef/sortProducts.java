package StepDef;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class sortProducts {
    WebDriver driver;
    @Given("User open Swag Labs website")
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

    @And("User try login using {string} credential")
    public void userTryLoginUsingCredential(String credValue) {
        driver.findElement(By.name("user-name")).sendKeys(credValue, Keys.ENTER);
        driver.findElement(By.name("password")).sendKeys("secret_sauce", Keys.ENTER);
        driver.findElement(By.name("login-button")).sendKeys(Keys.ENTER);
    }

    @Then("User got price list products from low to high")
    public void userGotPriceListProductsFromLowToHigh() {
        System.out.println("User got price list products from low to high");
        driver.close();
        driver.quit();
    }

    @When("User try to sort product price low to high")
    public void userTryToSortProductPriceLowToHigh() {
        new Select(driver.findElement(By.className("product_sort_container"))).selectByValue("lohi");
    }

    @And("User try to sort product price high to low")
    public void userTryToSortProductPriceHighToLow() {
        new Select(driver.findElement(By.className("product_sort_container"))).selectByValue("hilo");
    }

    @And("User try to sort product name A to Z")
    public void userTryToSortProductNameAToZ() {
        new Select(driver.findElement(By.className("product_sort_container"))).selectByValue("az");
    }

    @And("User try to sort product name Z to A")
    public void userTryToSortProductNameZToA() {
        new Select(driver.findElement(By.className("product_sort_container"))).selectByValue("za");
    }

    @Then("User cannot see product by sorting feature")
    public void userCannotSeeProductBySortingFeature() {
        System.out.println("User cannot see product by sorting feature");
        driver.close();
        driver.quit();
    }

    @And("Show the user notification")
    public void showTheUserNotification() {
        String userNotif = driver.switchTo().alert().getText();
        System.out.println("Alert Notification : "+userNotif);
        driver.switchTo().alert().accept();
    }
}
