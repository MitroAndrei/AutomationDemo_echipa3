package org.example.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.example.pages.MainPage;
import org.example.pages.modals.LoginModal;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class LoginUserSteps {

    private MainPage mainPage;
    private LoginModal loginModal;
    @Step
    public void is_home_page() {
        mainPage.open();
    }

    @Step
    public void opens_login_modal() {
        mainPage.clickLoginButton();
    }

    @Step
    public void logs_in(String username,String password) {
        opens_login_modal();
        loginModal.enters_credentials(username,password);
        loginModal.logs_in();
    }

    @Step
    public void logs_out() {
        mainPage.clickLogoutButton();
    }

    @Step
    public void should_see_name(String name) {
        assertThat(mainPage.getNameOfUser(), containsString(name));
    }

    @Step
    public void should_see_alert(String alertText, String expectedOutput) {
        assertThat(alertText, containsString(expectedOutput));
    }

    @Step
    public void should_see_login_button() {
        assertThat(mainPage.getLoginButtonText(), containsString("Log in"));
    }



}