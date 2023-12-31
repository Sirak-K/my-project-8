package com.example;

import java.util.ArrayList;
import java.util.Comparator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test class for the AddressBook class.
 */
public class AddressBookTests {

    private AddressBook addressBook;

    @BeforeEach
    public void setUp() {
        addressBook = new AddressBook();
    }

    // TEST-1: Test adding a new contact to the address book
    @Test
    public void testAddContact() {
        Contact contact = new Contact("John", "Doe", "john.doe@example.com", "1234567890");
        addressBook.addContact(contact);
        assertEquals(1, addressBook.getContacts().size());
    }

    // TEST-2: Test editing an existing contact in the address book
    @Test
    public void testEditContact() {
        Contact contact = new Contact("John", "Doe", "john.doe@example.com", "1234567890");
        addressBook.addContact(contact);

        Contact updatedContact = new Contact("John", "Smith", "john.smith@example.com", "9876543210");
        addressBook.editContact(0, updatedContact);

        Contact editedContact = addressBook.getContacts().get(0);
        assertEquals("Smith", editedContact.getLastName());
        assertEquals("john.smith@example.com", editedContact.getEmail());
        assertEquals("9876543210", editedContact.getPhoneNumber());
    }

    // TEST-3: Test deleting an existing contact from the address book
    @Test
    public void testDeleteContact() {
        Contact contact = new Contact("John", "Doe", "john.doe@example.com", "1234567890");
        addressBook.addContact(contact);
        addressBook.deleteContact(0);
        assertTrue(addressBook.getContacts().isEmpty());
    }

    // TEST-4: Test searching for contacts by keyword in the address book
    @Test
    public void testSearchContacts() {
        Contact contact1 = new Contact("John", "Doe", "john.doe@example.com", "1234567890");
        Contact contact2 = new Contact("Jane", "Smith", "jane.smith@example.com", "9876543210");
        addressBook.addContact(contact1);
        addressBook.addContact(contact2);

        ArrayList<Contact> searchResults = addressBook.searchContacts("john");
        assertEquals(1, searchResults.size());
        assertEquals("John Doe", searchResults.get(0).getFirstName() + " " + searchResults.get(0).getLastName());
    }

    // TEST-5: Test sorting contacts by first name in the address book
    @Test
    public void testSortContactsByFirstName() {
        Contact contact1 = new Contact("John", "Doe", "john.doe@example.com", "1234567890");
        Contact contact2 = new Contact("Jane", "Smith", "jane.smith@example.com", "9876543210");
        addressBook.addContact(contact1);
        addressBook.addContact(contact2);

        addressBook.sortContacts(Comparator.comparing(Contact::getFirstName));

        assertEquals("Jane", addressBook.getContacts().get(0).getFirstName());
        assertEquals("John", addressBook.getContacts().get(1).getFirstName());
    }

    // TEST-6: Test sorting contacts by last name in the address book
    @Test
    public void testSortContactsByLastName() {
        Contact contact1 = new Contact("John", "Doe", "john.doe@example.com", "1234567890");
        Contact contact2 = new Contact("Jane", "Smith", "jane.smith@example.com", "9876543210");
        addressBook.addContact(contact1);
        addressBook.addContact(contact2);

        addressBook.sortContacts(Comparator.comparing(Contact::getLastName));

        assertEquals("Doe", addressBook.getContacts().get(0).getLastName());
        assertEquals("Smith", addressBook.getContacts().get(1).getLastName());
    }

    // TEST-7: Test sorting contacts by email in the address book
    @Test
    public void testSortContactsByEmail() {
        Contact contact1 = new Contact("John", "Doe", "john.doe@example.com", "1234567890");
        Contact contact2 = new Contact("Jane", "Smith", "jane.smith@example.com", "9876543210");
        addressBook.addContact(contact1);
        addressBook.addContact(contact2);

        addressBook.sortContacts(Comparator.comparing(Contact::getEmail));

        assertEquals("jane.smith@example.com", addressBook.getContacts().get(0).getEmail());
        assertEquals("john.doe@example.com", addressBook.getContacts().get(1).getEmail());
    }

    // TEST-8: Test that the address book is initially empty
    @Test
    public void testAddressBookIsEmptyInitially() {
        assertTrue(addressBook.isEmpty());
    }

    // TEST-9: Test that the address book is not empty after adding a contact
    @Test
    public void testAddressBookNotEmptyAfterAddingContact() {
        Contact contact = new Contact("John", "Doe", "john.doe@example.com", "1234567890");
        addressBook.addContact(contact);
        assertFalse(addressBook.isEmpty());
    }
}
