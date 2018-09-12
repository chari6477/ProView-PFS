@FullFil 
Feature: Single Sale ,  Single Use Token and CustomTaken name 8-16 error scenarios

Scenario Outline: Core_PFS_Fulfill_Single_Sale_Single_Use_Token_CustomTaken_error

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
	And User can can enter the token name "<TokenName>" in custom token name field 
	And  I click "Next" button 
	Then Error has to come up below the token expiration as "Must be 8 to 16 characters long and include only letters and numbers, no spaces or special characters allowed" 
	When I close the App
	
	Examples:
    | TokenName  | 
    | pfs | 
    | pfspfspfspfspfspfs |
	