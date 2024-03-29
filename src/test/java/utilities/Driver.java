package utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

import java.time.Duration;
import java.util.HashMap;

import static javax.swing.UIManager.put;

public class Driver {
    public static WebDriver driver;

    public static WebDriver getDriver(){
        if (driver == null){
            switch (ConfigReader.getProperty("browser")){
                case "chrome":
                    ChromeOptions chromeOptions = new ChromeOptions();
                    //Javascript ile birlikte browser'da açılan notification alert'ini engelliyor.
                    chromeOptions.setExperimentalOption("prefs", new HashMap<String, Object>() {{
                        put("profile.default_content_setting_values.notifications", 2);
                    }});
                    driver = new ChromeDriver(chromeOptions);
                    break;
                case "edge":
                    driver = new EdgeDriver();
                    break;
                case "firefox":
                    driver = new FirefoxDriver();
                    break;
                case "safari":
                    driver = new SafariDriver();
                    break;
            }

            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        }
        return driver;
    }

    public static void closeDriver(){
        if (driver != null){
            driver.close();
            driver = null; // bazen otomasyon driver kapandıktan sonra browser açabiliyor. Bunun önüne geçmek için null'a çektim.
        }
        System.out.println("BROWSER CLOSED");
    }

    public static void quitDriver(){
        if (driver != null){
            driver.quit();
            driver = null; // bazen otomasyon driver kapandıktan sonra browser açabiliyor. Bunun önüne geçmek için null'a çektim.
        }
    }

}
