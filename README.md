# Sample-API-automation-assignment

This is a sample assignment aims to accommodate possible test scenarios and validations for the below project service:
You can find the APIs here which have been automated as a part of this project: https://ratesapi.io/documentation/

# Prerequisites
Requires JDK version 8 or later to be installed in your system. Gradle uses the JDK libraries which is installed and sets to the JAVA_HOME environmental variable.
Gradle should be installed in your system. If not, run brew install gradle to install it using Homebrew.

# Execution

## Please run below command to execute the Unit tests
./gradlew -Dcucumber.options="--tags @smoke" clean test
or

./gradlew -Dcucumber.options="--tags @regression" clean test

## Please run below command to execute cucumber features
gradle cucumberTests 
or

./gradlew cucumberTests

## Cucumber Reports generation under project path on below location post execution
/build/reports/tests/cucumberTests/index.html
