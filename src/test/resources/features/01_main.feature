Feature: Navigating to Google
  As a user
  I want to navigate to google.com
  So that I can search anything on the web

  @P1
  Scenario: Navigate to google.com
    Given I open googlecom
    When I click on the searchbox
    And I type something
    Then search results should be displayed