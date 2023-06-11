
@e2e
  Feature: Medunna Room Creation
    Background: Sign in Medunna

      Given go to "https://medunna.com"
      When click on user icon
      And click on sign in option
      And send username into username box
      And send password into password box
      And click on sign in submit button



        Scenario Outline: Create Room
          When click on ItemsAndTitles
          And click on Room option
          And click on Create a new room button
          And enter "<room_number>" room number input
          And select Suite option from Room Type Drop Down
          And  click on Status checkbox
          And enter "<price>" in Price input
          And enter "<description>" in Description input
          And click on Save button
          And close the app

          Examples:
            | room_number | price | description |
            | 72244940    | 123   | Created For E2E Test |
