# Console-Based Contact Management System

## Table of Contents
1. [Overview](#overview)
2. [Technologies Used](#technologies-used)
3. [Software Development Life Cycle (SDLC) Processes](#software-development-life-cycle-sdlc-processes)
4. [Installation Guide](#installation-guide)
5. [Usage](#usage)

## Overview
The Console-Based Contact Management System is a Java application that allows users to manage their contacts through a command-line interface. Users can easily add, delete, view, and search for contacts. This lightweight solution is ideal for individuals or small businesses looking for an efficient way to handle contact information without the complexity of graphical user interfaces.

## Technologies Used
1. **Programming Language:**
   - **Java:** The application is built using Java, leveraging its Object-Oriented Programming (OOP) capabilities for clean and organized code structure.
   
2. **Data Management:**
   - **CSV and Text Files:** This application uses CSV and text files to store contact details persistently. By saving data to files, the application ensures that contact information is retained even after the program is closed, allowing for efficient data retrieval when the application is reopened.

   
3. **Input Handling:**
   - **Scanner:** User input is handled through the Scanner class, enabling interaction via the console for adding and managing contacts.
   
4. **Error Handling:**
   - **InputMismatchException:** Robust error handling ensures the application gracefully manages invalid user inputs, enhancing user experience and stability.

## Software Development Life Cycle (SDLC) Processes
1. **Planning:**
   - Identified the need for a console-based application to manage contacts effectively.
   - Gathered requirements focusing on essential features such as adding, deleting, and displaying contacts.
   
2. **Analysis:**
   - Analyzed user needs to determine the core functionalities required.
   - Developed use cases to visualize user interactions with the system.
   
3. **Design:**
   - Designed a simple class structure, including classes for managing contacts and user interactions.
   - Defined methods for core functionalities such as adding, deleting, and listing contacts.
   
4. **Implementation:**
   - Developed the application in Java, implementing the designed functionalities using clear and structured code.
   - Included user prompts and input handling to facilitate smooth interaction.
   
5. **Testing:**
   - Conducted unit tests to ensure each component functions as intended.
   - Performed user acceptance testing to validate that the application meets user needs and expectations.
   
6. **Deployment:**
   - The application is deployed in a local environment, ready for use by end-users directly from the console.
   
7. **Maintenance:**
   - Established a plan for ongoing maintenance, including bug fixes and potential feature enhancements based on user feedback.

## Installation Guide
To set up the Console-Based Contact Management System on your local machine, follow these steps:

1. **Prerequisites:**
   - Ensure you have Java Development Kit (JDK) installed. You can download it from the [official Oracle website](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).

2. **Clone the Repository:**
   Open your terminal or command prompt and clone the repository:
   ```bash
   https://github.com/ritik88961-sudo/Java_Projects.git
3. **Navigate to the Project Directory:**
  Move into the Contact_Management_System directory within the cloned repository:
   ```bash
   cd Java_Projects/Contact_Management_System
4. **Compile the Java Files:**
   Compile all necessary .java files:
   ```bash
   javac Main.java Contact.java Contact_Operations.java ContactManager.java
5. **Run the Application:**
   Launch the Contact Management System by running the Main class:
   ```bash
   java Main

## Usage
After starting the application, follow the console prompts to:
- Add new contacts
- Delete contacts
- View all contacts
- Search for a contact by ID
