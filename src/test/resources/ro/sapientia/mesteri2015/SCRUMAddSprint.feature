Feature: Check if the scrum add sprint works
	As Sapientia scrum tool user I want to be able to create a sprint

   Scenario: Add
   Given I open the scrum tool sprints list
   When I click on the Add button and I fill in the data for the new sprint and click save
   Then I should be redirected to the sprints list and see the newly created sprint