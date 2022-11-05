Feature: Orange HRM page
Scenario: Login to OrangHRM
		Given I launch chromebrowser
		And I launch hrm webpage
		When enter username and password
		And press login button
		Then User must successfully login 
		And close browser