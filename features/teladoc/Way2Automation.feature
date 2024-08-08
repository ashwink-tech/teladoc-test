Feature: Verify my awesome automation skills

  @teladoc
  Scenario: Verify user is added to the table
    Given The user clicks on "Add":"Button" on WebTable Page
    When The user adds the user to the table
      | Firstname | Lastname    | Username | Password    | Email             | Phone      |
      | Ashwin    | Karangutkar | Ashwin   | password123 | ashwink@gmail.com | 9820882526 |
    Then Verify "First Name":"Text" "Ashwin" is present on WebTable Page

  @teladoc
  Scenario: Verify user novak is deleted from the table
    Given The user clicks on "Delete Specific User":"Button" on WebTable Page
    When The user clicks on "Ok":"Button" on WebTable Page
    Then Verify "User Name Novak":"Text" is not present on WebTable Page
