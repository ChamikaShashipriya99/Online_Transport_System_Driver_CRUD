package com.rideease.controller;

import java.io.IOException;
//import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.rideease.dao.VehicleDAO;
import com.rideease.model.Vehicle;

@WebServlet("/")
public class VehicleListServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private VehicleDAO vehicleDAO;

    public void init() {
        vehicleDAO = new VehicleDAO();
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Vehicle> vehicles = vehicleDAO.getAllVehicles();
		request.setAttribute("vehicles", vehicles);
		request.getRequestDispatcher("index.jsp").forward(request, response);
    }
}
