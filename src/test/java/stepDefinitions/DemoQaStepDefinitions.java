package stepDefinitions;

import io.cucumber.java.en.*;
import org.junit.Assert;
import org.openqa.selenium.JavascriptExecutor;
import pages.DemoQaHomePage;
import utilities.ConfigReader;
import utilities.Driver;
import utilities.ReusableMethods;

import static utilities.Driver.driver;

public class DemoQaStepDefinitions {
    DemoQaHomePage demoQaHomePage = new DemoQaHomePage();

    @Given("User go to the demoqa homepage")
    public void user_go_to_the_demoqa_homepage() {
        Driver.getDriver().get(ConfigReader.getProperty("demoqaURL"));
        String actualURL = Driver.getDriver().getCurrentUrl();
        String expectedURL = "https://demoqa.com/";
        Assert.assertEquals(actualURL, expectedURL);
    }
    @When("Select elements button and back homepage")
    public void select_elements_button_and_back_homepage() {
        ReusableMethods.clickWithJS(demoQaHomePage.elemetCard);
        ReusableMethods.wait(5);
        Driver.getDriver().navigate().back();
    }
    @Then("user validate url")
    public void user_validate_url() {
        String actualURL = Driver.getDriver().getCurrentUrl();
        String expectedURL = "https://demoqa.com/";
        Assert.assertEquals(actualURL, expectedURL);
    }

}
