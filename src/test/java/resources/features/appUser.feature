#Feature: A crud application for a user
#
#  Scenario: validate fetching user returns all users
#    Given Three users exist
#    Then the fetchAppUsersList request returns 3 results
#
#  Scenario Outline: Testing that each request type returns a 200 ok
#    Given a user exist
#    Then the <request> returns a 200
#
#    Examples:
#      | request           |
#      | createUser        |
#      | fetchAppUsersList |
#      | updateAppUser     |
#      | deleteAppUserById |
#
#  Scenario: validate new user request creates a new user
#    Given a user is created the values are correct
#
#  Scenario: validate updating a user updates the first name
#    Given a user exist
#    Then the updateAppUser will update the firstName
#
#  Scenario: validate deleting a user by id deletes the user
#    Given a user exist
#    Then the deleteAppUserById will remove the user