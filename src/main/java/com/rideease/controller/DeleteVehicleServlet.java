package com.rideease.controller;

import com.rideease.dao.VehicleDAO;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/delete")
public class DeleteVehicleServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String id = request.getParameter("id");
        VehicleDAO vehicleDAO = new VehicleDAO();
        
        try {
            vehicleDAO.deleteVehicle(Integer.parseInt(id)); // Implement this method in VehicleDAO
            response.sendRedirect("profile.jsp"); // Redirect after deletion
        } catch (NumberFormatException e) {
            e.printStackTrace(); // Handle exception appropriately
        }
    }
}
