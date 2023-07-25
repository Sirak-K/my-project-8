package com.example;

/**
 * Represents a contact with attributes such as first name, last name, email, and phone number.
 */
public class Contact {
    // Attributes to store contact information
    private String firstName;    // Holds the first name of the contact
    private String lastName;     // Holds the last name of the contact
    private String email;        // Holds the email address of the contact
    private String phoneNumber;  // Holds the phone number of the contact

    /**
     * Constructor to initialize a new Contact object with provided information.
     *
     * @param firstName   The first name of the contact.
     * @param lastName    The last name of the contact.
     * @param email       The email address of the contact.
     * @param phoneNumber The phone number of the contact.
     */
    public Contact(String firstName, String lastName, String email, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.phoneNumber = phoneNumber;
    }

    // Getter and Setter methods to access and modify contact attributes

    /**
     * Returns the first name of the contact.
     *
     * @return The first name of the contact.
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the first name of the contact.
     *
     * @param firstName The first name of the contact to set.
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the last name of the contact.
     *
     * @return The last name of the contact.
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the last name of the contact.
     *
     * @param lastName The last name of the contact to set.
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the email address of the contact.
     *
     * @return The email address of the contact.
     */
    public String getEmail() {
        return email;
    }

    /**
     * Sets the email address of the contact.
     *
     * @param email The email address of the contact to set.
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * Returns the phone number of the contact.
     *
     * @return The phone number of the contact.
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * Sets the phone number of the contact.
     *
     * @param phoneNumber The phone number of the contact to set.
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * Provides a formatted representation of the contact details.
     *
     * @return A formatted string representing the contact details.
     */
    @Override
    public String toString() {
        return "Name: " + firstName + " " + lastName + "\n"
               + "Email: " + email + "\n"
               + "Phone: " + phoneNumber;
    }
}
