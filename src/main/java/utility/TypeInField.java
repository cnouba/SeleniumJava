package main.java.utility;

import main.java.commun.ApplicationCommonScript;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class TypeInField extends ApplicationCommonScript {


    public   void SaisirCaractere (String xpath, String value){

        String val = value;
        WebElement element = driver.findElement(By.cssSelector(xpath));
        element.clear();

        for (int i = 0; i < val.length(); i++){
            char c = val.charAt(i);
            String s = new StringBuilder().append(c).toString();
            element.sendKeys(s);
        }
    }
}
