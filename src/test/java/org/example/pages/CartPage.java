package org.example.pages;

import jnr.ffi.annotations.In;
import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.PageObject;
import net.serenitybdd.core.pages.WebElementFacade;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

public class CartPage extends PageObject {

    @FindBy(xpath="//*[@id=\"page-wrapper\"]/div/div[2]/button")
    private WebElementFacade placeOrderButton;

    @FindBy(xpath="//*[@id=\"totalp\"]")
    private WebElementFacade cartTotalValue;


    public void clickPlaceOrderButton() {
        placeOrderButton.click();
    }

    public List<String> getProducts() {
        return findAll(By.xpath("//*[@id=\"tbodyid\"]/tr/td[2]"))
                .stream()
                .map(WebElementFacade::getText)
                .collect(Collectors.toList());
    }

    public int getCartValue() {
        return findAll(By.xpath("//*[@id=\"tbodyid\"]/tr/td[3]"))
                .stream()
                .map(WebElementFacade::getText)
                .map(Integer::parseInt)
                .reduce(0, Integer::sum);
    }

    public int getCartTotal() {
        return Integer.parseInt(cartTotalValue.getText());
    }
}
