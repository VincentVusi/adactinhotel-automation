Feature: Hotel Booking

  Scenario Outline: Successful Booking of a Hotel
    Given user is on login page
    When user enters valid username "<username>" and password "<password>"
    Then user is on search hotel page
    When user enters hotel search details "<location>", "<hotels>", "<roomType>", "<numberOfRooms>", "<checkInDate>", "<checkOutDate>", "<adultsPerRoom>", "<childrenPerRoom>"
    Then user is on select hotel page
    When user selects a hotel
    Then user is on book hotel page
    When user enters booking details "<firstName>", "<lastName>", "<address>", "<creditCardNumber>", "<creditCardType>", "<expiryMonth>", "<expiryYear>", "<cvvNumber>"
    Then user is on confirmation page
    Then user checks the order number
    Then user logs out

    Examples:
      | username | password | location | hotels | roomType | numberOfRooms | checkInDate | checkOutDate | adultsPerRoom | childrenPerRoom | firstName | lastName | address | creditCardNumber | creditCardType | expiryMonth | expiryYear | cvvNumber |
      | VincentTester | 123456 | Sydney   | Hotel Creek | Standard | 1 | 27/03/2024 | 28/03/2024 | 1 | 0 | John | Doe | 123 Main St | 4111111111111111 | VISA | September | 2025 | 123 |
