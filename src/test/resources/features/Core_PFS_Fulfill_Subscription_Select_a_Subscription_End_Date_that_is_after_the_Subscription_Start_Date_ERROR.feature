@FullFil 
Feature: Fulfill Subscription Start date and end date shouldn't be same

Scenario: Core_PFS_Fulfill_Subscription_Select_a_Subscription_End_Date_that_is_after_the_Subscription_Start_Date_ERROR

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
	When User will be navigated to Subscription detail page by clicking on the "NEXT" button on the slider
	Then I verify that i am in the "SUBSCRIPTION_DETAIL" Page
	When I select SUBSCRIPTION START DATE
	And Click on "SET_END_DATE" button
	When I select SUBSCRIPTION END DATE as Start date
	Then User must be able to see an Validation error pop up "Select a Subscription End Date that is after the Subscription Start Date" 
	When I close the App