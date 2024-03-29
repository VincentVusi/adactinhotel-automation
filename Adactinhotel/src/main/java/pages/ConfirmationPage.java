package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ConfirmationPage {
    @FindBy(id = "order_no")
    WebElement orderNumber;

    @FindBy(id = "logout")
    WebElement logoutButton;

    public ConfirmationPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public String getOrderNumber() {
        return orderNumber.getAttribute("value");
    }

    public void logout(){
        logoutButton.click();
    }
}
