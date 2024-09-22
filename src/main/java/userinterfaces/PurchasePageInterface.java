package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class PurchasePageInterface {

    public static final Target INP_FIRST_NAME = Target.the("Input firstName").located(By.xpath("//input[contains(@id,'first-name')]"));
    public static final Target INP_LAST_NAME = Target.the("Input lastname").located(By.xpath("//input[contains(@id,'last-name')]"));
    public static final Target INP_ZIPCODE = Target.the("Input postalCode").located(By.xpath("//input[contains(@id,'postal-code')]"));
    public static final Target BTN_CONTINUE_CHECKOUT = Target.the("Button Continue").located(By.xpath("//input[contains(@id,'continue')]"));
    public static final Target BTN_FINISH_CHECKOUT = Target.the("Button Finish").located(By.xpath("//button[contains(@id,'finish')]"));
    public static final Target CONFIRMATION_MESSAGE = Target.the("Confirmation message").locatedBy("//h2[@class='complete-header'][contains(.,'Thank you for your order!')]");

}
