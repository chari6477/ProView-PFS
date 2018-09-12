@PFS1 
Feature: Select 2 titles through Browser option 

Scenario: Core_PFS_Publish _Select_2_titles_through_Browser_option 

	When I launch PFS Application 
	And I sign in into Application 
	Then I verify that i am in the "Fulfill" Page 
	When I click "Publish" Activity 
	Then I verify that i am in the "Publish" page 
	When I Click on "ProductLine" text box and enter the product line "textbook" 
	And I Click on "ProductCode" text box and enter the product code "text" 
	And I Click on "Version" and enter the version of the book "1.1" 
	And I Click on next button to navigate to next page 
	Then I verify that i am in the "UploadFile" Page 
	When I click "Browse" Button 
	And select two files "a" and "b" then click on open 
	Then I verify that spinning wheel for the upload process. 
	And I Verify that the user is navigated to publish "Success!" page 
	And I verify that the "Artwork" of the book on the publish page 
	And I verify that "RedReview" tag on the right bottom of the artwork. 
	When I close the browser using ALT + F4
 