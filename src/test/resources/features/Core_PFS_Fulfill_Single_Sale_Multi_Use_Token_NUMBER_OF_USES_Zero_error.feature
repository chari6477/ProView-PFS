@FullFil 
Feature: Single Sale , Multi Use Token and NUMBER OF USES 0-1201 error

Scenario Outline: Core_PFS_Fulfill_Single_Sale_Multi_Use_Token_NUMBER_OF_USES_error

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
	And User can edit the "Number_of_Uses" filed and give input "<Number>"
	And  I click "Next" button 
	Then User must be able to see an Validation error pop up "Must be a number between 1 and 1200" 
	When I close the App
	
	Examples:
    | Number  | 
    | 0 | 
    | 1201 |