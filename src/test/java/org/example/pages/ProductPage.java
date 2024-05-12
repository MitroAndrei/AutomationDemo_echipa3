package org.example.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.pages.PageObject;

public class ProductPage extends PageObject {

    @FindBy(xpath="//*[@id=\"tbodyid\"]/h2")
    private WebElementFacade productTitle;

    @FindBy(xpath="//*[@id=\"tbodyid\"]/div[2]/div/a")
    private WebElementFacade addToCartButton;

    public void clickAddToCartButton() {
        addToCartButton.click();
    }

    public String getProductTitle() {
        return productTitle.getText();
    }
}
