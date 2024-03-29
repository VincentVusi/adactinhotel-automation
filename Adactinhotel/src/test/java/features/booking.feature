Feature: Hotel Booking

  Scenario Outline: Successful Booking of a Hotel
    Given user is on login page
    When user logs in "<username>","<password>"
    And user searches for a hotel "<location>", "<hotels>", "<roomType>", "<numberOfRooms>", "<checkInDate>", "<checkOutDate>", "<adultsPerRoom>", "<childrenPerRoom>"
    And user selects a hotel
    And user enters booking details "<firstName>", "<lastName>", "<address>", "<creditCardNumber>", "<creditCardType>", "<expiryMonth>", "<expiryYear>", "<cvvNumber>"
    And user checks the order number
    Then user logs out

    Examples:
      | username | password | location | hotels | roomType | numberOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom | firstName | lastName | address | creditCardNumber | creditCardType | expiryMonth | expiryYear | cvvNumber |
      | VincentTester | 123456 | Sydney   | Hotel Creek | Standard | 1 | 27/03/2024 | 28/03/2024 | 1 | 0 | John | Doe | 123 Main St | 4111111111111111 | VISA | September | 2025 | 123 |
