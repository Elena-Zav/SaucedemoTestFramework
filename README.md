# SaucedemoTestFramework

Maven Project Setup: With Maven at its core, the framework ensures consistent dependency management.
JRE Version: The project is compatible with JDK 11 and higher versions.
yml File: Defines environment configurations.
properties File: specifies logger configurations.

Prerequisites:
JDK 11 or higher.
Maven installed.
Eclipse IDE (or another suitable IDE).
Cucumber plugins for the IDE.

Testing Framework Overview:

Language & Libraries: The framework utilizes Java with a foundation in Selenium WebDriver to ensure comprehensive and efficient browser interactions.

Behavior-Driven Development (BDD): Implementing Cucumber, the framework aligns with BDD principles, translating tests into easily comprehensible language. This approach streamlines collaboration between developers, QA, and business stakeholders.

Framework Configuration:

BaseSetup: A foundational class initializing essential configurations and resources.
POMFactory: Embraces the Page Object Model (POM) design pattern, representing web pages as cohesive classes, thereby enhancing maintainability.
Page Object Model (POM): Design pattern to represent web UI elements as objects within the code. This promotes reusability and maintainability.
Step Definitions: Located under com.saucelabs.saucedemo.steps, these detail the Gherkin step actions. They rely on CommonUtility, which further inherits from BaseSetup—an exemplification of multi-level inheritance.
Feature Files: These are plain text files where you write your scenarios using Gherkin syntax. Each scenario maps to a sequence of actions in your application.
BaseUITest: A hook that orchestrates WebDriver configurations, test logging, and captures failure screenshots.
TestRunner: Vital for test orchestration, it enables tag-based test execution, facilitating granular control over the testing scope.
Project Structure & Configuration:

Version Control & Collaboration: The GitHub repository hosts all codebase and resources, ensuring fluid collaboration among team members.

Test Execution: To initiate tests, target the TestRunner class. The @CucumberOptions annotation grants you the liberty to earmark specific tests for execution using tags, such as @Regression or @AddRemoveProducts.

Project Access: For seamless acquisition, the project is readily available on its GitHub repository. 

This framework embodies best practices in automation testing, offering scalability, and ensuring consistent and robust test execution—a testament to quality assurance excellence.

Instructions to Download and Run the Framework from GitHub:
Setting Up the Environment:
Prerequisites:

JDK 11 or a higher version installed.
Maven installed.
Eclipse IDE or another compatible IDE installed.
Cucumber Plugins installed on the IDE.
Downloading the Project from GitHub:

Navigate to the GitHub project URL https://github.com/Elena-Zav/SaucedemoTestFramework.git
Click the green Code button.
Select Download ZIP and save the ZIP file to a preferred location.
Once the download completes, extract the ZIP file.
Import the Project into Eclipse:

Open the Eclipse IDE.
Go to File > Import.
Select Maven > Existing Maven Projects.
Click Next.
For the Root Directory, click Browse and select the extracted project folder.
Make sure your project is checked in the Projects section.
Click Finish.
Running the Framework:
Maven Clean:
Right-click on the project in the Project Explorer.
Hover over Run As.
Select Maven clean.
Wait for the build to complete and ensure it finishes successfully.

Maven Install:
Again, right-click on the project.
Hover over Run As.
This time, select Maven install.
This step will download any necessary dependencies, compile the code, run tests, and package the code into a deployable unit.
Ensure the build is successful.
Viewing Test Results:

Upon a successful Maven install, Maven will execute the tests as part of the build process.
Test results can be viewed in the target folder of the project under surefire-reports. You can open the .html or .xml report files to see detailed test results.

Configuration Files:
The project includes a .yml file to define environment configurations.
A .properties file specifies the logger configuration. 
The log file is located in output -> logs folder

