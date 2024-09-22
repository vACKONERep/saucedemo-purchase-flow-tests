package tasks;

import userinterfaces.LoginPageInterface;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.Tasks;

public class LoginTask implements Task {

    private final String username;
    private final String password;

    // Constructor to pass username and password dynamically
    public LoginTask(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // Static method for easy instantiation
    public static LoginTask withCredentials(String username, String password) {
        return Tasks.instrumented(LoginTask.class, username, password);
    }

    // Method that contains the task logic
    @Override
    public <T extends Actor> void performAs(T actor) {
        // Use the actor to perform the task using the locators in LoginPageInterface
        actor.attemptsTo(
                Enter.theValue(username).into(LoginPageInterface.INP_USERNAME), // Enter username
                Enter.theValue(password).into(LoginPageInterface.INP_PASSWORD), // Enter password
                Click.on(LoginPageInterface.BTN_LOGIN)                          // Click login button
        );
    }
}
