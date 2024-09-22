package userinterfaces;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class ProductsPageInterface {
    public static final Target ADD_PRODUCT_1 = Target.the("Button Product 1").located(By.xpath("//button[contains(@id,'add-to-cart-sauce-labs-backpack')]"));
    public static final Target ADD_PRODUCT_2 = Target.the("Button Product 2").located(By.xpath("//button[contains(@id,'add-to-cart-sauce-labs-bike-light')]"));
    public static final Target BTN_SHOPPING_CART = Target.the("Button Shopping Cart").located(By.xpath("//a[@class='shopping_cart_link'][contains(.,'2')]"));
    public static final Target BTN_CHECKOUT = Target.the("Button Checkout").located(By.xpath("//button[contains(@id,'checkout')]"));


}
