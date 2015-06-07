Feature: Check if the scrum add sprint works
	As Sapientia scrum tool user I want to be able to search for work hours

   Scenario: Add
   Given I open the scrum tool work hours search
   When I fill in the start date and the end date and click search
   Then I should be able to see a work hour