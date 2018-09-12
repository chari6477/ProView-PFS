@FullFil 
Feature: Fulfill Subscription Subscription_Detail

Scenario: CorePFS_Fulfill_Subscription_Subscription_ Detail

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
	And I click "Next" button
	Then I verify that i am in the "ENTITLEMENT_DETAILS" Page
	When I close the App
	 
	