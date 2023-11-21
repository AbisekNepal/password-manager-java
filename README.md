# Password Generator Application

## Overview

The **Password Generator Application** is a Java-based desktop application that allows users to generate strong and secure passwords. The application provides a user-friendly interface where users can customize password criteria such as length, character types (alphabets, symbols, and numbers), and associate the generated password with specific accounts.

## Features

- **User-Friendly Interface**: The application features an intuitive and easy-to-use interface.
- **Customizable Password Criteria**: Users can customize password length and choose to include alphabets, symbols, and numbers.
- **Account Association**: Users can associate generated passwords with specific accounts, providing context for each password.
- **Security Questions and Notes**: The application allows users to set up security questions and add notes for additional security and reference.
- **Database Integration**: Passwords and associated information can be saved to a local MySQL database for future reference.

## Getting Started

To run the Password Generator Application, follow these steps:

1. **Clone the Repository:**
   ```bash
   git clone https://github.com/abiseknepal/password-manager-java.git
   ```

2. **Run the Application:**
   - Open the project in your preferred Java IDE.
   - Locate the `passMaker` class and run the application.

## Usage

1. **Generate Passwords:**
   - Enter the required information such as website, username, and select an account type.
   - Adjust the password length and choose character types.
   - Click the "Generate" button to create a strong password.

2. **Save Passwords:**
   - Fill in the necessary details for website, username, and password.
   - Select an account type and set up security questions if desired.
   - Click the "Save" button to store the password in the local database.

3. **Export Passwords:**
   - Click the "Export All" button to export all stored passwords to a text file (`passwords.txt`).

4. **Security Questions and Notes:**
   - Set up security questions and provide answers for added security.
   - Add notes to store additional information related to the password.

## Dependencies

- Java Swing for the graphical user interface.
- MySQL database for storing passwords and associated information.

## Contributors

- [Abisek]

## License

This project is licensed under the [MIT License](LICENSE).

## Acknowledgments

- Special thanks to Professor Pipop for additional library of .jar file.

---

Feel free to contribute, report issues, or suggest enhancements. We appreciate your feedback!
