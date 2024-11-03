
// Importing necessary Packages
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

// Abstract class TaskOperations provides basic CRUD operations for task management
abstract public class TaskOperations {
    // File paths for storing tasks and tracking task IDs
    static String task_List_File = "data/taskList.csv";
    static String task_id_file = "data/taskId.txt";

    // Adds a new task to the task list with the provided details
    void addTask(String description, String startDate, String finishDate) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(task_List_File, true))) {
            String taskID = getId(); // Generates a unique task ID
            if (helperWriteTask(taskID, description, startDate, finishDate, true)) {
                System.out.println("------------------------------------------");
                System.out.println("Task added. Task ID is\t\t\t:\t" + taskID);
            } else {
                System.out.println("Error adding task. Try again later...");
            }

        } catch (IOException e) {
            System.out.println("Something went wrong.");
        }
    }

    // Deletes a task by its ID and returns status code
    int deleteTask(String taskId) {
        boolean taskAvailable = false;
        ArrayList<String> taskList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(task_List_File))) {
            String data;
            while ((data = br.readLine()) != null) {
                String[] taskOne = data.split(",");
                if (!taskOne[0].equals(taskId)) { // Retain tasks except the one with given ID
                    taskList.add(data);
                    taskAvailable = true;
                }
            }
            if (!taskAvailable) {
                return -1; // Task ID not found
            }
        } catch (IOException e) {
            return 0; // Error while reading the file
        }

        // Rewrite the remaining tasks to the file
        boolean append = false;
        for (int i = 0; i < taskList.size(); i++) {
            String taskOne[] = taskList.get(i).split(",");
            if (taskOne.length > 1) { // Ensure data format is valid
                if (append == false) {
                    helperWriteTask(taskOne[0], taskOne[1], taskOne[2], taskOne[3], append);
                    append = true;
                } else {
                    helperWriteTask(taskOne[0], taskOne[1], taskOne[2], taskOne[3], append);
                }
            }
        }
        return 1; // Task deleted successfully
    }

    // Displays all tasks in a formatted table view
    void showAllTask() {
        // Set column widths for each field
        String headerFormat = "%-5s %-30s %-15s %-15s%n";
        String rowFormat = "%-5s %-30s %-15s %-15s%n";

        // Print header row
        System.out.printf(headerFormat, "ID", "Description", "Start Date", "End Date");
        System.out.println("--------------------------------------------------------------------------");

        try (BufferedReader br = new BufferedReader(new FileReader(task_List_File))) {
            String line;
            while ((line = br.readLine()) != null) {
                // Split CSV line into fields and ensure there are exactly 4 columns
                String[] task = line.split(",");
                if (task.length == 4) { // Validate task data format
                    // Print formatted data for each column
                    System.out.printf(rowFormat, task[0], task[1], task[2], task[3]);
                } else {
                    System.out.println("Data format issue in line: " + line);
                }
            }
        } catch (IOException e) {
            System.out.println("Something went wrong.");
            e.printStackTrace();
        }
    }

    // Searches for a task by ID and returns task details or error message
    String searchTaskById(String taskId) {
        try (BufferedReader br = new BufferedReader(new FileReader(task_List_File))) {
            boolean taskAvailable = false;
            String data;
            while ((data = br.readLine()) != null) {
                String[] task = data.split(",");
                if (task[0].equals(taskId)) { // Check if task ID matches
                    taskAvailable = true;
                    return data; // Return task details if found
                }
            }
            if (!taskAvailable) {
                return "Invalid task ID. Task not available of this ID.";
            }
            return "Something went wrong";
        } catch (IOException e) {
            return "Something went wrong.";
        }
    }

    // Updates a task with new details provided by user input
    void updateTask(String taskId, BufferedReader br) {
        String taskToUpdate[] = searchTaskById(taskId).split(",");
        try {
            if (taskToUpdate.length > 1) { // Check if task is valid
                System.out.print("Description\t\t:\t");
                String desc = br.readLine();
                if (!(desc.equals(""))) {
                    taskToUpdate[1] = desc; // Update description if provided
                }
                System.out.print("Start Date:\t\t:\t");
                String startDate = br.readLine();
                if (!(startDate.equals(""))) {
                    taskToUpdate[2] = startDate; // Update start date if provided
                }
                System.out.print("End Date:\t\t:\t");
                String endDate = br.readLine();
                if (!(endDate.equals(""))) {
                    taskToUpdate[3] = endDate; // Update end date if provided
                }
                deleteTask(taskId); // Remove old task entry
                if (helperWriteTask(taskId, taskToUpdate[1], taskToUpdate[2], taskToUpdate[3], true)) {
                    System.out.println("Updated");
                }

            } else {
                System.out.println("Task Not Available"); // Task ID not found
                return;
            }

        } catch (IOException e) {
            System.out.println("Something went wrong");
        }
    }

    // Writes or appends a task to the task list file
    boolean helperWriteTask(String taskId, String desc, String start_date, String end_date, boolean appendOrNot) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(task_List_File, appendOrNot))) {
            String task = taskId + "," + desc + "," + start_date + "," + end_date;
            bw.newLine();
            bw.write(task);
            bw.flush();
            return true;
        } catch (IOException e) {
            return false;
        }
    }

    // Generates a unique ID for new tasks, increments and stores it
    String getId() {
        String taskId;
        try (BufferedReader br = new BufferedReader(new FileReader(task_id_file))) {
            taskId = br.readLine();
        } catch (IOException e) {
            return "error";
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(task_id_file))) {
            String newId = String.valueOf((Integer.parseInt(taskId) + 1));
            bw.write(newId);
            bw.flush();
            return taskId;
        } catch (IOException e) {
            return "error"; // Return error if unable to update ID
        }
    }
}
