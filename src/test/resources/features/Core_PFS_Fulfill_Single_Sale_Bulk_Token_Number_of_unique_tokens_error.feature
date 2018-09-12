@FullFil 
Feature: Single Sale , Bulk Token and Number of unique tokens Error Scenarios

Scenario Outline: Core_PFS_Fulfill_Single_Sale_Bulk_Token_Number_of_unique_tokens_0_101_error

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
	When I select Token Type "Bulk Tokens" radio button 
	And Click on "NEXT" button 
	And User can enter the NUMBER OF UNIQUE TOKENS "<NUMBER>" in the field 
	And  I click "Next" button 
	Then User must be able to see an Validation error pop up "Must be a number between 1 and 100" 
	When I close the App
	
	Examples:
    | NUMBER  | 
    | 0 | 
    | 101 | 