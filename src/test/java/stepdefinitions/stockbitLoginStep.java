package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;


public class stockbitLoginStep {

    WebDriver driver;
    WebDriverWait wait;


    @Given("user is on the Stockbit homepage")
    public void user_is_on_homepage() {
        WebDriverManager.chromedriver().setup();

        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito"); // Avoid Chrome password prompts
        options.addArguments("--disable-notifications");

        // Disable old password manager prefs
        Map<String, Object> prefs = new HashMap<>();
        prefs.put("credentials_enable_service", false);
        prefs.put("profile.password_manager_enabled", false);
        prefs.put("profile.password_manager_leak_detection", false);
        options.setExperimentalOption("prefs", prefs);

        // Create driver with options
        driver = new ChromeDriver(options);
        driver.manage().window().maximize();

        // Go to Stockbit homepage
        driver.get("https://stockbit.com");

        // Initialize wait
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));

        // Optional: Close "Change your password" popup if it appears
//        try {
//            WebDriverWait shortWait = new WebDriverWait(driver, Duration.ofSeconds(5));
//            WebElement changePassPopup = shortWait.until(
//                    ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[contains(text(),'Change your password')]"))
//            );
//            // Click Cancel or Close button inside popup
//            changePassPopup.findElement(By.xpath(".//button[text()='Ok']")).click();
//        } catch (Exception e) {
//            // Popup not shown, continue
//        }

    }

    @When("user navigates to the login page")
    public void user_navigates_to_login_page() {
        WebElement loginBtn = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[normalize-space()='Log In']")));
        loginBtn.click();
    }

    @When("user enters email {string}")
    public void user_enters_email(String email) {
        WebElement inputEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='username']")));
        inputEmail.sendKeys(email);
    }

    @When("user enters password {string}")
    public void user_enters_password(String password) {
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys(password);
    }

    @When("user clicks the login button")
    public void user_clicks_login_button() {
        driver.findElement(By.xpath("//p[normalize-space()='Login']")).click();
    }

    @Then("user should see the error message")
    public void user_should_see_the_error_message() {
        //element alert failed login
        WebElement alertError = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='alert-red']")));
        String actualMsgError = alertError.getText();
        String expectError = "Username atau password salah. Mohon coba lagi.";
        //assert
        Assert.assertEquals(actualMsgError, expectError, "Page title does not match. and shown actual message = " + actualMsgError);

        // Close browser after test
        driver.quit();
    }
}
