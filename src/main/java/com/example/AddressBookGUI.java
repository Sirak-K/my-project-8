package com.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class AddressBookGUI extends Application {

    private AddressBook addressBook;

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        // Initialize the AddressBook
        addressBook = new AddressBook();

        // Create the main VBox to hold the GUI components
        VBox vbox = new VBox();

        // Create menu items and associate actions
        MenuItem addMenuItem = new MenuItem("Add Contact");
        addMenuItem.setOnAction(e -> showAddContactDialog());

        MenuItem editMenuItem = new MenuItem("Edit Contact");
        editMenuItem.setOnAction(e -> showEditContactDialog());

        MenuItem deleteMenuItem = new MenuItem("Delete Contact");
        deleteMenuItem.setOnAction(e -> showDeleteContactDialog());

        MenuItem searchMenuItem = new MenuItem("Search Contact");
        searchMenuItem.setOnAction(e -> showSearchContactDialog());

        MenuItem sortMenuItem = new MenuItem("Sort Contacts");
        sortMenuItem.setOnAction(e -> showSortContactDialog());

        // Create the MenuBar and add the menu items
        MenuBar menuBar = new MenuBar();
        Menu menu = new Menu("Menu");
        menu.getItems().addAll(addMenuItem, editMenuItem, deleteMenuItem, searchMenuItem, sortMenuItem);
        menuBar.getMenus().add(menu);

        // Add the MenuBar to the VBox
        vbox.getChildren().add(menuBar);

        // Create the Scene and set it in the Stage
        Scene scene = new Scene(vbox, 400, 300);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Address Book");
        primaryStage.show();
    }

    private void showAddContactDialog() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Add Contact");
        dialog.setHeaderText("Enter contact details:");

        // Add input fields for first name, last name, email, phone number, etc.
        // For simplicity, let's assume you have separate fields for each contact attribute.

        // Show the dialog and get the result
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(contactDetails -> {
            // Parse the contact details (assuming they are comma-separated)
            String[] detailsArray = contactDetails.split(",");

            // Check if the input has all the required attributes
            if (detailsArray.length == 4) {
                String firstName = detailsArray[0].trim();
                String lastName = detailsArray[1].trim();
                String email = detailsArray[2].trim();
                String phoneNumber = detailsArray[3].trim();

                // Create a new Contact object
                Contact newContact = new Contact(firstName, lastName, email, phoneNumber);

                // Add the new contact to the AddressBook
                addressBook.addContact(newContact);
            } else {
                // Invalid input format
                // Display an error message or handle the error as per your preference
                System.out.println("Invalid input format. Please enter all contact details.");
            }
        });
    }

    private void showEditContactDialog() {
        // Check if there are any contacts to edit
        if (addressBook.isEmpty()) {
            showAlert("Edit Contact", "No contacts found in the address book.");
            return;
        }

        // Create a list of contact names to display in the ChoiceDialog
        List<String> contactNames = new ArrayList<>();
        for (Contact contact : addressBook.getContacts()) {
            contactNames.add(contact.getFirstName() + " " + contact.getLastName());
        }

        // Create the ChoiceDialog to select the contact to edit
        ChoiceDialog<String> dialog = new ChoiceDialog<>(contactNames.get(0), contactNames);
        dialog.setTitle("Edit Contact");
        dialog.setHeaderText("Select the contact to edit:");

        // Show the dialog and get the selected contact name
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(selectedContactName -> {
            // Find the selected contact in the AddressBook
            int index = contactNames.indexOf(selectedContactName);
            if (index >= 0) {
                // Display another dialog to get the updated details for the contact
                TextInputDialog editDialog = new TextInputDialog();
                editDialog.setTitle("Edit Contact");
                editDialog.setHeaderText("Enter updated contact details:");

                // Here, we use multiple TextInputDialogs to get each attribute's updated value
                editDialog.setContentText("First Name:");
                Optional<String> firstNameResult = editDialog.showAndWait();
                if (!firstNameResult.isPresent()) return; // User canceled the edit, return without further processing

                editDialog.setContentText("Last Name:");
                Optional<String> lastNameResult = editDialog.showAndWait();
                if (!lastNameResult.isPresent()) return;

                editDialog.setContentText("Email:");
                Optional<String> emailResult = editDialog.showAndWait();
                if (!emailResult.isPresent()) return;

                editDialog.setContentText("Phone Number:");
                Optional<String> phoneNumberResult = editDialog.showAndWait();
                if (!phoneNumberResult.isPresent()) return;

                // Parse the updated contact details
                String firstName = firstNameResult.get().trim();
                String lastName = lastNameResult.get().trim();
                String email = emailResult.get().trim();
                String phoneNumber = phoneNumberResult.get().trim();

                // Create a new Contact object with the updated details
                Contact updatedContact = new Contact(firstName, lastName, email, phoneNumber);

                // Update the selected contact in the AddressBook
                addressBook.editContact(index, updatedContact);

                // Show a confirmation message for successful update
                showAlert("Edit Contact", "Contact updated successfully!");
            } else {
                // Contact not found (should not happen with ChoiceDialog, but added for completeness)
                System.out.println("Selected contact not found.");
            }
        });
    }



    private void showDeleteContactDialog() {
        // Check if there are any contacts to delete
        if (addressBook.isEmpty()) {
            showAlert("Delete Contact", "No contacts found in the address book.");
            return;
        }


        // Create a list of contact names to display in the ChoiceDialog
        List<String> contactNames = new ArrayList<>();
        for (Contact contact : addressBook.getContacts()) {
            contactNames.add(contact.getFirstName() + " " + contact.getLastName());
        }

        // Create the ChoiceDialog to select the contact to delete
        ChoiceDialog<String> dialog = new ChoiceDialog<>(contactNames.get(0), contactNames);
        dialog.setTitle("Delete Contact");
        dialog.setHeaderText("Select the contact to delete:");

        // Show the dialog and get the selected contact name
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(selectedContactName -> {
            // Find the selected contact in the AddressBook
            int index = contactNames.indexOf(selectedContactName);
            if (index >= 0) {
                // Delete the selected contact from the AddressBook
                addressBook.deleteContact(index);
            } else {
                // Contact not found (should not happen with ChoiceDialog, but added for completeness)
                System.out.println("Selected contact not found.");
            }
        });
    }


private void showAlert(String title, String message) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle(title);
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
}

    private void showSearchContactDialog() {
        TextInputDialog dialog = new TextInputDialog();
        dialog.setTitle("Search Contact");
        dialog.setHeaderText("Enter the keyword to search contacts:");

        // Show the dialog and get the keyword
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(keyword -> {
            // Search for contacts based on the keyword
            ArrayList<Contact> searchResults = addressBook.searchContacts(keyword);

            // Display the search results
            if (searchResults.isEmpty()) {
                System.out.println("No contacts found matching the search keyword.");
            } else {
                System.out.println("Search Results:");
                for (Contact contact : searchResults) {
                    System.out.println(contact);
                }
            }
        });
    }


    private void showSortContactDialog() {
        // Check if there are any contacts to sort
        if (addressBook.isEmpty()) {
            System.out.println("No contacts found in the address book.");
            return;
        }

        // Create the ChoiceDialog to select the sorting criteria
        List<String> sortOptions = Arrays.asList("First Name", "Last Name", "Email");
        ChoiceDialog<String> dialog = new ChoiceDialog<>(sortOptions.get(0), sortOptions);
        dialog.setTitle("Sort Contacts");
        dialog.setHeaderText("Select the sorting criteria:");

        // Show the dialog and get the selected sorting criteria
        Optional<String> result = dialog.showAndWait();
        result.ifPresent(selectedCriteria -> {
            // Sort contacts based on the selected criteria
            switch (selectedCriteria) {
                case "First Name":
                    addressBook.sortContacts(Comparator.comparing(Contact::getFirstName));
                    break;
                case "Last Name":
                    addressBook.sortContacts(Comparator.comparing(Contact::getLastName));
                    break;
                case "Email":
                    addressBook.sortContacts(Comparator.comparing(Contact::getEmail));
                    break;
            }
            System.out.println("Contacts sorted by " + selectedCriteria);
            // Display the sorted contacts (optional)
            addressBook.displayAllContacts();
        });
    }
}
