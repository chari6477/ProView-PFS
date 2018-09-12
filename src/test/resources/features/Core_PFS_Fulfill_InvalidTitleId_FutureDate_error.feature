@FullFil 
Feature: Fulfill error scenarios 

Scenario: Core_PFS_Fullfill_InvalidTitleID_FutureDate_Error 

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
	And I select Token Expiration Date as future date 
	And I click "Next" button
	And I click on Submit button
	Then Error has to come up below the token expiration as "Resource(s) does not exist: trp/tests/pita/v1" 
	When I close the App