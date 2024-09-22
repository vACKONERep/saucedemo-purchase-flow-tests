package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;

@DefaultUrl("https://www.saucedemo.com/")  // URL for the login page
public class LoginPageInterface extends PageObject {


    public static final Target INP_USERNAME = Target.the("Input Username").located(By.xpath("//input[contains(@id,'user-name')]"));
    public static final Target INP_PASSWORD = Target.the("Input Password").located(By.xpath("//input[contains(@id,'password')]"));
    public static final Target BTN_LOGIN = Target.the("Button Login").located(By.xpath("//input[contains(@id,'login-button')]"));

}
