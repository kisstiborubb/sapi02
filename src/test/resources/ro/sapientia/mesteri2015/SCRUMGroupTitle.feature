Feature: Check if the scrum group add
	As Sapientia scrum tool user I want to be able to add groups

   Scenario: TitleGroupAdd
   Given I open the scrum tool group add page
   When I enter "group1" in  the description textbox and I push the add button
   Then I should get result "group1" in groups list