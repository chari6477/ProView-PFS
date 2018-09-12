@FullFil
Feature: Select Title 

Scenario: Select Title and Entitlement details 

	Given I launch PFS Application 
	When I sign in into Application 
	Then I verify that i am in the "Fulfill" Page 
	When I click "Publisher" dropdown and select "trta" option 
	And I click the PLUS symbol at the bottom of title "Internal Revenue Code Winter 2013" 
	Then I verify that the title is available for sale or not 
	When I clcik Cart icon 
	And I click "Next" Button in Cart page 
	Then I verify that i am in the "ENTITLEMENT_DETAILS" Page 
	When I select Token Type "Single Use Token" radio button 
	And I select Token Name "Default Token Name" radio button 
	And I select Token Expiration Date 
		|  Month  |  Date  |  Year  | 
		|  05     |  02    |  2018  |
	When I click Next Button 
	And I click Next Button
	Then I verify "SUCCESS!" message is displayed 