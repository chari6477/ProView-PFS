@FullFil 
Feature: Subscription Select_Titles warning popup

Scenario Outline: Core_PFS_Fulfill_Subscription_Select_Titles_warning_popup

	Given I launch PFS Application 
	When I sign in into Application 
	Then I verify that i am in the "Fulfill" Page 
	When Click on "Subscription" radio button 
	Then Verify "NEXT" button will be Enabled 
	When Click on "NEXT" button 
	Then Verify user is able to navigate to "Select_Titles" page 
	When I click the PLUS symbol at the bottom of title "Anchor map test" 
	And Verify the selected title added to the cart
	And Verify a drawer will slide up from the bottom once the user selects the title in the Subscription type sale
	When I click "<Name>" Activity
	Then Verify warning popup must have two buttons "Exit_Fulfillment" and "Continue_Fulfillment" 
	When Click on "Exit_Fulfillment" button
	Then I verify that i am in the "<Name>" page
	When I close the browser using ALT + F4
	
	Examples:
	
	| Name |
	| Publish |
	| Support |
	