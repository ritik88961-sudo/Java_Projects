import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class ContactManager {
    private static Scanner sc = new Scanner(System.in);
    private Contact contact; // Instance of Contact to manage contacts

    public ContactManager() {
        contact = new Contact(); // Initialize the Contact object
    }

    // Method to collect contact details from user input
    private List<String> contactDetails() {
        ArrayList<String> contactInfo = new ArrayList<>();
        System.out.print("Name: \t");
        sc.nextLine(); // Consume newline
        String name = sc.nextLine();
        System.out.print("Phone: \t");
        String phone = sc.nextLine();
        System.out.print("Email: \t");
        String email = sc.nextLine();
        contactInfo.add(name);
        contactInfo.add(phone);
        contactInfo.add(email);
        return contactInfo;
    }

    // Method to display the main menu and handle user choices
    public void Menu() {
        boolean running = true; // Control the application loop
        while (running) {
            System.out.println("What do you want to do?");
            System.out.println("1. Add Contact \t 2. Delete Contact \t 3. Show All Contacts \t 4. Show Contact by ID");
            try {
                int op = sc.nextInt(); // Read user choice
                switch (op) {
                    case 1:
                        List<String> contactInfo = contactDetails(); // Get contact info
                        contact.setName(contactInfo.get(0));
                        contact.setPhone(contactInfo.get(1));
                        contact.setEmail(contactInfo.get(2));
                        contact.addContact(contact.getName(), contact.getPhone(), contact.getEmail()); // Add contact
                        break;
                    case 2:
                        System.out.print("Contact ID: \t");
                        sc.nextLine(); // Consume newline
                        String idToDelete = sc.nextLine();
                        contact.deleteContact(idToDelete); // Delete contact
                        break;
                    case 3:
                        contact.showAllContact(); // Show all contacts
                        break;
                    case 4:
                        System.out.println("Contact ID: ");
                        sc.nextLine(); // Consume newline
                        String idToShow = sc.nextLine();
                        contact.showContactById(idToShow); // Show specific contact
                        break;
                    default:
                        System.out.println("Wrong Selection");
                }

                System.out.println("Do you want to exit? y/n");
                char run = sc.next().charAt(0);
                if (run == 'y' || run == 'Y') {
                    running = false; // Exit loop
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid Input");
                sc.nextLine(); // Clear the scanner buffer
            }
        }
    }
}
