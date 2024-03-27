package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BookHotelPage {
    @FindBy(name = "first_name")
    WebElement firstName;

    @FindBy(name = "last_name")
    WebElement lastName;

    @FindBy(name = "address")
    WebElement address;

    @FindBy(name = "cc_num")
    WebElement creditCardNumber;

    @FindBy(name = "cc_type")
    WebElement creditCardType;

    @FindBy(name = "cc_exp_month")
    WebElement expiryMonth;

    @FindBy(name = "cc_exp_year")
    WebElement expiryYear;

    @FindBy(name = "cc_cvv")
    WebElement cvvNumber;

    @FindBy(name = "book_now")
    WebElement bookNowButton;

    public BookHotelPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void bookHotel(String firstName, String lastName, String address, String creditCardNumber, String creditCardType, String expiryMonth, String expiryYear, String cvvNumber) {
        this.firstName.sendKeys(firstName);
        this.lastName.sendKeys(lastName);
        this.address.sendKeys(address);
        this.creditCardNumber.sendKeys(creditCardNumber);
        this.creditCardType.sendKeys(creditCardType);
        this.expiryMonth.sendKeys(expiryMonth);
        this.expiryYear.sendKeys(expiryYear);
        this.cvvNumber.sendKeys(cvvNumber);
        bookNowButton.click();
    }
}
