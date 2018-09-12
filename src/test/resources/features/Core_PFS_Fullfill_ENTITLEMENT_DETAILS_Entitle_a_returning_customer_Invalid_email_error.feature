@FullFil 
Feature: Fulfill ENTITLEMENT_DETAILS Invalid email address

Scenario: Core_PFS_Fullfill_ENTITLEMENT_DETAILS_Entitle_a_returning_customer_Invalid_email_error

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
	When Enter the "Email" address of the customer "chari" who has already redeemed the tokens in the past 
	And Click on "Search_Email" button
	Then Error has to come up below the token expiration as "Enter a valid email address"
	When I close the App 