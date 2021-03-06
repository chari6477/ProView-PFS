@FullFil 
Feature: Single Sale , Single Use Token and Custom Taken name & Change_Details

Scenario: Core_PFS_Fulfill_Single_Sale_Single_Use_Token_CustomTaken_Change_Details

	Given I launch PFS Application 
	When I sign in into Application 
	Then I verify that i am in the "Fulfill" Page 
	When Click on "Single_sale" radio button 
	Then Verify "NEXT" button will be Enabled 
	When Click on "NEXT" button 
	Then Verify user is able to navigate to "Select_Titles" page 
	When I click the PLUS symbol at the bottom of title "TESTS - Practitioner&apos" 
	Then Verify the green plus icon turns to "Blue_Check_Mark" 
	And Verify the selected title added to the cart 
	When I click Cart icon 
	And I click "Next" Button in Cart page 
	Then I verify that i am in the "ENTITLEMENT_DETAILS" Page
	When I select Token Type "Single Use Token" radio button 
	And Click on "NEXT" button 
	And I select Token Name "Custom Token Name" radio button
	And User can can enter the token name "pfs123456" in custom token name field
	And I select Token Expiration Date as future date 
	And Click on "set_a_content_expiration_date" button
	And I select Content Expiration Date as future date 
	And Click on "Update" button 
	And I click "Next" button
	Then Verify ENTITLEMENT DETAILS are displayed at right side of the modal 
	When Click on "Change_Details" button
	And User can can enter the token name "pfs6543212" in custom token name field
	And I click "Next" button
	Then Verify ENTITLEMENT DETAILS are displayed at right side of the modal
	When I close the browser