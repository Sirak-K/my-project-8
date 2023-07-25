# Address Book App

## Table of Contents

- [Address Book App](#address-book-app)
  - [Table of Contents](#table-of-contents)
  - [Project Description](#project-description)
  - [Features](#features)
  - [How to Install](#how-to-install)
  - [How to Use](#how-to-use)
  - [How to Test](#how-to-test)
  - [Test Results](#test-results)
  - [Technologies Used](#technologies-used)
  - [License](#license)
  - [Contact](#contact)

## Project Description

The Address Book Java Project is a simple application that allows users to manage their contacts. It provides basic functionalities to add, edit, delete, and view contacts. The project is built using Java and Maven, making it easy to compile and run on different platforms.

## Features

- Add a new contact with a name, phone number, and email.
- Edit existing contact details.
- Delete unwanted contacts from the address book.
- View the list of all contacts stored in the address book.

## How to Install

1. Ensure you have Java Development Kit (JDK) 17 or higher installed on your computer. If not, you can download and install it from the official Oracle website or adopt openJDK.

2. Make sure you have Apache Maven installed on your system. If not, you can download it from the Apache Maven website and follow the installation instructions for your operating system.

3. Clone this repository to your local machine using the following command:
   ```
   git clone https://github.com/Sirak-K/my-project-8.git
   ```

   Alternatively, you can download the ZIP file of the repository by clicking on the "Code" button on this page and then selecting "Download ZIP."

## How to Use

1. Open a terminal or command prompt and navigate to the project directory:
   ```
   cd my-project-8
   ```

2. Compile the Java source files and package the application using Maven:
   ```
   mvn package
   ```

3. Run the Address Book App using the following Maven command:
   ```
   mvn javafx:run
   ```

4. The application will launch, and you can start managing your contacts.

## How to Test

The Address Book App includes JUnit tests to ensure the correctness of its functionalities. To run the tests, follow these steps:

1. Open a terminal or command prompt and navigate to the project directory:
   ```
   cd my-project-8
   ```

2. Execute the following command to run the tests using Maven:
   ```
   mvn test
   ```

   The test results will be displayed in the terminal, indicating if all tests passed successfully.

## Test Results

| Test Case                          | Expected Outcome            |
|------------------------------------|-----------------------------|
| `testAddContact`                   | 1 contact added            |
| `testEditContact`                  | Contact updated successfully |
| `testDeleteContact`                | Contact deleted successfully |
| `testSearchContacts`               | 1 contact found            |
| `testSortContactsByFirstName`      | Contacts sorted by first name |
| `testSortContactsByLastName`       | Contacts sorted by last name |
| `testSortContactsByEmail`          | Contacts sorted by email     |
| `testAddressBookIsEmptyInitially`  | Address book is empty initially |
| `testAddressBookNotEmptyAfterAddingContact` | Address book is not empty after adding contact |

## Technologies Used

- Java SE 17
- JavaFX
- Apache Maven

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.

## Contact

For any questions or feedback, please contact [sirak.dev@gmail.com](mailto:sirak.dev@gmail.com).