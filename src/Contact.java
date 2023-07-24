// Contacts.java (Contact Class)
public class Contact {
    // Attributes to store contact information
    private String firstName;    // Holds the first name of the contact
    private String lastName;     // Holds the last name of the contact
    private String email;        // Holds the email address of the contact
    private String phoneNumber;  // Holds the phone number of the contact

    // Constructor to initialize a new Contact object with provided information
    public Contact(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Getter and Setter methods to access and modify contact attributes

    // Getter for retrieving the first name of the contact
    public String getFirstName() {
        return firstName;
    }

    // Setter for updating the first name of the contact
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter for retrieving the last name of the contact
    public String getLastName() {
        return lastName;
    }

    // Setter for updating the last name of the contact
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Getter for retrieving the email address of the contact
    public String getEmail() {
        return email;
    }

    // Setter for updating the email address of the contact
    public void setEmail(String email) {
        this.email = email;
    }

    // Getter for retrieving the phone number of the contact
    public String getPhoneNumber() {
        return phoneNumber;
    }

    // Setter for updating the phone number of the contact
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    // Override toString method to provide a formatted representation of the contact details
    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName + "\n" +
               "Email: " + email + "\n" +
               "Phone: " + phoneNumber;
    }
}
