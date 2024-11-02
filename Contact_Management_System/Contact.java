// Class representing a contact which extends Contact_Operations for additional functionalities
public class Contact extends Contact_Operations {
    // Private fields to store contact details
    private String name; // Contact's name
    private String phone; // Contact's phone number
    private String email; // Contact's email address

    // Setter method to set the name of the contact
    void setName(String name) {
        this.name = name; // Assign the provided name to the name field
    }

    // Setter method to set the phone number of the contact
    void setPhone(String phone) {
        this.phone = phone; // Assign the provided phone number to the phone field
    }

    // Setter method to set the email address of the contact
    void setEmail(String email) {
        this.email = email; // Assign the provided email to the email field
    }

    // Getter method to retrieve the contact's name
    String getName() {
        return this.name; // Return the name field
    }

    // Getter method to retrieve the contact's phone number
    String getPhone() {
        return this.phone; // Return the phone field
    }

    // Getter method to retrieve the contact's email address
    String getEmail() {
        return this.email; // Return the email field
    }
}
