package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SearchHotelPage {
    @FindBy(name = "location")
    WebElement location;

    @FindBy(name = "hotels")
    WebElement hotels;

    @FindBy(name = "room_type")
    WebElement roomType;

    @FindBy(name = "room_nos")
    WebElement numberOfRooms;

    @FindBy(name = "datepick_in")
    WebElement checkInDate;

    @FindBy(name = "datepick_out")
    WebElement checkOutDate;

    @FindBy(name = "adult_room")
    WebElement adultsPerRoom;

    @FindBy(name = "child_room")
    WebElement childrenPerRoom;

    @FindBy(name = "Submit")
    WebElement searchButton;

    public SearchHotelPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
    }

    public void searchHotel(String location, String hotels, String roomType, String numberOfRooms, String checkInDate, String checkOutDate, String adultsPerRoom, String childrenPerRoom) {
        this.location.sendKeys(location);
        this.hotels.sendKeys(hotels);
        this.roomType.sendKeys(roomType);
        this.numberOfRooms.sendKeys(numberOfRooms);
        this.checkInDate.sendKeys(checkInDate);
        this.checkOutDate.sendKeys(checkOutDate);
        this.adultsPerRoom.sendKeys(adultsPerRoom);
        this.childrenPerRoom.sendKeys(childrenPerRoom);
        searchButton.click();
    }
}

