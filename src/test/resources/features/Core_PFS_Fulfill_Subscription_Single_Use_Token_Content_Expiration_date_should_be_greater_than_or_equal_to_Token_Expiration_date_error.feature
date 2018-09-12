@FullFil 
Feature: Fulfill Subscription and Single_Use_Token

Scenario: Core_PFS_Fulfill_Subscription_Single_Use_Token_Content_Expiration_date_should_be_greater_than_or_equal_to_Token_Expiration_date_error

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
	When I select SUBSCRIPTION END DATE 
	And I click "Next" button
	Then I verify that i am in the "ENTITLEMENT_DETAILS" Page
	Then Verify Subscription period has to show at the top
	When I select Token Type "Single Use Token" radio button 
	And Click on "NEXT" button
	Then Verify Subscription period has to show at the top
	And I select Token Expiration Date as future date 
	And Click on "set_a_content_expiration_date" button
	And I select Content Expiration Date as prior date
	Then User must be able to see an Validation error pop up "Content Expiration date should be greater than or equal to Token Expiration date" 
	When I close the App