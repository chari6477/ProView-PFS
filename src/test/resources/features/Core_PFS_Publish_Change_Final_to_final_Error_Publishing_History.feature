@PFS 
Feature: Change Final to final Error Publishing History 

Scenario: Core_PFS_Publish_Change_Final_to_final_Error_Publishing_History 

	When I launch PFS Application 
	And I sign in into Application 
	Then I verify that i am in the "Fulfill" Page 
	When I click "Publish" Activity 
	Then I verify that i am in the "Publish" page 
	When I click "Publishing History" Activity 
	Then I verify the book "Metamorphosis" is in Publishing History with the published status "In Review State" 
	When I Click on the title "Metamorphosis" in the "published history" page 
	Then I verify that the details of the "titleID" and artwork of the title with review tag at the right bottom 
	When I Click on "ReviewInProview" button and user should be navigated to "Proview" tab. 
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