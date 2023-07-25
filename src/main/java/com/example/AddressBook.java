package com.example;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Represents an address book that stores a list of contacts.
 */
public class AddressBook {
    private ArrayList<Contact> contacts; // ArrayList to store Contact objects

    /**
     * Constructor to initialize an empty address book.
     */
    public AddressBook() {
        contacts = new ArrayList<>();
    }

    /**
     * Adds a new contact to the address book.
     *
     * @param contact The contact to be added.
     */
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    /**
     * Edits an existing contact in the address book.
     *
     * @param index         The index of the contact to be edited.
     * @param updatedContact The updated contact object.
     */
    public void editContact(int index, Contact updatedContact) {
        if (index >= 0 && index < contacts.size()) {
            contacts.set(index, updatedContact);
        } else {
            System.out.println("Invalid index. Contact not found.");
        }
    }

    /**
     * Deletes an existing contact from the address book.
     *
     * @param index The index of the contact to be deleted.
     */
    public void deleteContact(int index) {
        if (index >= 0 && index < contacts.size()) {
            contacts.remove(index);
        } else {
            System.out.println("Invalid index. Contact not found.");
        }
    }

    /**
     * Searches for contacts in the address book based on a keyword.
     *
     * @param keyword The keyword to search for in contact attributes (first name, last name, or email).
     * @return An ArrayList of contacts matching the search keyword.
     */
    public ArrayList<Contact> searchContacts(String keyword) {
        ArrayList<Contact> searchResults = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getFirstName().contains(keyword)
                    || contact.getLastName().contains(keyword)
                    || contact.getEmail().contains(keyword)) {
                searchResults.add(contact);
            }
        }
        return searchResults;
    }

    /**
     * Sorts the contacts in the address book using a provided comparator.
     *
     * @param comparator The comparator used to define the sorting order.
     */
    public void sortContacts(Comparator<Contact> comparator) {
        Collections.sort(contacts, comparator);
    }

    /**
     * Displays all contacts in the address book.
     */
    public void displayAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found in the address book.");
        } else {
            System.out.println("---- Address Book ----");
            for (int i = 0; i < contacts.size(); i++) {
                System.out.println("Contact " + (i + 1) + ":");
                System.out.println(contacts.get(i));
                System.out.println("----------------------");
            }
        }
    }

    /**
     * Checks if the address book is empty.
     *
     * @return true if the address book is empty, false otherwise.
     */
    public boolean isEmpty() {
        return contacts.isEmpty();
    }

    /**
     * Gets the ArrayList of contacts in the address book.
     *
     * @return The ArrayList of contacts.
     */
    public ArrayList<Contact> getContacts() {
        return contacts;
    }
}
