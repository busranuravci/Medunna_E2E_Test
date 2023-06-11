
@e2e @database
  Feature: Room Database Test

    Scenario:  Select Room
      Given connect to database
      Then read room and validate
