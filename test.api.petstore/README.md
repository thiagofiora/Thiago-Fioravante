# PetStore automation

## Test Plan
The test plan proposed was focused on at least on the "happy" path for each endpoint, so this way we could have a good converage and validate that the expected behavior on that scenarios the API is working as expected. 
A few test were added convering negative tests, like try to find a pet with an id that does not exist but still there are a lot of other test like invalide characters that was not added.

### Pet tests
Tests for the */pet* endpoint

1. Get a pet by an non existing ID
2. Get a pet by an existing ID
3. Get a pet list by a non existing Status
4. Get a pet list by an existing Status
5. Get a pet list by a non exisitng tag
6. Get a pet list by a exisiting tag
7. Add a new Pet
8. Update an existing Pet
9. Delete an existing Pet

### Store tests
Tests for the *store* endpoint 

1. Get inventory
2. Get a non exisitng Order by orderID
3. Get an existing Order by orderID
4. Add a new Order
5. Delete an existing Order

### User tests
Tests for the */user* endpoint

1. Create a new user
2. Create a list of new users
3. Get an existing user by username
4. Delete an existing user
5. Log in with valid credentials
6. Log in with invalid password
7. Log in with invalid username


## Solution

The automation is a Java project using Maven as builder, Junit as test runner and Rest Assred as API test framework. The option to go with Rest Assured was due it's simplicity to make calls and check the results. The library does a lot of the job with connectionsm serialization/deserialization and other features that speed the development while keeping the project really simple to read/maintain.

There is a BaseTest.java which is a super class for all test classes used to contain any common behaviour/configuration.

Then there is one class per endpoint to keep the test well organized and to contain any common behaviour/configuration specific for that endpoint.

## To test

To run this project, is necessary to install the PetStore API sample as explanied here: https://github.com/swagger-api/swagger-petstore
