@PFS1 
Feature: Maximum Product line, Product code and Version then verify TitleId error message

Scenario: Core_PFS_Publish_ERROR _maximum_Product_line_Product_code_and_Version 
	
	Given I launch PFS Application 
	When I sign in into Application 
	Then I verify that i am in the "Fulfill" Page 
	When I click "Publish" Activity 
	Then I verify that i am in the "Publish" page  
	And I Click on "ProductLine" text box and enter the product line "ProductLineProductLineProductLinee" 
	And I Click on "ProductCode" text box and enter the product code "ProductCodeProductCodeProductCodee" 
	And I Click on "Version" and enter the version of the book "1.1" 
	And I Click on next button to navigate to next page 
	Then I verify that i am in the "UploadFile" Page 
	When I click "Browse" Button 
	And I upload file "Metamorphosis-jackson" 
	Then I verify that spinning wheel for the upload process.
	Then I print error message
	Then User must be able to see an Validation error pop up "Title ID has exceeded the max character limit of 50"
	When I close the browser using ALT + F4