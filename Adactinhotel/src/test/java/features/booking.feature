Feature: Hotel Booking

  Scenario: Successful Booking of a Hotel
    Given user is on login page
    When user logs in
    And user searches for a hotel
    And user selects a hotel
    And user enters booking details
    And user checks the order number
    Then user logs out
