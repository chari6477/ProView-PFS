@FullFil 
Feature: Fulfill Main Page 

Scenario: Core_PFS_Fullfill_Main_Page 

	Given I launch PFS Application 
	When I sign in into Application 
	Then I verify that i am in the "Fulfill" Page 
	And  User should be able to see type of transaction on the Fulfill page "Single_Sale" 
	And  User should be able to see type of transaction on the Fulfill page "Subscription" 
	And A Radio button should be present next to "Single_Sale" 
	And A Radio button should be present next to "Subscription" 
	And A book icon with blue plus mark has to be present on the right side of the "Single_Sale" 
	And A book icon with blue plus mark has to be present on the right side of the "Subscription" 
	When Click on "Single_Sale" radio button 
	Then Verify "NEXT" button will be Enabled 
	When Click on the "Fulfill_Option" on the top of the PFS publish page 
	#Then User must be able to see two options "Single_Sale" and "Subscription" 
	When Click on "NEXT" button 
	Then Verify user is able to navigate to "Select_Titles" page
	When I close the browser
	
	
	
	
	
	