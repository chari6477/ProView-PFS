@PFS
Feature: should not Able to Create Annotaations 

Scenario: Core_PFS_Publish _valid_epub_ check_user_not_able_to_create_annotations

	Given I launch PFS Application 
	When I sign in into Application 
	Then I verify that i am in the "Fulfill" Page 
	When I click "Publish" Activity 
	Then I verify that i am in the "Publish" page 
	And I Click on "ProductLine" text box and enter the product line "textbook" 
	And I Click on "ProductCode" text box and enter the product code "text"
	And I Click on "Version" and enter the version of the book "1.1"
	And I Click on next button to navigate to next page 
	Then I verify that i am in the "UploadFile" Page 
	When I click "Browse" Button 
	And I upload file "Metamorphosis-jackson" 
	Then I verify that spinning wheel for the upload process. 
	Then I Verify that the user is navigated to publish "Success!" page 
	And I verify that the "Artwork" of the book on the publish page 
	And I verify that "RedReview" tag on the right bottom of the artwork. 
	When I Click on "REVIEWINPROVIEW" button and user should be navigated to "Proview" tab. 
	And I Select the "Web Browser" option and click on "Launch proview" button. 
	And I Select "login with onepass account" and click on "launch proview" button 
	And I add highlight in the color "orange" by selecting the text "Metamorphosis" 
	Then User must be able to see an Validation error pop up "Unable to create annotations since this title is in Review stage."
	When I close the browser using ALT + F4
	