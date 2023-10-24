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

import java.util.List;

public class productDisplay {
    WebDriver driver;
    String imgDisp, imgDesc;
    @Given("User open SwagLabs")
    public void userOpenSwagLabs() throws InterruptedException {
        final String dir = System.getProperty("user.dir");
        String line = "=".repeat(100);
        System.out.println(line);
        System.out.println("Current dir = "+ dir);
        System.setProperty("webdriver.chrome.driver", dir + "/driver/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get("https://www.saucedemo.com/");
        Thread.sleep(1000);
    }

    @And("User login using valid {string} credential")
    public void userLoginUsingValidCredential(String credValue) {
        driver.findElement(By.name("user-name")).sendKeys(credValue, Keys.ENTER);
        driver.findElement(By.name("password")).sendKeys("secret_sauce", Keys.ENTER);
        driver.findElement(By.name("login-button")).sendKeys(Keys.ENTER);
    }

    @When("User check a products")
    public void userCheckAProducts() {
        imgDisp = driver.findElement(By.xpath("//img[@alt='Sauce Labs Backpack']")).getAttribute("src");
        System.out.println("Product picture in catalog page : "+imgDisp);
        WebElement linkBtn = driver.findElement(By.xpath("//a[@id='item_4_img_link']"));
        linkBtn.click();
        imgDesc = driver.findElement(By.xpath("//img[@class='inventory_details_img']")).getAttribute("src");
        System.out.println("Product picture in description page : "+imgDesc);
    }

    @Then("User got products picture profile comparison")
    public void userGotProductsPictureProfileComparison() {
        if (imgDisp.equals(imgDesc)){
            System.out.println("Result of comparison picture: Same");
        } else {
            System.out.println("Result of comparison picture: Not same");
        }
        driver.findElement(By.name("back-to-products")).sendKeys(Keys.ENTER);
        driver.close();
        driver.quit();
    }
}
