Feature: Publishing a picture on Facebook

  Scenario: Successfully publishing a picture on Facebook
    Given the user opens Chrome browser
    And the user is on the Google homepage
    When the user searches for "Facebook" and navigates to the login page
    And enters their email and password
    Then they are taken to the Facebook homepage
    And they navigate to the Create post section
    And they add a description to the picture"Idriss,Pierre ,Raph ,ahmed ,yolan sont les noms de l'equipe projet tic MIAGE 2023 "
    Then they click the Post button
