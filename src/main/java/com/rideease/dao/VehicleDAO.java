package com.rideease.dao;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import com.rideease.model.Vehicle;

public class VehicleDAO {
    private Connection connection;

    public VehicleDAO() {
        // Initialize the database connection
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/rideease", "root", "Chamika1999");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void addVehicle(Vehicle vehicle) throws SQLException {
        String sql = "INSERT INTO vehicles (brand, color, type, name, capacity, price_per_hour) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS)) {
            statement.setString(1, vehicle.getBrand());
            statement.setString(2, vehicle.getColor());
            statement.setString(3, vehicle.getType());
            statement.setString(4, vehicle.getName());
            statement.setInt(5, vehicle.getCapacity());
            statement.setDouble(6, vehicle.getPricePerHour());
            statement.executeUpdate();

            ResultSet generatedKeys = statement.getGeneratedKeys();
            if (generatedKeys.next()) {
                vehicle.setId(generatedKeys.getInt(1));
            }
        }
    }

    public Vehicle getVehicle(int id) throws SQLException {
        String sql = "SELECT * FROM vehicles WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, id);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                return extractVehicleFromResultSet(resultSet);
            }
        }
        return null;
    }

    // Updated method to retrieve all vehicles
    public List<Vehicle> getAllVehicles() {
        List<Vehicle> vehicles = new ArrayList<>();
        String sql = "SELECT * FROM vehicles"; // Adjust the table name if necessary

        try (PreparedStatement ps = connection.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
             
            while (rs.next()) {
                Vehicle vehicle = new Vehicle();
                vehicle.setId(rs.getInt("id"));
                vehicle.setBrand(rs.getString("brand"));
                vehicle.setColor(rs.getString("color"));
                vehicle.setType(rs.getString("type"));
                vehicle.setName(rs.getString("name"));
                vehicle.setCapacity(rs.getInt("capacity"));
                vehicle.setPricePerHour(rs.getDouble("price_per_hour")); // Adjust according to your DB column name
                vehicles.add(vehicle);
            }
        } catch (SQLException e) {
            e.printStackTrace(); // Handle your exceptions properly
        }
        return vehicles;
    }

    // Updated method to delete a vehicle
    public void deleteVehicle(int id) {
        String sql = "DELETE FROM vehicles WHERE id = ?";
        try (PreparedStatement ps = connection.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace(); // Handle your exceptions properly
        }
    }

    public void updateVehicle(Vehicle vehicle) throws SQLException {
        String sql = "UPDATE vehicles SET brand = ?, color = ?, type = ?, name = ?, capacity = ?, price_per_hour = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, vehicle.getBrand());
            statement.setString(2, vehicle.getColor());
            statement.setString(3, vehicle.getType());
            statement.setString(4, vehicle.getName());
            statement.setInt(5, vehicle.getCapacity());
            statement.setDouble(6, vehicle.getPricePerHour());
            statement.setInt(7, vehicle.getId());
            statement.executeUpdate();
        }
    }

    private Vehicle extractVehicleFromResultSet(ResultSet resultSet) throws SQLException {
        Vehicle vehicle = new Vehicle(
            resultSet.getString("brand"),
            resultSet.getString("color"),
            resultSet.getString("type"),
            resultSet.getString("name"),
            resultSet.getInt("capacity"),
            resultSet.getDouble("price_per_hour")
        );
        vehicle.setId(resultSet.getInt("id"));
        return vehicle;
    }
}
