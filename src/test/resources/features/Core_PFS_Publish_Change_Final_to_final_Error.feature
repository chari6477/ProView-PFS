@PFS 
Feature: Change Final to final Error 

Scenario: Core_PFS_Publish_Change_Final_to_final_Error 
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
	And I upload file "Metamorphosis-jackson" 
	Then I verify that spinning wheel for the upload process. 
	And I Verify that the user is navigated to publish "Success!" page 
	And I verify that the "Artwork" of the book on the publish page 
	And I verify that "RedReview" tag on the right bottom of the artwork. 
	When I Click on "REVIEWINPROVIEW" button and user should be navigated to "Proview" tab. 
	And I Select the "Web Browser" option and click on "Launch proview" button. 
	And I Select "login with onepass account" and click on "launch proview" button 
	And I Navigate back to the PFS tab in the browser 
	Then I verify That navigated to Review the title page 
	When I Click on the "change state to final" button 
	Then I verify that user must see Green check mark 
	When I Navigate back in the browser 
	And I Click on the "change state to final" button 
	Then User must be able to see an Validation error pop up "Title status cannot be changed from Final to Final"
	When I close the browser using ALT + F4