# password-manager-java
 
# Password Generator Documentation

## Table of Contents
- [Introduction](#introduction)
- [Features](#features)
- [Usage](#usage)
- [Options](#options)
- [Saving and Exporting](#saving-and-exporting)
- [Requirements](#requirements)
- [Installation](#installation)
- [License](#license)

## Introduction
Welcome to **myPassManager**, a simple yet powerful password generator and manager built in Java. This application allows you to generate strong, secure passwords for your various accounts and store them securely.

## Features
- Password generation with customizable options
- Save generated passwords along with website, username, and account type
- Export all saved passwords to a text file
- User-friendly graphical interface

## Usage
1. **Website and Username**: Enter the website URL and your username for which you want to generate or save a password.
2. **Account Type**: Select the account type from the dropdown menu (e.g., Office, School, Travel).
3. **Password Length**: Adjust the slider to choose the length of the generated password (between 10 and 20 characters).
4. **Character Options**: Check the options for including alphabets, symbols, and/or numbers in the generated password.
5. **Generate Password**: Click the "Generate" button to create a new password based on your preferences.
6. **Copy Password**: Click the "Copy" button to copy the generated password to the clipboard.
7. **Save Password**: Click the "Save" button to store the generated password along with website, username, and account type in the database.
8. **Export All**: Click the "Export All" button to export all saved passwords to a text file.
9. **Quit**: Click the "Quit" button to exit the application.

## Options
- **Alphabets**: Include lowercase alphabets (x, y, z) in the password.
- **Symbols**: Include symbols (@, #, !) in the password.
- **Numbers**: Include numbers (1, 2, 3) in the password.

## Saving and Exporting
- To save a password, ensure that the website, username, and password fields are filled, and an account type is selected. Click the "Save" button.
- To export all saved passwords, click the "Export All" button. The passwords will be exported to a file named "passwords.txt."

## Requirements
- Java Runtime Environment (JRE) installed on your system.
- MySQL database for saving and retrieving passwords.

## Installation
1. Download the Java source code file (`passMaker.java`) and ensure you have the necessary Java development tools installed.
2. Set up a MySQL database with the name `myPassGenerate`.
3. Compile and run the Java code to launch the application.

## License
This project is licensed under the [MIT License](LICENSE).

Feel free to contribute or report issues on [GitHub](https://github.com/your/repository).
