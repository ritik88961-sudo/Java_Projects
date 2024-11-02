
// Importing Necessary Packages
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.ArrayList;
import java.util.regex.Matcher;

// Abstract class to handle contact operations
class Contact_Operations {

    // Method to get the next ID from the file
    String getId() {
        String id = ""; // Variable to hold the ID
        try (
                // Creating a BufferedReader to read from the ID file
                BufferedReader br = new BufferedReader(new FileReader("data/id.txt"))) {
            id = br.readLine(); // Read the current ID from the file
        } catch (IOException e) {
            return "error"; // Return error if there is an issue
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("data/id.txt"))) {
            // Increment the ID and write the new value back to the file
            String newId = String.valueOf((Integer.parseInt(id) + 1));
            bw.write(newId); // Write the new ID to the file
            bw.flush(); // Flush the BufferedWriter to ensure data is written
        } catch (IOException e) {
            return "error"; // Return error if there is an issue writing to the file
        }
        return id; // Return the current ID
    }

    // Method to add a contact
    void addContact(String name, String phone, String email) {
        String id = getId(); // Get the new contact ID

        try (BufferedWriter bw = new BufferedWriter(new FileWriter("data/Contact_List.csv", true))) {
            // Check if ID is valid and proceed to validate email and phone
            if (!id.equals("error")) {
                if (validateEmail(email)) { // Validate the email format
                    if (phoneValidate(phone)) { // Validate the phone format
                        String newContact = id + "," + name + "," + phone + "," + email; // Create a new contact string
                        bw.newLine(); // Add a new line before writing the new contact
                        bw.write(newContact); // Write the new contact to the CSV file
                        bw.flush(); // Flush the BufferedWriter to ensure data is written
                        System.out.println("Contact Added. Contact ID is: - " + id); // Confirmation message
                    } else {
                        System.out.println("Invalid Phone Number"); // Error message for invalid phone
                    }
                } else {
                    System.out.println("Invalid Email"); // Error message for invalid email
                }
            } else {
                System.out.println("Something went wrong. Try again later"); // General error message
            }
        } catch (IOException e) {
            System.out.println("Something went wrong..."); // Catch block for writing errors
        }
    }

    // Method to show contact details by ID
    void showContactById(String id) {
        try (BufferedReader br = new BufferedReader(new FileReader("data/Contact_List.csv"))) {
            String data;
            while ((data = br.readLine()) != null) {
                String[] contact = data.split(","); // Split the contact data into an array
                if (contact[0].equals(id)) { // Check if the ID matches
                    // Print the contact details
                    System.out.println("Contact ID\t:\t" + contact[0]);
                    System.out.println("Name\t:\t" + contact[1]);
                    System.out.println("Phone\t:\t" + contact[2]);
                    System.out.println("Email\t:\t" + contact[3]);
                    return; // Exit method if contact is found
                }
            }
            System.out.println("Contact not found"); // Message if contact is not found
        } catch (IOException e) {
            System.out.println("Something went wrong."); // Error message for reading errors
        }
    }

    // Method to show all contacts
    void showAllContact() {
        try (BufferedReader br = new BufferedReader(new FileReader("data/Contact_List.csv"))) {
            br.readLine(); // Skip the header line
            String contact;
            System.out.println("Contact ID\t Name \t\tPhone \t\tEmail"); // Print header for contact list
            System.out.println("----------------------------------------------");
            while ((contact = br.readLine()) != null) {
                String[] specificContact = contact.split(","); // Split each contact data
                for (String con : specificContact) {
                    System.out.print(con + "\t"); // Print each contact detail
                }
                System.out.println(); // New line after each contact
            }
        } catch (IOException e) {
            System.out.println("Something went wrong"); // Error message for reading errors
        }
    }

    // Method to delete a contact by ID
    void deleteContact(String id) {
        ArrayList<String> contacts = new ArrayList<String>(); // List to hold remaining contacts
        try (BufferedReader br = new BufferedReader(new FileReader("data/Contact_List.csv"))) {
            String contact;
            while ((contact = br.readLine()) != null) {
                String[] con = contact.split(","); // Split each contact data
                if (!con[0].equals(id)) { // If ID does not match, add to the list
                    contacts.add(contact);
                }
            }
        } catch (IOException e) {
            System.out.println("Something went wrong"); // Error message for reading errors
            return; // Exit method if error occurs
        }
        try (BufferedWriter bw = new BufferedWriter(new FileWriter("data/Contact_List.csv"))) {
            // Write back the remaining contacts
            for (String contact : contacts) {
                bw.write(contact); // Write each contact to the CSV
                bw.newLine(); // Add a new line
                bw.flush(); // Flush the BufferedWriter
            }
            System.out.println("Deleted"); // Confirmation message
        } catch (IOException e) {
            System.out.println("Something went wrong"); // Error message for writing errors
        }
    }

    // Method to validate email format
    boolean validateEmail(String email) {
        String emailRegex = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,6}$"; // Email regex pattern
        Pattern p = Pattern.compile(emailRegex); // Compile the regex
        Matcher m = p.matcher(email); // Create a matcher for the email
        return m.matches(); // Return true if the email matches the pattern
    }

    // Method to validate phone number format
    boolean phoneValidate(String phone) {
        String phoneRegex = "^(\\+\\d{1,3})?[- ]?(\\(?\\d{3}\\)?)[- ]?\\d{3}[- ]?\\d{4}$"; // Phone regex pattern
        Pattern p = Pattern.compile(phoneRegex); // Compile the regex

        Matcher m = p.matcher(phone); // Create a matcher for the phone
        return m.matches(); // Return true if the phone matches the pattern
    }

}
