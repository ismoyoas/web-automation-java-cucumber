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

public class login {
    WebDriver driver;
    @Given("User open chrome browser")
    public void userOpenChromeBrowser() {
        final String dir = System.getProperty("user.dir");
        String line = "=".repeat(100);
        System.out.println(line);
        System.out.println("Current dir = "+ dir);
        System.setProperty("webdriver.chrome.driver", dir + "/driver/chromedriver.exe");
        driver = new ChromeDriver();
    }

    @And("User open website SwagLabs")
    public void userOpenWebsiteSwagLabs() throws InterruptedException {
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(1000);
    }

    @When("User type username {string}")
    public void userTypeUsername(String userValue) {
        WebElement userName = driver.findElement(By.name("user-name"));
        userName.sendKeys(userValue, Keys.ENTER);
    }

    @And("User type password {string}")
    public void userTypePassword(String passValue) {
        WebElement userName = driver.findElement(By.name("password"));
        userName.sendKeys(passValue, Keys.ENTER);
    }

    @Then("User click login button")
    public void userClickLoginButton() {
        WebElement loginBtn = driver.findElement(By.name("login-button"));
        loginBtn.sendKeys(Keys.ENTER);
    }

    @Then("User directed to dashboard")
    public void userDirectedToDashboard() {
        driver.findElement(By.className("app_logo")).isDisplayed();
        String productElement = driver.findElement(By.className("title")).getText();
        System.out.println("User Logged in successfully and "+productElement+" is displayed");
        driver.close();
        driver.quit();
    }

    @Then("Show warning notification")
    public void showWarningNotification() {
        String errorNotification = driver.findElement(By.cssSelector("h3[data-test='error']")).getText();
        System.out.println("Show notification\n"+ errorNotification);
        driver.close();
        driver.quit();
    }
}
