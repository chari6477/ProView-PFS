@FullFil 
Feature: Single Sale , Multi Use Token and Default token name

Scenario: Core_PFS_Fulfill_Single_Sale_Multi_Use_Token_Default_Token_Name_Success

	Given I launch PFS Application 
	When I sign in into Application 
	Then I verify that i am in the "Fulfill" Page 
	When Click on "Single_sale" radio button 
	Then Verify "NEXT" button will be Enabled 
	When Click on "NEXT" button 
	Then Verify user is able to navigate to "Select_Titles" page 
	When I click the PLUS symbol at the bottom of title "Anchor map test" 
	Then Verify the green plus icon turns to "Blue_Check_Mark" 
	And Verify the selected title added to the cart 
	When I click Cart icon 
	And I click "Next" Button in Cart page 
	Then I verify that i am in the "ENTITLEMENT_DETAILS" Page
	When I select Token Type "Multi Use Token" radio button 
	And Click on "NEXT" button
	And User can edit the "Number_of_Uses" filed and give input "12"
	And I select Token Expiration Date as future date 
	And Click on "set_a_content_expiration_date" button
	And I select Content Expiration Date as future date 
	And Click on "Update" button 
	And I click "Next" button
	Then Verify ENTITLEMENT DETAILS are displayed at right side of the modal 
	When I click on Submit button
	Then Verisy success message is displayed "Congratulations on creating a Multi Use Token" 
	And Verify "Copy_Link" button will be Enabled
	When I close the App