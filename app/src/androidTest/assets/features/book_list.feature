Feature: List Books

  Scenario: User can view a list of books
    Given User is on the book list page
    When the book list page has loaded
    Then the page should display multiple book data
