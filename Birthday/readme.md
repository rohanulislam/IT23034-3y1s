Birthday Manager (জন্মদিন ম্যানেজার)

A simple JavaFX-based desktop application for managing birthdays, written in Java.
It allows users to add, update, delete, and search birthdays, and shows upcoming birthdays as well as notifications for birthdays today.

Features
Add new birthdays (name + date of birth).
Update existing birthdays by name.
Delete birthdays by name.
Search birthdays by name or month.
View upcoming birthdays in order (month/day).
Pop-up notification for birthdays today.
Supports Bengali and English month names.

Requirements
Java JDK 25
JavaFX 25
MySQL database installed (or compatible relational database)

Database Setup
Create a MySQL database:
CREATE DATABASE birthdaydb;
The app automatically creates a table birthdays:
CREATE TABLE IF NOT EXISTS birthdays(
  id INT AUTO_INCREMENT PRIMARY KEY,
  name VARCHAR(100),
  dob DATE
);

Setup Instructions
Clone or download the project.
Add the JavaFX libraries to your project (lib folder or module path).
Configure your IDE VM options (IntelliJ example):
--module-path "C:\path\to\javafx\lib" --add-modules javafx.controls,javafx.fxml
-Dprism.order=sw -Dprism.verbose=true --enable-native-access=javafx.graphics
Run Main.java.

Usage
Enter a name and date of birth.
Click যোগ করুন to add a birthday.
Select a name and new date, then click হালনাগাদ to update.
Enter a name or month in the search box and click অনুসন্ধান.
Click আসন্ন জন্মদিন to view birthdays in order.
On app start, a popup alerts if anyone has a birthday today.

Notes
The app uses software rendering (-Dprism.order=sw) to avoid graphics issues on some systems.
Supports Bengali month names (জানুয়ারি, ফেব্রুয়ারি, মার্চ) as well as numeric month searches.
Works on Windows, Linux, and Mac as long as JavaFX is properly configured.

License
This project is open-source and free to use.

