@Parallel
Feature: Search Engine Titles

  Scenario: Open Google and Print Title
    Given I am on "Google" homepage
    When I get the page title
    Then the title should be "Google"

  Scenario: Open Bing and Print Title
    Given I am on "Bing" homepage
    When I get the page title
    Then the title should be "Bing"

  Scenario: Open Bing and Print Title
    Given I am on "Bing" homepage
    When I get the page title
    Then the title should be "Bing"