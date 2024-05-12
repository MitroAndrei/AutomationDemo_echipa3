package org.example.steps.serenity;

import net.thucydides.core.annotations.Step;
import net.thucydides.core.annotations.Steps;
import org.example.pages.CartPage;
import org.example.pages.MainPage;
import org.example.pages.ProductPage;
import org.example.pages.modals.ConfirmationModal;
import org.example.pages.modals.PlaceOrderModal;

import static org.hamcrest.core.StringContains.containsString;
import static org.junit.Assert.*;

public class BuyUserSteps {

    private MainPage mainPage;
    private ProductPage productPage;
    private CartPage cartPage;
    private PlaceOrderModal placeOrderModal;
    private ConfirmationModal confirmationModal;

    @Step
    public void opens_item_page(String item) {
        mainPage.clickOnProduct(item);
    }

    @Step
    public void should_see_item_page(String item) {
        assertThat(productPage.getProductTitle(), containsString(item));
    }
    @Step
    public void adds_item_to_cart() {
        productPage.clickAddToCartButton();
    }
    @Step
    public void goes_to_cart() {
        mainPage.clickCartButton();
    }
    @Step
    public void should_see_item_in_cart(String item) {
        assertTrue(cartPage.getProducts().contains(item));
    }

    @Step
    public void should_see_total_price() {
        assertEquals(cartPage.getCartTotal(),cartPage.getCartValue());
    }

    @Step
    public void buys_item() {
        cartPage.clickPlaceOrderButton();
        placeOrderModal.enterName("anas");
        placeOrderModal.enterCountry("India");
        placeOrderModal.enterCity("Delhi");
        placeOrderModal.enterCard("1234567890123456");
        placeOrderModal.enterMonth("12");
        placeOrderModal.enterYear("2024");
        placeOrderModal.clickPurchaseButton();
    }

    @Step
    public void should_see_confirmation() {
        assertThat(confirmationModal.getConfirmationMessage(), containsString("Thank you for your purchase!"));
        confirmationModal.clickOkButton();
    }
}
