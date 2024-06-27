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

@WebServlet("/update")
public class UpdateVehicleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private VehicleDAO vehicleDAO;

    public void init() {
        vehicleDAO = new VehicleDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        try {
            Vehicle vehicle = vehicleDAO.getVehicle(id);
            System.out.println(vehicle);
            request.setAttribute("vehicle", vehicle);
            request.getRequestDispatcher("update.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String brand = request.getParameter("brand");
        String color = request.getParameter("color");
        String type = request.getParameter("type");
        String name = request.getParameter("name");
        int capacity = Integer.parseInt(request.getParameter("capacity"));
        double pricePerHour = Double.parseDouble(request.getParameter("pricePerHour"));

        Vehicle vehicle = new Vehicle(brand, color, type, name, capacity, pricePerHour);
        vehicle.setId(id);

        try {
            vehicleDAO.updateVehicle(vehicle);
            response.sendRedirect("profile?id=" + id);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}