Feature: The user can change their own password
  Rule: As a user
  I want to be able to change my own password within the guidelines of password policy
  So that the integrity of my account security requirements are met.

    Background:
      Given the user is logged in with username "currentUser" and password "currentPassword"

    Scenario: Successful password change
      When the user navigates to the password change page
      And the user enters the current password "currentPassword"
      And the user enters the new password "NewPassword123!"
      And the user confirms the new password "NewPassword123!"
      Then the password change should be successful
      And the user should see a confirmation message "Your password has been changed successfully."

    Scenario: Password change with non-matching confirmation password
      When the user navigates to the password change page
      And the user enters the current password "currentPassword"
      And the user enters the new password "NewPassword123!"
      And the user confirms the new password "NewPassword456!"
      Then the password change should fail
      And the user should see an error message "The new passwords do not match."

    Scenario: Password change with weak new password
      When the user navigates to the password change page
      And the user enters the current password "currentPassword"
      And the user enters the new password "weak"
      And the user confirms the new password "weak"
      Then the password change should fail
      And the user should see an error message "The new password does not meet the security requirements."

    Scenario: Password change with incorrect current password
      When the user navigates to the password change page
      And the user enters the current password "wrongPassword"
      And the user enters the new password "NewPassword123!"
      And the user confirms the new password "NewPassword123!"
      Then the password change should fail
      And the user should see an error message "The current password is incorrect."

    Scenario: Password change with a new password that is the same as the current password
      When the user navigates to the password change page
      And the user enters the current password "currentPassword"
      And the user enters the new password "currentPassword"
      And the user confirms the new password "currentPassword"
      Then the password change should fail
      And the user should see an error message "The new password cannot be the same as the current password."

    Scenario: Password change with valid new password that meets all criteria
      When the user navigates to the password change page
      And the user enters the current password "currentPassword"
      And the user enters the new password "Secure@Pass123"
      And the user confirms the new password "Secure@Pass123"
      Then the password change should be successful
      And the user should see a confirmation message "Your password has been changed successfully."