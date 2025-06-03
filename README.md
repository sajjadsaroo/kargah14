# User Registration & Login System (Hibernate + MySQL)

A simple command-line Java application for user **Sign-up** and **Login** using **Hibernate ORM** and **MySQL** as the database.  
It supports persistent storage of user data, password validation, and duplicate email checks.

---

## 📦 Features

- Register new users with:
  - First name
  - Last name
  - Age
  - Email (used as unique username)
  - Password (must be at least 8 characters)
- Prevent duplicate email registrations
- Login with stored email/password
- Friendly welcome message upon successful login
- Uses Hibernate + MySQL (or SQLite if configured)
- Stores user data persistently

---

## 🛠 Technologies

- Java 17+
- Hibernate 5.6
- MySQL 8.x
- Maven
- JPA (Jakarta Persistence)

---

## 🗃 Database Schema

Run the following SQL to create the database and seed some sample users:

```sql
CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    age INT NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);

INSERT INTO users (first_name, last_name, age, email, password) VALUES
('Ali', 'Ahmadi', 22, 'ali@example.com', 'password123'),
('Sara', 'Mohammadi', 19, 'sara@example.com', 'mypassword'),
('Reza', 'Kiani', 25, 'reza@example.com', 'rezaPass88');
