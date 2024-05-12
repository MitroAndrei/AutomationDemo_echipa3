package org.example.features.login;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;
import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import net.thucydides.junit.annotations.UseTestDataFrom;
import org.example.steps.serenity.LoginUserSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static junit.framework.Assert.assertTrue;
import static junit.framework.TestCase.assertFalse;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom(value="src/test/resources/LoginTestData.csv")
public class LogIn {
    @Managed(uniqueSession = true,driver = "chrome")
    public WebDriver webdriver;

    @Steps
    public LoginUserSteps user;

    private String username;
    private String password;
    private String expectedOutput;

    @Issue("#Login-1")
    @Test
    public void logIn() {
        user.is_home_page();
        user.logs_in(username,password);
        WebDriverWait wait = new WebDriverWait(webdriver, 1);
        try {
            wait.until(ExpectedConditions.alertIsPresent());
            String alert = webdriver.switchTo().alert().getText();
            user.should_see_alert(alert,expectedOutput);
        } catch (Exception e) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nameofuser\"]")));
            user.should_see_name(expectedOutput);
        }
    }

}
