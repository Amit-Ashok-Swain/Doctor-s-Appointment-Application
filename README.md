# <h1 align="center"> Doctor's Appointment Application </h1>
___ 
<p align="center">
<a href="Java url">
    <img alt="Java" src="https://img.shields.io/badge/Java->=8-darkblue.svg" />
</a>
<a href="Maven url" >
    <img alt="Maven" src="https://img.shields.io/badge/maven-4.0-brightgreen.svg" />
</a>
<a href="Spring Boot url" >
    <img alt="Spring Boot" src="https://img.shields.io/badge/Spring Boot-3.1.4-brightgreen.svg" />
</a>
<a href="License url" >
    <img alt="BSD Clause 3" src="https://img.shields.io/badge/License-BSD_3--Clause-blue.svg"/>
</a>
</p>

---

<p align="left">

## Overview

The Doctor's Appointment Application is a Spring Boot-based system designed to facilitate doctor-patient appointments. It offers a set of RESTful API endpoints for booking and managing appointments, user authentication, and doctor profiles.

## Technologies Used

- **Framework:** Spring Boot
- **Language:** Java
- **Database:** MySQL
- **Build Tool:** Maven
- **API Documentation:** SpringDoc OpenAPI (Swagger UI)

## Dependencies Used

The project utilizes various dependencies to achieve its functionality:

- **Spring Boot Starter Data JPA**: Simplifies database access using Spring Data repositories.

- **Spring Boot Starter Web**: Provides support for building web applications, including RESTful APIs.

- **MySQL Connector/J (Runtime Dependency)**: The MySQL JDBC driver for connecting to MySQL databases.

- **Project Lombok (Optional)**: A library for reducing boilerplate code, such as getters and setters.

- **Spring Boot Starter Test (For Testing)**: Provides support for testing Spring Boot applications.

- **Springdoc OpenAPI (Swagger UI)**: Adds Swagger UI for documenting and testing API endpoints.

- **JavaMail API**: Used for sending emails.

- **Other Dependencies:** Various other dependencies are included in the `pom.xml` file for specific functionalities, such as Jackson for JSON serialization, Spring Web for web-related features, and more.

For a comprehensive list of all dependencies and their versions, please refer to the project's `pom.xml` file.

## Project Structure

The project follows a structured and organized architecture:

- **Main Application Class:** The entry point for the application is defined in the main class.
- **Entities:** The application includes entities such as `Doctor`, `Patient`, `Appointment`, and `AuthenticationToken` to model the data.
- **Repository Interfaces:** Spring Data JPA repository interfaces manage data access.
- **Service Classes:** Business logic is implemented in service classes for managing appointments, authentication, and doctors.
- **Controller Classes:** These classes define and document RESTful API endpoints for booking appointments, user authentication, and doctor profiles.

## Data Flow

The Doctor's Appointment Application follows a structured data flow for managing appointments and user authentication:

1. **Appointment Booking**:
    - A patient initiates an appointment booking by sending a `POST` request to the `/api/appointments/book` endpoint, specifying the doctor and the appointment time.

    - The system checks if the specified appointment slot is available.

    - If the slot is available, a new `Appointment` entity is created and saved in the database, associating the patient and the doctor.

    - The system sends a response indicating a successful booking.

2. **Appointment Cancellation**:
    - A patient can cancel an appointment by sending a `DELETE` request to the `/api/appointments/cancel/{appointmentId}` endpoint, specifying the appointment to cancel.

    - The system checks if the provided appointment exists and is associated with the patient.

    - If the appointment is valid, it is deleted from the database.

    - The system sends a response confirming the appointment cancellation.

3. **Get All Doctors**:
    - To retrieve a list of all available doctors, a patient sends a `GET` request to the `/api/doctors` endpoint.

    - The system queries the database to fetch the list of all doctors.

    - The system sends a response containing the list of doctors.

4. **User Registration (Sign Up)**:
    - A patient can register by sending a `POST` request to the `/api/patients/signup` endpoint, providing registration details such as first name, last name, email, password, and contact information.

    - The system checks if the provided email is unique, creates a new `Patient` entity with the user's information, and stores it in the database after encrypting the password.

    - The system sends a response indicating successful registration.

5. **User Authentication (Sign In)**:
    - To authenticate, a patient sends a `POST` request to the `/api/patients/signin` endpoint with their email and password.

    - The system validates the provided email and password, checking against the stored data in the database.

    - If the credentials are valid, the system generates an authentication token, associates it with the patient, and saves it in the database.

    - The system sends a response with the authentication token.

6. **Security**:
    - User authentication and authorization are handled securely, ensuring that user credentials are protected and that authentication tokens are used for secure API access.

7. **Data Persistence**:
    - The application relies on a relational database for data storage. Entities like doctors, patients, appointments, and authentication tokens are mapped to the corresponding database tables.

8. **RESTful API Endpoints**:
    - RESTful API endpoints provide a clear interface for patients to book and cancel appointments and interact with doctors. These endpoints are documented using Swagger UI.

> This data flow demonstrates how patients can interact with the application, book appointments with doctors, and manage their own profiles through registration and authentication. 


## RESTful API Endpoints

The application provides RESTful API endpoints for various functionalities:

### Appointment Management

- **Book Appointment:** `POST /api/appointments/book`
- **Cancel Appointment:** `DELETE /api/appointments/cancel/{appointmentId}`

### User Authentication

- **Sign Up:** `POST /api/auth/signup`
- **Sign In:** `POST /api/auth/signin`
- **Sign Out:** `POST /api/auth/signout`

### Doctor Profiles

- **Get All Doctors:** `GET /api/doctors`
- **Add Doctor:** `POST /api/doctors/add`
- **Get Doctor Appointments:** `GET /api/doctors/appointments/{doctorId}`

The API endpoints are documented, adhering to REST principles, and provide the core features of the Doctor's Appointment Application.

## Database Design

The application uses a relational database to store data, including doctor and patient information, appointments, and authentication tokens. Key attributes and tables include:

### Doctor Table

| Column Name | Data Type    | Description                 |
| ----------- | ------------ | --------------------------- |
| doctorId    | INT          | Unique identifier for doctors |
| doctorName  | VARCHAR(255) | Name of the doctor          |
| specialization | VARCHAR(255) | Doctor's specialization   |

### Doctor Table Description

- `doctorId`: Unique identifier for each doctor.
- `doctorName`: Name of the doctor.
- `specialization`: The doctor's specialization.
- `appointments`: A list of appointments associated with the doctor.


### Patient Table

| Column Name      | Data Type    | Description               |
| --------------- | ------------ | ------------------------- |
| patientId       | INT          | Unique identifier for patients |
| patientFirstName | VARCHAR(255) | First name of the patient |
| patientLastName  | VARCHAR(255) | Last name of the patient  |
| patientEmail     | VARCHAR(255) | Email address of the patient |
| patientPassword  | VARCHAR(255) | Encrypted password of the patient |
| patientContact   | VARCHAR(20)  | Contact information for the patient |

### Patient Table Description

- `patientId`: Unique identifier for each patient.
- `patientFirstName`: First name of the patient.
- `patientLastName`: Last name of the patient.
- `patientEmail`: Unique email address for the patient.
- `patientPassword`: Encrypted password for authentication.
- `patientContact`: Contact information for the patient.
- `appointment`: The patient's appointment.

### Appointment Table

| Column Name | Data Type    | Description                 |
| ----------- | ------------ | --------------------------- |
| appointmentId | INT        | Unique identifier for appointments |
| time        | DATETIME     | Date and time of the appointment |
| doctor_doc_id | INT        | Foreign key referencing the doctor |

### Appointment Table Description

- `id`: Embedded primary key consisting of appointmentId and time.
- `doctor`: A many-to-one relationship with the doctor.
- `patient`: A one-to-one relationship with the patient.

### AuthenticationToken Table

| Column Name     | Data Type    | Description               |
| --------------- | ------------ | ------------------------- |
| tokenId          | INT          | Unique identifier for tokens |
| token           | VARCHAR(255) | Authentication token value |
| tokenCreationDate | DATE    | Date of token creation     |
| fk_patient_ID    | INT        | Foreign key referencing the patient |

### Authentication Token Table Description

- `tokenId`: Unique identifier for each token.
- `token`: A unique token for user authentication.
- `tokenCreationDate`: The date when the token was created.
- `patient`: A one-to-one relationship with the patient.

## Data Structures Used

1. **Entities**:
    - **Doctor**: Represents a doctor with attributes like `doctorId`, `doctorName`, `specialization`, and a list of `appointments`.

    - **Patient**: Represents a patient with attributes like `patientId`, `patientFirstName`, `patientLastName`, `patientEmail`, `patientPassword`, `patientContact`, and an `appointment`.

    - **Appointment**: Represents an appointment between a doctor and a patient. It contains an embedded primary key `id`, a reference to the associated `doctor`, and a reference to the `patient`.

    - **Authentication Token**: Represents an authentication token with attributes like `tokenId`, `token`, `tokenCreationDate`, and a reference to the associated `patient`.

2. **Repositories**:
    - JPA repositories for data access, including repositories for doctors, patients, appointments, and authentication tokens.

In your Doctor's Appointment Application, you have various data structures, including entities and repositories. Additionally, ArrayLists are utilized for efficiently managing lists of entities. Let's delve into the detailed data structures used, with a specific focus on ArrayLists:

### Detailed Data Structures

1. **Entities**:

    - **Doctor Entity**:
        - `doctorId`: Unique identifier for each doctor.
        - `doctorName`: Name of the doctor.
        - `specialization`: Specialization of the doctor (e.g., "Cardiology," "Dermatology").
        - `appointments`: A list of `Appointment` entities representing the appointments associated with the doctor.

    - **Patient Entity**:
        - `patientId`: Unique identifier for each patient.
        - `patientFirstName`: First name of the patient.
        - `patientLastName`: Last name of the patient.
        - `patientEmail`: Email address of the patient (unique).
        - `patientPassword`: Password of the patient (hashed and securely stored).
        - `patientContact`: Contact information of the patient.
        - `appointment`: A reference to the `Appointment` entity representing the patient's appointment.

    - **Appointment Entity**:
        - `id`: An embedded primary key that includes `appointmentId` (unique identifier) and `time` (appointment time).
        - `doctor`: A reference to the associated doctor for the appointment.
        - `patient`: A reference to the associated patient for the appointment.

    - **AuthenticationToken Entity**:
        - `tokenId`: Unique identifier for each authentication token.
        - `token`: A unique token generated for user authentication.
        - `tokenCreationDate`: Date when the token was created.
        - `patient`: A reference to the associated patient for whom the token is issued.

2. **Repositories**:

    - **IAppointmentRepo**:
        - Extends `JpaRepository` for the `Appointment` entity. It allows for data access operations related to appointments.

    - **IDoctorRepo**:
        - Extends `JpaRepository` for the `Doctor` entity. It enables data access related to doctors.

    - **IPatientRepo**:
        - Extends `JpaRepository` for the `Patient` entity, allowing data access operations related to patients.

    - **ITokenRepo**:
        - Extends `JpaRepository` for the `AuthenticationToken` entity. It facilitates data access for authentication tokens.

### ArrayLists

ArrayLists are used in your application to efficiently manage lists of entities. Here's how ArrayLists are used in the context of your entities:

- **Doctor Entity**:
    - `appointments`: An ArrayList to manage the list of `Appointment` entities associated with a doctor. It allows for easy retrieval and manipulation of a doctor's appointments.

- **Patient Entity**:
    - There isn't a direct ArrayList in the `Patient` entity, but the patient's appointments are managed using a reference to the `Appointment` entity.

- **Appointment Entity**:
    - The `Appointment` entity itself doesn't contain an ArrayList, but it's utilized to establish relationships between doctors and patients. The list of appointments for a doctor can be managed using a collection of `Appointment` entities in the `Doctor` entity.

- **AuthenticationToken Entity**:
    - There isn't an ArrayList in the `AuthenticationToken` entity, but it's associated with a patient using a reference. The token and associated data are stored as individual records in the database.

> ArrayLists, as dynamic lists, provide flexibility for storing and managing multiple entities efficiently within your application. 

> The actual storage and retrieval of data are typically handled by the JPA repositories and underlying database systems.

> The use of data structures like entities, repositories, and authentication tokens ensures efficient data management and data integrity within the application.


## Database Configuration

The database connection properties, including the URL, username, and password, are specified in the `application.properties` file. Ensure that these properties are correctly configured to connect to your MySQL database.

Example configuration for MySQL:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/HospitalManagement
spring.datasource.username=root
spring.datasource.password=9892321787@As
spring.datasource.driverClassName=com.mysql.cj.jdbc.Driver
spring.jpa.database-platform=org.hibernate.dialect.MySQLDialect
```

Please replace `spring.datasource.url`, `spring.datasource.username`, and `spring.datasource.password` with your database connection details.

## Project Summary

The Doctor's Appointment Application is a Spring Boot-based system that simplifies doctor-patient appointment management. It provides RESTful API endpoints for booking and canceling appointments, user authentication, and doctor profiles.

The application is built on a solid foundation, utilizing Spring Boot and MySQL for data storage, and it follows best practices for clean code, separation of concerns, and secure user data handling.

### License

This project is licensed under the [BSD 3-Clause License](LICENSE).

### Acknowledgments

We would like to thank the Spring Boot and Java communities for providing excellent tools, frameworks, and resources that have contributed to the development of this project.

### Contact

For questions or feedback, please contact [Amit Ashok Swain](mailto:business.amitswain@gmail.com).
