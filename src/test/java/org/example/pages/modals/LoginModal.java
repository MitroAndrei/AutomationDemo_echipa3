package org.example.pages.modals;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.Step;
import net.thucydides.core.pages.PageObject;

public class LoginModal extends PageObject{
    @FindBy(xpath ="//*[@id=\"logInModal\"]/div/div/div[3]/button[2]")
    private WebElementFacade modalLoginButton;

    @FindBy(xpath="//*[@id=\"loginusername\"]")
    private WebElementFacade usernameField;

    @FindBy(xpath="//*[@id=\"loginpassword\"]")
    private WebElementFacade passwordField;

    public void clickModalLoginButton() {
        modalLoginButton.click();
    }

    public void enterUsername(String username) {
        usernameField.type(username);
    }

    public void enterPassword(String password) {
        passwordField.type(password);
    }

    @Step
    public void enters_credentials(String username, String password) {
        enterUsername(username);
        enterPassword(password);
    }
    @Step
    public void logs_in() {
        clickModalLoginButton();
    }

}
