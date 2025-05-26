# Project Title
RideEase

## Description
RideEase is a web application designed to provide a seamless ride-sharing service. It connects drivers with passengers looking for rides, offering an efficient and convenient transportation solution.

## Features
- User Registration (`register.jsp`)
- User Login (`login.jsp`)
- User Profile Management (`profile.jsp`, `editProfile.jsp`, `updateProfile.jsp`)
- Ride Booking and Management (`bookRide.jsp`, `confirmBooking.jsp`, `bookingHistory.jsp`)
- Ride Offering and Management for Drivers (`offerRide.jsp`, `driverDashboard.jsp`)
- Search and Filter Rides (`searchRides.jsp`)
- Notifications/Alerts (conceptual, e.g., `notifications.jsp`)
- Password Management (`forgotPassword.jsp`, `resetPassword.jsp`)
- Feedback and Rating System (conceptual)
- Admin functionalities (conceptual, e.g. `adminDashboard.jsp`, `manageUsers.jsp`, `manageRides.jsp`)

## Technologies Used
- **Frontend:** JSP (JavaServer Pages), HTML, CSS, JavaScript
- **Backend:** Java Servlets
- **Database:** SQL (specific RDBMS like MySQL, PostgreSQL, etc. to be chosen by the user, with `rideease_DB.sql` providing the schema)
- **Web Server:** Apache Tomcat (or any other Servlet container like Jetty, JBoss)
- **Version Control:** Git and GitHub

## Setup and Installation
1.  **Prerequisites:**
    *   Java Development Kit (JDK) 8 or higher installed.
    *   Apache Tomcat 7 or higher installed.
    *   A SQL database server (e.g., MySQL, PostgreSQL) installed.
    *   Git installed.
2.  **Clone the repository:**
    ```bash
    git clone https://github.com/your-username/RideEase.git
    cd RideEase
    ```
3.  **Database Setup:**
    *   Follow the instructions in the "Database Setup" section below to create the database and tables using the `rideease_DB.sql` script.
    *   Update database connection details in the relevant Java configuration files (e.g., a `DBConnection.java` or properties file) within the `src/main/java` directory. You'll need to set the database URL, username, and password.
4.  **Build the Project (if necessary):**
    *   If the project uses a build tool like Maven or Gradle, run the appropriate commands (e.g., `mvn clean install` or `gradle build`).
    *   If not, ensure the project structure is compatible with direct deployment to Tomcat (WEB-INF/classes for servlets, WEB-INF/lib for JARs). JSPs are typically in the webapp root.
5.  **Deploy to Tomcat:**
    *   Copy the project's WAR file (if built) or the entire project directory to the `webapps` directory of your Apache Tomcat installation.
    *   Alternatively, configure Tomcat to point to your project directory (e.g., via `server.xml` or a context file).
6.  **Start Tomcat Server:**
    *   Navigate to the `bin` directory of your Tomcat installation and run `startup.sh` (for Linux/macOS) or `startup.bat` (for Windows).
7.  **Access the Application:**
    *   Open your web browser and go to `http://localhost:8080/RideEase` (assuming default Tomcat port and project named RideEase).

## Usage
1. Open your web browser and navigate to the application (e.g., `http://localhost:8080/RideEase`).
2. Register for a new account or log in if you already have one.
3. Explore the features:
    - Create new code snippets.
    - View existing snippets.
    - Comment on snippets to provide feedback.
    - Manage your own snippets.

## Database Setup
This project uses a SQL database. The schema is provided in the `rideease_DB.sql` file.

1.  **Choose and Install a SQL Database Server:**
    *   Install a SQL RDBMS like MySQL, PostgreSQL, SQL Server, or Oracle Database if you haven't already.
    *   For development purposes, SQLite can also be an option, but `rideease_DB.sql` might be specific to a certain SQL dialect (e.g., MySQL).
2.  **Create a Database:**
    *   Connect to your database server using a command-line client (e.g., `mysql`, `psql`) or a GUI tool (e.g., phpMyAdmin, pgAdmin, DBeaver).
    *   Create a new database for the RideEase application. For example, in MySQL:
        ```sql
        CREATE DATABASE rideease_db;
        ```
    *   Create a dedicated user for the application and grant it privileges to the new database:
        ```sql
        CREATE USER 'rideease_user'@'localhost' IDENTIFIED BY 'your_secure_password';
        GRANT ALL PRIVILEGES ON rideease_db.* TO 'rideease_user'@'localhost';
        FLUSH PRIVILEGES;
        ```
        (Adjust `'localhost'` and password as needed).
3.  **Import the Schema:**
    *   Use your database client tool to import the schema from `rideease_DB.sql` into the newly created database.
    *   **For MySQL:**
        ```bash
        mysql -u rideease_user -p rideease_db < database/rideease_DB.sql
        ```
    *   **For PostgreSQL:**
        ```bash
        psql -U rideease_user -d rideease_db -f database/rideease_DB.sql
        ```
    *   If using a GUI tool, look for an "Import", "Run SQL Script", or similar option.
4.  **Configure Application:**
    *   Update the database connection details (URL, username, password, database name) in the application's configuration files. This is typically found in a Java class under `src/main/java` (e.g., `DBConnectionProvider.java`, `DatabaseUtil.java`) or a properties file in `WEB-INF/classes`.
