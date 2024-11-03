import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TaskManager extends TaskOperations {

    // Method to validate that the end date is after the start date and that the
    // date format is correct
    private static boolean isValidDateRange(String startDate, String endDate) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        dateFormat.setLenient(false); // Ensure strict parsing

        try {
            Date start = dateFormat.parse(startDate);
            Date end = dateFormat.parse(endDate);

            // Check if the end date is before the start date
            if (end.before(start)) {
                System.out.println("Error: The end date is before the start date.");
                return false;
            }
            return true;
        } catch (ParseException e) {
            System.out.println("Error: Date format should be DD-MM-YYYY.");
            return false;
        }
    }

    // Method to collect task details from the user
    static ArrayList<String> taskDetails(BufferedReader br) {
        ArrayList<String> task_detail = new ArrayList<>();
        try {
            System.out.print("Description/Task Name\t\t\t: \t");
            task_detail.add(br.readLine()); // Add task name/description

            System.out.print("Task Start Date (DD-MM-YYYY)\t\t: \t");
            String startDate = br.readLine();

            System.out.print("Task Finish Date (DD-MM-YYYY)\t\t: \t");
            String endDate = br.readLine();

            // Validate the date range and add to list if valid
            if (!isValidDateRange(startDate, endDate)) {
                task_detail.clear(); // Clear list if date range is invalid
                task_detail.add("Invalid date range.");
                return task_detail;
            }

            task_detail.add(startDate);
            task_detail.add(endDate);
            return task_detail;

        } catch (IOException e) {
            task_detail.clear(); // Clear list and add error message if input fails
            task_detail.add("Something went wrong.");
            return task_detail;
        }
    }

    // Method to retrieve a task ID from the user and handle input errors
    int getUserTaskId(BufferedReader br) {
        try {
            System.out.print("Task ID\t\t:\t");
            int taskId = Integer.parseInt(br.readLine()); // Parse integer from input
            return taskId;
        } catch (IOException e) {
            return -1; // Return -1 if input fails
        } catch (NumberFormatException e) {
            return -1; // Return -1 if input is not a valid integer
        }
    }

    // Main menu for task operations
    void Menu() {
        boolean running = true; // Controls the menu loop
        try (BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
            while (running) {
                System.out.println("What do you want to do?");
                System.out.println(
                        "1. Add Task. \t 2. Delete Task.\t 3. Update Task. \t 4. Search Task. \t 5. Show all Task.");
                try {
                    // Get user's choice
                    int op = Integer.parseInt(br.readLine());
                    int taskId;
                    ArrayList<String> task_detail = new ArrayList<>();

                    // Process user's choice
                    switch (op) {
                        case 1: // Add a new task
                            task_detail = taskDetails(br);
                            if (task_detail.size() > 1) {
                                addTask(task_detail.get(0), task_detail.get(1), task_detail.get(2));
                            } else {
                                System.out.println(task_detail.get(0)); // Display error if invalid date range
                            }
                            break;
                        case 2: // Delete a task
                            taskId = getUserTaskId(br);
                            if (taskId != -1) {
                                int deleteOrNot = deleteTask(String.valueOf(taskId));
                                if (deleteOrNot == 1) {
                                    System.out.println("Deleted");
                                } else if (deleteOrNot == -1) {
                                    System.out.println("Task not available of this ID.");
                                } else {
                                    System.out.println("Something went Wrong.");
                                }
                            } else {
                                System.out.println("Invalid task ID");
                            }
                            break;
                        case 3: // Update a task
                            taskId = getUserTaskId(br);
                            if (taskId != -1) {
                                updateTask(String.valueOf(taskId), br);
                            } else {
                                System.out.println("Invlid Task ID");
                            }
                            break;
                        case 4: // Search for a task by ID
                            taskId = getUserTaskId(br);
                            if (taskId != -1) {
                                String task[] = searchTaskById(String.valueOf(taskId)).split(",");
                                if (task.length > 1) {
                                    System.out.println("Task ID\t\t:\t" + task[0]);
                                    System.out.println("Description\t:\t" + task[1]);
                                    System.out.println("Start Date\t:\t" + task[2]);
                                    System.out.println("Finish Date\t:\t" + task[3]);
                                } else {
                                    System.out.println(task[0]); // Display error message if task not found
                                }

                            } else {
                                System.out.println("Invalid task ID");
                            }
                            break;
                        case 5: // Show all tasks
                            showAllTask();
                            break;
                        default: // Invalid menu choice
                            System.out.println("Wrong choice");
                            break;
                    }

                    // Check if user wants to exit
                    System.out.print("Do you want to exit? y/n\t");
                    String run = br.readLine();
                    if (run.equals("y") || run.equals("y")) { // Allow case-insensitive "y" input
                        running = false;
                    }
                } catch (InputMismatchException e) {
                    System.out.println("Invalid input."); // Handle non-numeric menu input
                }
            }
        } catch (IOException e) {
            System.out.println("Something went wrong."); // Handle general I/O error
        }
    }
}
