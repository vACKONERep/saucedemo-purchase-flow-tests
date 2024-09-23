package glue;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.matchers.WebElementStateMatchers;
import net.serenitybdd.screenplay.waits.WaitUntil;
import tasks.LoginTask;
import tasks.AddToCartTask;
import userinterfaces.LoginPageInterface;
import userinterfaces.ProductsPageInterface;
import userinterfaces.PurchasePageInterface;


import java.util.List;
import java.util.Map;

public class purchase_steps{

    @Given("I am on the login page")
    public void iAmOnTheLoginPage() {
        OnStage.theActorCalled("I").attemptsTo(Open.browserOn().the(LoginPageInterface.class));
    }

    @When("I log in with {string} and {string}")
    public void iLogInWithAnd(String username, String password) {
        OnStage.theActorInTheSpotlight().attemptsTo(LoginTask.withCredentials(username, password));
    }

    @Then("I should be on the products page")
    public void iShouldBeOnTheProductsPage() {
        // Here you would typically check if the current page is the products page.
        // This might involve checking for an element unique to the products page.
    }

    @When("I add two products to the cart")
    public void iAddTwoProductsToTheCart() {
        OnStage.theActorInTheSpotlight().attemptsTo(AddToCartTask.twoProducts());
    }

    @When("I view the cart")
    public void iViewTheCart() {
        OnStage.theActorInTheSpotlight().attemptsTo(Click.on(ProductsPageInterface.BTN_SHOPPING_CART));
    }

    @When("I proceed to checkout")
    public void iProceedToCheckout() {
        OnStage.theActorInTheSpotlight().attemptsTo(Click.on(ProductsPageInterface.BTN_CHECKOUT),WaitUntil.the(PurchasePageInterface.INP_FIRST_NAME, WebElementStateMatchers.isVisible()));
    }

    @When("I fill out the checkout form with {string}, {string}, and {string}")
    public void iFillOutTheCheckoutFormWith(String firstName, String lastName, String postalCode) {
        // Fill out the checkout form with the provided values
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(PurchasePageInterface.INP_FIRST_NAME, WebElementStateMatchers.isVisible()),
                Enter.theValue(firstName).into(PurchasePageInterface.INP_FIRST_NAME),
                WaitUntil.the(PurchasePageInterface.INP_LAST_NAME, WebElementStateMatchers.isVisible()),
                Enter.theValue(lastName).into(PurchasePageInterface.INP_LAST_NAME),
                WaitUntil.the(PurchasePageInterface.INP_ZIPCODE, WebElementStateMatchers.isVisible()),
                Enter.theValue(postalCode).into(PurchasePageInterface.INP_ZIPCODE)
        );

        // Continue with checkout
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(PurchasePageInterface.BTN_CONTINUE_CHECKOUT, WebElementStateMatchers.isVisible()),
                Click.on(PurchasePageInterface.BTN_CONTINUE_CHECKOUT)
        );

        // Finish checkout
        OnStage.theActorInTheSpotlight().attemptsTo(
                WaitUntil.the(PurchasePageInterface.BTN_FINISH_CHECKOUT, WebElementStateMatchers.isVisible()),
                Click.on(PurchasePageInterface.BTN_FINISH_CHECKOUT)
        );
    }
    @When("I finish the purchase")
    public void iFinishThePurchase() {

        OnStage.theActorInTheSpotlight().attemptsTo(
                // Wait for the confirmation message to appear
                WaitUntil.the(PurchasePageInterface.CONFIRMATION_MESSAGE, WebElementStateMatchers.isVisible())

                        );
    }
}
