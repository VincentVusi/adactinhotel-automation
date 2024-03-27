package pages;
// SelectHotelPage.java
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectHotelPage {
    @FindBy(id = "radiobutton_0")
    WebElement selectHotelButton;

    @FindBy(id = "continue")
    WebElement continueButton;

    public SelectHotelPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void selectHotel() {
        selectHotelButton.click();
        continueButton.click();
    }
}
