Sample story
					 
Scenario: The scope of this test is to open google.
Given I open a browser
When I enter http://www.Google.com and hit the enter key
Then Gooogle is displayed

Scenario: The scope of this test is to search on google
Given http://www.Google.com is open
When I enter honda it will show search result
Then Honda will be selected