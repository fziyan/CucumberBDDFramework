package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utilities.Driver;

public class DemoQaHomePage {

    public DemoQaHomePage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(xpath = "//*[@id=\"app\"]/div/div/div[2]/div/div[1]/div/div[1]")
    public WebElement elemetCard;

    @FindBy(xpath = "//span[text()='Dynamic Properties']")
    public WebElement dynamicPropButton;



}
