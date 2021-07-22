Feature: Automate the UI for COINMARKETCAP

  Background: Opens the application
    Given As a user, I open the website

    #Task1
    Scenario: Validate the number of rows showing when selecting a particular number from "Show Rows"
      When I select show rows value as 100
      Then 100 rows should be displayed

      #Task2
     Scenario: Apply Filter and validate if the data returned are as per the set filter
      When I click on Filter button
      And I click on Add Filter
      And I select the following filter
        | Market Cap     | Price         |
        | $1B - $10B     | $101 - $1,000 |
      And I click on Show results
      Then I see the data with Market Cap 1B to 10B
      And I see the data with Price range $101 to $1000



