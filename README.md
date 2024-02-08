# Java Cucumber Playwright Framework Example
This repository contains an example Java Cucumber Playwright framework that demonstrates the usage of Playwright for browser automation in Java. The framework employs various design patterns including the Page Object Model (POM) and the Control Factory pattern to enhance code readability, maintainability, and reusability.<br>
This approach - each control on the page has it's own class that is then managed within the factory - aligns with SOLID principles such as SRP (Single Responsibility Principle) and SOC (Separation of Concerns), fostering modular and scalable code architecture.

# Features
* Playwright Integration: Utilizes Playwright, a Node library for automating Chromium, Firefox, and WebKit browsers.<br>
* Cucumber: Implements behavior-driven development (BDD) using Cucumber for test scenario definition.<br>
* Page Object Model (POM): Organizes web page interactions into separate page classes, promoting code modularity and readability.<br>
* Control Factory Pattern: Centralizes element locators and element interactions to avoid code duplication and ease maintenance.<br>
* Pico Container Dependency Injection: Leverages Pico Container to inject instances of PlaywrightHooks into StepsBase to eliminate redundant code.<br>

# Architecture Overview
### The framework comprises the following key components:

* PlaywrightHooks: Initializes the Playwright environment, sets up the browser, and manages browser contexts and pages.<br>
* StepsBase: Serves as the base class for step definitions, providing access to the browser context and page instances via dependency injection.<br>
* PracticeFormSteps: Defines step definitions for interacting with the practice form page, utilizing the PlaywrightHooks instance injected via constructor.<br>
* PracticeFormControlFactory: Centralizes the creation of form controls by mapping labels to corresponding control classes.<br>