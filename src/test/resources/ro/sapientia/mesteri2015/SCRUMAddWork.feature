Feature: Check if the scrum add work hours works
	As Sapientia scrum tool user I want to be able to create a work hour for a sprint

   Scenario: Add
   Given I open the scrum tool sprints list to add work
   When I click on the last sprint and then I click on the Add work button and I fill in the data for the Work hour and hit save
   Then I should be redirected to the works list and see the newly created work