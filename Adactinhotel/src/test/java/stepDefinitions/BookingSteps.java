package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.time.Duration;

public class BookingSteps {
    WebDriver driver;
    LoginPage loginPage;
    SearchHotelPage searchHotelPage;
    SelectHotelPage selectHotelPage;
    BookHotelPage bookHotelPage;
    ConfirmationPage confirmationPage;

    @Given("user is on login page")
    public void user_is_on_login_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://adactinhotelapp.com/");
        loginPage = new LoginPage(driver);
    }

    @When("user logs in {string},{string}")
    public void user_logs_in(String username, String password) {
        loginPage.login(username, password);
    }

    @And("user searches for a hotel {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void user_searches_for_a_hotel(String location, String hotels, String roomType, String numberOfRooms, String checkInDate, String checkOutDate, String adultsPerRoom, String childrenPerRoom) {
        searchHotelPage = new SearchHotelPage(driver);
        searchHotelPage.searchHotel(location, hotels, roomType, numberOfRooms, checkInDate, checkOutDate, adultsPerRoom, childrenPerRoom);
    }

    @And("user selects a hotel")
    public void user_selects_a_hotel() {
        selectHotelPage = new SelectHotelPage(driver);
        selectHotelPage.selectHotel();
    }

    @And("user enters booking details {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void user_enters_booking_details(String firstName, String lastName, String address, String creditCardNumber, String creditCardType, String expiryMonth, String expiryYear, String cvvNumber) {
        bookHotelPage = new BookHotelPage(driver);
        bookHotelPage.bookHotel(firstName, lastName, address, creditCardNumber, creditCardType, expiryMonth, expiryYear, cvvNumber);
    }

    @And("user checks the order number")
    public void user_checks_the_order_number() {
        confirmationPage = new ConfirmationPage(driver);
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String orderNumber = confirmationPage.getOrderNumber();
        Assert.assertNotNull(orderNumber);

    }
    @Then("user logs out")
    public void user_logs_out(){
        driver.quit();
    }
}
