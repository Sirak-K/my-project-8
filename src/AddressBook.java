import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

// AddressBook.java (AddressBook Class)
public class AddressBook {
    private ArrayList<Contact> contacts; // ArrayList to store Contact objects

    // Constructor to initialize an empty address book
    public AddressBook() {
        contacts = new ArrayList<>();
    }

    // Method: ADD New Contact
    public void addContact(Contact contact) {
        contacts.add(contact);
    }

    // Method: EDIT Existing Contact
    public void editContact(int index, Contact updatedContact) {
        if (index >= 0 && index < contacts.size()) {
            contacts.set(index, updatedContact);
        } else {
            System.out.println("Invalid index. Contact not found.");
        }
    }

    // Method: DELETE Existing Contact
    public void deleteContact(int index) {
        if (index >= 0 && index < contacts.size()) {
            contacts.remove(index);
        } else {
            System.out.println("Invalid index. Contact not found.");
        }
    }

    // Method: SEARCH Existing Contact
    public ArrayList<Contact> searchContacts(String keyword) {
        ArrayList<Contact> searchResults = new ArrayList<>();
        for (Contact contact : contacts) {
            if (contact.getFirstName().contains(keyword) ||
                contact.getLastName().contains(keyword) ||
                contact.getEmail().contains(keyword)) {
                searchResults.add(contact);
            }
        }
        return searchResults;
    }

    // Method: SORT Existing Contact
    public void sortContacts(Comparator<Contact> comparator) {
        Collections.sort(contacts, comparator);
    }

    // Method: DISPLAY Existing Contact
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

    // Method: Check if AddressBook is Empty
    public boolean isEmpty() {
        return contacts.isEmpty();
    }

    // Method: Get the ArrayList of Contacts
    public ArrayList<Contact> getContacts() {
        return contacts;
    }
}
