# RideEase

A web application for managing vehicles. Users can register new vehicles, view details of existing vehicles, update vehicle information, and delete vehicles from the system.

## Setup and Installation

1.  **Database Setup:**
    *   Ensure you have MySQL server installed and running.
    *   Create a database named `rideease`.
    *   Import the schema from the `rideease_DB.sql` file provided in the repository.
    *   Open `src/main/java/com/rideease/dao/VehicleDAO.java`.
    *   Update the database connection details (URL, username, password) in the `VehicleDAO` constructor:
        ```java
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rideease", "your_mysql_username", "your_mysql_password");
        ```

2.  **Deployment:**
    *   This project is a standard Java Web Application. You can build it into a `.war` file.
    *   Deploy the generated `.war` file to a servlet container like Apache Tomcat.
    *   Alternatively, you can import the project into an IDE like Eclipse or IntelliJ IDEA and run it on a configured server.

## How to Use

1.  Once the application is deployed and running, open your web browser and navigate to the application's home page (e.g., `http://localhost:8080/RideEase/` - the exact URL might vary based on your server configuration and context path).
2.  The home page displays a list of available vehicles.
3.  Click on "Register Your Vehicle Here" to add a new vehicle to the system.
4.  Fill in the vehicle details in the registration form and submit.
5.  You will be redirected to the vehicle's profile page, showing its details.
6.  From the profile page, you can choose to update the vehicle's information or delete it.
7.  You can view all vehicles again by navigating back to the home page.

## Features

*   Register new vehicles
*   View vehicle details
*   Update vehicle information
*   Delete vehicles
*   List all available vehicles

## Technologies Used

*   **Backend:** Java, Servlets, JDBC
*   **Frontend:** JSP, HTML, CSS, Bootstrap
*   **Database:** MySQL

## Contributing

Guidelines for contributing to the project.

## License

Information about the project's license.
