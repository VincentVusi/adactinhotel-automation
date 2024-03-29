package stepDefinitions;

import data.DBManager;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pages.*;

import java.sql.SQLException;
import java.time.Duration;
import java.util.List;

public class BookingSteps {
    WebDriver driver;
    LoginPage loginPage;
    SearchHotelPage searchHotelPage;
    SelectHotelPage selectHotelPage;
    BookHotelPage bookHotelPage;
    ConfirmationPage confirmationPage;
    DBManager dbManager;
    List<String> record;

    @Given("user is on login page")
    public void user_is_on_login_page() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));
        driver.get("https://adactinhotelapp.com/");
        loginPage = new LoginPage(driver);
    }

    @When("user logs in")
    public void user_logs_in() throws SQLException {
        dbManager = new DBManager();
        record = dbManager.selectData("testdata", "1").get(0);

        loginPage.login(record.get(1), record.get(2));
    }

    @And("user searches for a hotel")
    public void user_searches_for_a_hotel() {
        searchHotelPage = new SearchHotelPage(driver);
        searchHotelPage.searchHotel(
                record.get(3),  // location
                record.get(4),  // hotels
                record.get(5),  // roomType
                record.get(6),  // numberOfRooms
                record.get(7),  // checkInDate
                record.get(8),  // checkOutDate
                record.get(9),  // adultsPerRoom
                record.get(10)  // childrenPerRoom
        );
         }

    @And("user selects a hotel")
    public void user_selects_a_hotel() {
        selectHotelPage = new SelectHotelPage(driver);
        selectHotelPage.selectHotel();
    }

    @And("user enters booking details")
    public void user_enters_booking_details() {
        bookHotelPage = new BookHotelPage(driver);
        bookHotelPage.bookHotel(
                record.get(11),  // firstName
                record.get(12),  // lastName
                record.get(13),  // address
                record.get(14),  // creditCardNumber
                record.get(15),  // creditCardType
                record.get(16),  // expiryMonth
                record.get(17),  // expiryYear
                record.get(18)   // cvvNumber
        );
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
        confirmationPage.logout();
        driver.quit();
    }
}
