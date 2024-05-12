package org.example.pages.modals;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class PlaceOrderModal extends PageObject {
    @FindBy(xpath="//*[@id=\"name\"]")
    private WebElementFacade nameField;

    @FindBy(xpath="//*[@id=\"country\"]")
    private WebElementFacade countryField;

    @FindBy(xpath="//*[@id=\"city\"]")
    private WebElementFacade cityField;

    @FindBy(xpath="//*[@id=\"card\"]")
    private WebElementFacade cardField;

    @FindBy(xpath="//*[@id=\"month\"]")
    private WebElementFacade monthField;

    @FindBy(xpath="//*[@id=\"year\"]")
    private WebElementFacade yearField;

    @FindBy(xpath = "//*[@id=\"orderModal\"]/div/div/div[3]/button[2]")
    private WebElementFacade purchaseButton;

    public void enterName(String name) {
        nameField.type(name);
    }

    public void enterCountry(String country) {
        countryField.type(country);
    }

    public void enterCity(String city) {
        cityField.type(city);
    }

    public void enterCard(String card) {
        cardField.type(card);
    }

    public void enterMonth(String month) {
        monthField.type(month);
    }

    public void enterYear(String year) {
        yearField.type(year);
    }

    public void clickPurchaseButton() {
        purchaseButton.click();
    }
}
