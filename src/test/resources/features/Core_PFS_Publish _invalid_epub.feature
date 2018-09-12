@PFS1 
Feature: Publish invalid epub 

Scenario: Core_PFS_Publish _invalid_epub 

	Given I launch PFS Application 
	When I sign in into Application 
	Then I verify that i am in the "Fulfill" Page 
	When I click "Publish" Activity 
	Then I verify that i am in the "Publish" page 
	When I Click on "ProductLine" text box and enter the product line "textbook" 
	And I Click on "ProductCode" text box and enter the product code "text" 
	And I Click on "Version" and enter the version of the book "1.1" 
	And I Click on next button to navigate to next page 
	Then I verify that i am in the "UploadFile" Page 
	When I click "Browse" Button 
	And I upload file "_pitafix4" 
	Then User must be able to see system error message "Unexpected response from the server" 
	When I click "TryAgain" Button
	Then I verify that i am in the "UploadFile" Page
	When I close the browser using ALT + F4