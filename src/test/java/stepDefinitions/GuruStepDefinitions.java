package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import pages.GuruPage;
import utilities.ConfigReader;
import utilities.Driver;

import java.util.List;

public class GuruStepDefinitions {

    GuruPage guruPage = new GuruPage();

    @Given("kullanici {string} anasayfasinda")
    public void kullanici_anasayfasinda(String string) {
        Driver.getDriver().get(ConfigReader.getProperty("guruUrl"));
    }
    @And("{string} sutunundaki tum degerleri yazdirir")
    public void sutunundakiTumDegerleriYazdirir(String baslik) {
        int index=0;
        for (int i = 0; i<guruPage.basliklar.size() ; i++) {
            if (guruPage.basliklar.get(i).getText().equals(baslik)){
                System.out.println(guruPage.basliklar.get(i).getText());
                index=i+1;

                List<WebElement> sutunElementler= Driver.getDriver().findElements(By.xpath("//tbody/tr//td["+index+"]"));

                for (WebElement w:sutunElementler){
                    System.out.println(w.getText());
                }
            }
        }
    }

    @Given("sayfayi kapatir")
    public void sayfayiKapatir() {
        Driver.closeDriver();
    }
}
