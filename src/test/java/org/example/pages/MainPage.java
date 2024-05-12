package org.example.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;

@DefaultUrl("https://www.demoblaze.com/index.html")
public class MainPage extends PageObject {

    @FindBy(xpath="//*[@id=\"login2\"]")
    private WebElementFacade loginButton;

    @FindBy(xpath="//*[@id=\"logout2\"]")
    private WebElementFacade logoutButton;

    @FindBy(xpath="//*[@id=\"nameofuser\"]")
    private WebElementFacade nameOfUser;

    @FindBy(xpath="//*[@id=\"tbodyid\"]/div[1]/div/div/h4/a")
    private WebElementFacade firstProduct;

    @FindBy(xpath="//*[@id=\"cartur\"]")
    private WebElementFacade cartButton;

    public void clickLoginButton() {
        loginButton.click();
    }

    public String getNameOfUser() {
        return nameOfUser.getText();
    }

    public void clickFirstProduct() {
        firstProduct.click();
    }

    public void clickOnProduct(String productName) {
        WebElementFacade product = find("//a[contains(text(), '" + productName + "')]");
        product.click();
    }

    public void clickCartButton() {
        cartButton.click();
    }

    public void clickLogoutButton() {
        logoutButton.click();
    }

    public String getLoginButtonText() {
        return loginButton.getText();
    }
}
