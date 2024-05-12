package org.example.pages.modals;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;

public class ConfirmationModal extends PageObject {

    @FindBy(xpath="/html/body/div[10]/div[7]/div/button")
    private WebElementFacade okButton;

    @FindBy(xpath="/html/body/div[10]/h2")
    private WebElementFacade confirmationMessage;

    public void clickOkButton() {
        okButton.click();
    }
    public String getConfirmationMessage() {
        return confirmationMessage.getText();
    }
}
