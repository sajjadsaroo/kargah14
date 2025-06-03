CREATE TABLE users (
    id INT PRIMARY KEY AUTO_INCREMENT,
    first_name VARCHAR(50) NOT NULL,
    last_name VARCHAR(50) NOT NULL,
    age INT NOT NULL,
    email VARCHAR(100) NOT NULL UNIQUE,
    password VARCHAR(100) NOT NULL
);

INSERT INTO users (first_name, last_name, age, email, password)
VALUES
('Ali', 'Ahmadi', 22, 'ali@example.com', 'password123'),
('Sara', 'Mohammadi', 19, 'sara@example.com', 'mypassword'),
('Reza', 'Kiani', 25, 'reza@example.com', 'rezaPass88');
