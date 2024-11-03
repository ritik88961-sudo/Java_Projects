# Task Manager Application

## Table of Contents
1. [Description](#description)
2. [Features](#features)
3. [Getting Started](#getting-started)
   - [Prerequisites](#prerequisites)
   - [Directory Structure](#directory-structure)
   - [Running the Application](#running-the-application)
4. [Usage Instructions](#usage-instructions)
5. [Software Development Life Cycle (SDLC)](#software-development-life-cycle-sdlc)
6. [License](#license)
7. [Acknowledgments](#acknowledgments)

## Description
The **Task Manager** is a Java-based application designed to help users manage their tasks efficiently. Users can add, delete, update, search, and view all tasks with associated details, such as task description and start/finish dates.

## Features
- **Add Task**: Create new tasks by providing a description and date range.
- **Delete Task**: Remove existing tasks by entering the task ID.
- **Update Task**: Modify existing tasks as needed.
- **Search Task**: Look up tasks using their unique ID.
- **Show All Tasks**: View a list of all tasks stored in the system.

## Getting Started

### Prerequisites
- Java Development Kit (JDK) version 8 or higher installed on your machine.
- Basic command line knowledge to execute Java applications.

### Directory Structure
Ensure the following directory structure for your application:<br>
**Java Files**<br>
***To_Do_List/ TaskManager.java TaskOperations.java Main.java***<br> 
**Data**<br>
***To_Do_List/data/taskList.csv taskId.txt***
### Running the Application
1. **Clone the repository**:
    ```bash
    git clone https://github.com/ritik88961-sudo/Java_Projects
    cd To_Do_List
    ```

2. **Compile the Java files**:
    ```bash
    javac Main.java TaskManager.java TaskOperations.java
    ```

3. **Run the Application**:
    ```bash
    java Main
    ```

## Usage Instructions
1. **Start the Application**: Execute the `Main` class to launch the application.
2. **Main Menu Options**:
   - You will see a prompt asking, "What do you want to do?" with the following options:
     1. Add Task
     2. Delete Task
     3. Update Task
     4. Search Task
     5. Show All Tasks
3. **Choose an Option**: Enter the number corresponding to your desired action.
4. **Follow On-Screen Prompts**:
   - For adding a task, provide the task description and the start and finish dates in the format DD-MM-YYYY.
   - For deleting or updating tasks, input the task ID when prompted.
   - For searching tasks, enter the task ID to retrieve task details.
5. **Exit the Application**: After completing your tasks, you can choose to exit by responding to the prompt with 'y' (yes) or 'n' (no).

## Software Development Life Cycle (SDLC)

### 1. **Requirement Analysis**
   - Gathered requirements from potential users regarding features like task management, including adding, deleting, updating, and searching tasks.

### 2. **Design**
   - Created a high-level design of the application, focusing on the core functionality and user interactions.
   - Designed class structures to encapsulate task operations and user interface.

### 3. **Implementation**
   - Developed the application using Java, implementing functionalities to manage tasks based on the defined requirements.
   - Ensured robust error handling for user inputs and date validations.

### 4. **Testing**
   - Conducted unit tests to verify individual components.
   - Performed integration testing to ensure all parts of the application work together seamlessly.

### 5. **Deployment**
   - **Objective**: Prepare the application for end-user installation and execution.
   - **Deployment Steps**:
     - **Directory Structure**: Maintained a specific directory for data files (`data/taskList.csv` and `taskId.txt`) to ensure file consistency.
     - **User Documentation**: Included this README file with instructions for running the application and basic usage of the menu options.

### 6. **Maintenance**
   - Regular updates and bug fixes will be provided based on user feedback.
   - Future enhancements may include additional features like task prioritization and notifications.

## License
This project is licensed under the MIT License - see the [LICENSE](LICENSE) file for details.

## Acknowledgments
- Inspired by user feedback on task management needs.
- Thanks to the contributors and community for support.
