package com.rideease.controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rideease.dao.VehicleDAO;
import com.rideease.model.Vehicle;

@WebServlet("/register")
public class RegisterVehicleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private VehicleDAO vehicleDAO;

    public void init() {
        vehicleDAO = new VehicleDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("register.jsp").forward(request, response);
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String brand = request.getParameter("brand");
        String color = request.getParameter("color");
        String type = request.getParameter("type");
        String name = request.getParameter("name");
        int capacity = Integer.parseInt(request.getParameter("capacity"));
        double pricePerHour = Double.parseDouble(request.getParameter("pricePerHour"));

        Vehicle vehicle = new Vehicle(brand, color, type, name, capacity, pricePerHour);

        try {
            vehicleDAO.addVehicle(vehicle);
            response.sendRedirect("profile?id=" + vehicle.getId());
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}