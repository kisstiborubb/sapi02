Feature: Check if the scrum story list edit
	As Sapientia scrum tool user I want to be able to edit story list

   Scenario: StoryListEdit
   Given After adding a story and a sprint, I open the scrum tool sprint's story list edit page
   When I check "story 1" checkbox and I push the save button
   Then I should get result "story 1" added to sprint's stories list