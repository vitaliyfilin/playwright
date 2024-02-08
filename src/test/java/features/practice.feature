@Locale:de-DE
@Devtools:true
Feature: Practice form feature

  Scenario: Successful form fill
    Given I navigate to the main page
    Given I navigate to practice form page
    When I fill practice form fields with the following data
      | First Name      | John                    |
      | Last Name       | Doe                     |
      | Email           | john@doe.com            |
      | Gender          | Male                    |
      | Mobile Number   | 00000000000             |
      | Date of Birth   | 11 august 2005          |
      | Subjects        | English, Economics      |
      | Current Address | Unknown, Unknown street |
    When I click submit button
    Then thanks message should be visible
