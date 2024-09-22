package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.waits.WaitUntil;
import userinterfaces.ProductsPageInterface;

import static net.serenitybdd.screenplay.Tasks.instrumented;
import static net.serenitybdd.screenplay.matchers.WebElementStateMatchers.isVisible;


public class AddToCartTask implements Task {

    public static AddToCartTask twoProducts() {
        return instrumented(AddToCartTask.class);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(ProductsPageInterface.ADD_PRODUCT_1, isVisible()).forNoMoreThan(8).seconds(),
                Click.on(ProductsPageInterface.ADD_PRODUCT_1),

                WaitUntil.the(ProductsPageInterface.ADD_PRODUCT_2, isVisible()).forNoMoreThan(10).seconds(),
                Click.on(ProductsPageInterface.ADD_PRODUCT_2),

                WaitUntil.the(ProductsPageInterface.BTN_SHOPPING_CART, isVisible()).forNoMoreThan(5).seconds(),
                Click.on(ProductsPageInterface.BTN_SHOPPING_CART),

                WaitUntil.the(ProductsPageInterface.BTN_CHECKOUT, isVisible()).forNoMoreThan(20).seconds(),
                Click.on(ProductsPageInterface.BTN_CHECKOUT)

                );
    }
}
