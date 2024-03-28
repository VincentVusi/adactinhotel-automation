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

    @When("user enters valid username {string} and password {string}")
    public void user_enters_valid_username_and_password(String username, String password) {
        loginPage.login(username, password);
    }

    @Then("user is on search hotel page")
    public void user_should_be_redirected_to_homepage() {
        searchHotelPage = new SearchHotelPage(driver);
    }

    @When("user enters hotel search details {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void user_enters_hotel_search_details(String location, String hotels, String roomType, String numberOfRooms, String checkInDate, String checkOutDate, String adultsPerRoom, String childrenPerRoom) {
        searchHotelPage.searchHotel(location, hotels, roomType, numberOfRooms, checkInDate, checkOutDate, adultsPerRoom, childrenPerRoom);
    }

    @Then("user is on select hotel page")
    public void user_is_on_select_hotel_page() {
        selectHotelPage = new SelectHotelPage(driver);
    }

    @When("user selects a hotel")
    public void user_selects_a_hotel() {
        selectHotelPage.selectHotel();
    }

    @Then("user is on book hotel page")
    public void user_is_on_book_hotel_page() {
        bookHotelPage = new BookHotelPage(driver);
    }

    @When("user enters booking details {string}, {string}, {string}, {string}, {string}, {string}, {string}, {string}")
    public void user_enters_booking_details(String firstName, String lastName, String address, String creditCardNumber, String creditCardType, String expiryMonth, String expiryYear, String cvvNumber) {
        bookHotelPage.bookHotel(firstName, lastName, address, creditCardNumber, creditCardType, expiryMonth, expiryYear, cvvNumber);
    }

    @Then("user is on confirmation page")
    public void user_is_on_confirmation_page() {
        confirmationPage = new ConfirmationPage(driver);
    }

    @Then("user checks the order number")
    public void user_checks_the_order_number() {
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
        String orderNumber = confirmationPage.getOrderNumber();
        Assert.assertNotNull(orderNumber);

    }
    @Then("user logs out")
    public void user_logs_out(){
        driver.quit();
    }
}
