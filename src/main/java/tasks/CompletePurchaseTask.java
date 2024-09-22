package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import userinterfaces.PurchasePageInterface;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CompletePurchaseTask implements Task {

    private final String firstName;
    private final String lastName;
    private final String postalCode;

    public CompletePurchaseTask(String firstName, String lastName, String postalCode) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.postalCode = postalCode;
    }

    public static CompletePurchaseTask withDetails(String firstName, String lastName, String postalCode) {
        return instrumented(CompletePurchaseTask.class, firstName, lastName, postalCode);
    }

    @Override
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                WaitUntil.the(PurchasePageInterface.INP_FIRST_NAME, WebElementStateMatchers.isVisible()),
                Enter.theValue(firstName).into(PurchasePageInterface.INP_FIRST_NAME),

                WaitUntil.the(PurchasePageInterface.INP_LAST_NAME, WebElementStateMatchers.isVisible()),
                Enter.theValue(lastName).into(PurchasePageInterface.INP_LAST_NAME),

                WaitUntil.the(PurchasePageInterface.INP_ZIPCODE, WebElementStateMatchers.isVisible()),
                Enter.theValue(postalCode).into(PurchasePageInterface.INP_ZIPCODE),

                WaitUntil.the(PurchasePageInterface.BTN_CONTINUE_CHECKOUT, WebElementStateMatchers.isVisible()),
                Click.on(PurchasePageInterface.BTN_CONTINUE_CHECKOUT),

                WaitUntil.the(PurchasePageInterface.BTN_FINISH_CHECKOUT, WebElementStateMatchers.isVisible()),
                Click.on(PurchasePageInterface.BTN_FINISH_CHECKOUT)
        );
    }


}
