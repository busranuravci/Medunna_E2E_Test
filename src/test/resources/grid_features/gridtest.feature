@grid_features
Feature: Grid Feature

  @grid_chrome
  Scenario: TC01_Running on Chrome
    Given user goes to app with chrome
    When verify the title is "Blue Rental Cars | Cheap, Hygienic, VIP Car Hire"
    Then close the driver


  @grid_firefox
  Scenario: TC03_Running on Firefox
    Given user goes to app with firefox
    When verify the title is "Blue Rental Cars | Cheap, Hygienic, VIP Car Hire"
    Then close the driver


  @grid_edge
  Scenario: TC03_Running on Edge
    Given user goes to app with edge
    When verify the title is "Blue Rental Cars | Cheap, Hygienic, VIP Car Hire"
    Then close the driver

