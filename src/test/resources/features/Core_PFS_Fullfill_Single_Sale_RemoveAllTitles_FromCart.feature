@FullFil 
Feature: Fulfill Single Sale 

Scenario: Core_PFS_Fullfill_Single_Sale_RemoveAllTitles_FromCart 

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
	When User can remove all the titles at once by clicking on "Remove_All"
	When I close the browser
