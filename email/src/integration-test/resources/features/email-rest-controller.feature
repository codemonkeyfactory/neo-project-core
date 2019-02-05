Feature: Email Rest Controller functions
  Scenario: Send email
    When I call POST on /email
    And to param is test@example.com
    And subject param is test subject
    And body param is test body
    Then I will receive the HTTP status code of 200