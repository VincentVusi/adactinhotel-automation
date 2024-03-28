package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

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
        selectByText(this.location,location);
        selectByText(this.hotels,hotels);
        selectByText(this.roomType,roomType);
        selectByValue(this.numberOfRooms,numberOfRooms);
        this.checkInDate.sendKeys(checkInDate);
        this.checkOutDate.sendKeys(checkOutDate);
        selectByValue(this.adultsPerRoom,adultsPerRoom);
        selectByValue(this.childrenPerRoom,childrenPerRoom);
        searchButton.click();
    }
    private void selectByText(WebElement element , String value){
        new Select(element).selectByVisibleText(value);
    }

    private void selectByValue(WebElement element , String value){
        new Select(element).selectByValue(value);
    }
}

