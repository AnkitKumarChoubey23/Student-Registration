# Student-Registration
Developed a full-stack Student Registration System using Spring Boot, implementing RESTful APIs for managing student data. The application supports student enrollment, retrieval, update, and deletion with proper validation and exception handling.

The Student Registration System is a Spring Boot-based web application that allows administrators to manage student records efficiently. It performs complete CRUD operations and demonstrates a clean layered architecture used in enterprise applications.

🏗 Architecture

The project follows a Layered MVC Architecture:

Controller Layer → Service Layer → Repository Layer → Database
1️⃣ Controller Layer

Handles HTTP requests (GET, POST, PUT, DELETE)

Maps endpoints using @GetMapping, @PostMapping

Communicates with the Service layer

2️⃣ Service Layer

Contains business logic

Validates data before saving

Calls repository methods

3️⃣ Repository Layer

Extends JpaRepository

Performs database operations

🛠 Tech Stack

Backend: Spring Boot

Language: Java

ORM: Hibernate (JPA)

Database: MySQL

Build Tool: Maven

API Testing: Postman

🔥 Features

➕ Register new student

📄 View all students

✏ Update student details

❌ Delete student

🔍 Find student by ID

Exception handling for invalid IDs

Database integration with Hibernate

🗄 Database Configuration

Configured using application.properties:

spring.datasource.url=jdbc:mysql://localhost:3306/student_db
spring.datasource.username=root
spring.datasource.password=yourpassword

spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true
▶️ How to Run

Clone the repository

Create MySQL database

Update credentials in application.properties

Run the application

Access APIs via Postman or browser
