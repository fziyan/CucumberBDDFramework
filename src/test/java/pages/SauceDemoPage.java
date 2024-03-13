package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class SauceDemoPage {
    public SauceDemoPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id=\"user-name\"]")
    public WebElement username;

    @FindBy(xpath = "//*[@id=\"password\"]")
    public WebElement password;

    @FindBy(xpath = "//*[@id=\"login-button\"]")
    public WebElement loginButton;

    @FindBy(xpath = "//span[text()='Products']")
    public WebElement productPageTitle;

    @FindBy(xpath = "//h3[text()='Epic sadface: Username and password do not match any user in this service']")
    public WebElement errorMessage_not_username_password;

    @FindBy(xpath = "//h3[text()='Epic sadface: Username is required']")
    public WebElement errorMessage_notUsername;

    @FindBy(xpath = "//h3[text()='Epic sadface: Password is required']")
    public WebElement errorMessage_notPassword;





}
