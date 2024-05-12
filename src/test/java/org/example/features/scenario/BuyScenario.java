package org.example.features.scenario;

import net.serenitybdd.junit.runners.SerenityRunner;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.Steps;
import org.example.steps.serenity.BuyUserSteps;
import org.example.steps.serenity.LoginUserSteps;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

@RunWith(SerenityRunner.class)
public class BuyScenario {
    @Managed(uniqueSession = true,driver = "chrome")
    public WebDriver webdriver;
    @Steps
    private LoginUserSteps loginUserSteps;
    @Steps
    private BuyUserSteps buyUserSteps;

    private String username = "anas";
    private String password = "anas";
    private String item = "Samsung galaxy s6";

    @Test
    public void buyScenario() {
        WebDriverWait wait = new WebDriverWait(webdriver, 2);

        loginUserSteps.is_home_page();
        loginUserSteps.logs_in(username,password);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"nameofuser\"]")));
        loginUserSteps.should_see_name("Welcome "+username);

        buyUserSteps.opens_item_page(item);
        buyUserSteps.should_see_item_page(item);
        buyUserSteps.adds_item_to_cart();
        wait.until(ExpectedConditions.alertIsPresent());
        webdriver.switchTo().alert().accept();
        buyUserSteps.goes_to_cart();

        buyUserSteps.should_see_item_in_cart(item);
        buyUserSteps.should_see_total_price();
        buyUserSteps.buys_item();
        buyUserSteps.should_see_confirmation();

        loginUserSteps.logs_out();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"login2\"]")));
        loginUserSteps.should_see_login_button();

    }


}
