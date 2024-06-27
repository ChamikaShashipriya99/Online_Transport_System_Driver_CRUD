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

@WebServlet("/profile")
public class VehicleProfileServlet extends HttpServlet {
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
            request.setAttribute("vehicle", vehicle);
            request.getRequestDispatcher("profile.jsp").forward(request, response);
        } catch (SQLException e) {
            throw new ServletException(e);
        }
    }
}