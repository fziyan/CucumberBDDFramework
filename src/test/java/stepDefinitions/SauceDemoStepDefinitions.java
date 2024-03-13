package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import pages.SauceDemoPage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

public class SauceDemoStepDefinitions {

    SauceDemoPage sauceDemoPage = new SauceDemoPage();
    @Given("User navigate homepage")
    public void user_navigate_homepage() {
        Driver.getDriver().get(ConfigReader.getProperty("testSiteURL"));
    }
    @When("User enter username password and click submit button")
    public void user_enter_username_password_and_click_submit_button() {
        ReusableMethods.wait(2);
        sauceDemoPage.username.click();
        sauceDemoPage.username.sendKeys(ConfigReader.getProperty("username"));
        ReusableMethods.wait(2);
        sauceDemoPage.password.click();
        sauceDemoPage.password.sendKeys(ConfigReader.getProperty("password"));
        sauceDemoPage.loginButton.click();
    }

    @Then("User see the product page title")
    public void user_see_the_product_page_title() {
        String expectedResult = "Products";
        String actualResult = sauceDemoPage.productPageTitle.getText();
        Assert.assertEquals(expectedResult,actualResult);
        System.out.println("Kullanici sisteme login oldu ve Products sayfasına geldi");

    }

    @Then("User close the browser")
    public void userCloseTheBrowser() {
        Driver.closeDriver();
    }

    @When("Username password information is entered incorrectly and submit button")
    public void username_password_information_is_entered_incorrectly_and_submit_button() {
        sauceDemoPage.username.sendKeys(ConfigReader.getProperty("incorrect_username"));
        sauceDemoPage.password.sendKeys(ConfigReader.getProperty("incorrect_password"));
        sauceDemoPage.loginButton.click();
    }
    @Then("User see validation error message for username and password field")
    public void user_see_validation_error_message_for_username_and_password_field() {
        String expectedResult = "Epic sadface: Username and password do not match any user in this service";
        ReusableMethods.wait(5);
        String actualResult = sauceDemoPage.errorMessage_not_username_password.getText();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @When("Username enter valid and password enter incorrect")
    public void username_enter_valid_and_password_enter_incorrect() {
        sauceDemoPage.username.sendKeys(ConfigReader.getProperty("username"));
        sauceDemoPage.password.sendKeys(ConfigReader.getProperty("incorrect_password"));
        sauceDemoPage.loginButton.click();
    }
    @Then("user see validation error for password field")
    public void user_see_validation_error_for_password_field() {
        String expectedResult = "Epic sadface: Username and password do not match any user in this service";
        String actualResult = sauceDemoPage.errorMessage_not_username_password.getText();
        Assert.assertEquals(actualResult, expectedResult);
    }

    @When("User does not enter username and enter password")
    public void userDoesNotEnterUsernameAndEnterPassword() {
        sauceDemoPage.password.sendKeys(ConfigReader.getProperty("password"));
    }
    @When("User click login button")
    public void user_click_login_button() {
        sauceDemoPage.loginButton.click();
    }
    @Then("user see validation error for empty username field")
    public void user_see_validation_error_for_empty_username_field() {
        String expectedResult = "Epic sadface: Username is required";
        String actualResult = sauceDemoPage.errorMessage_notUsername.getText();
        Assert.assertEquals(actualResult, expectedResult);
    }
}
