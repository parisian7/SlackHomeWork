Feature: Slack Post Verification
  Scenario Outline: Slack Massage Post  Verification
    When User Sends a massage to slack channel "<message>"
    Then User Validates the message is expectedly created
    Examples:
      | message |
      | From Dream to realLife |
#      | 1234 trial |
#      | 12345 trial |

