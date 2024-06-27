<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>RideEase - Register Vehicle</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">

    <style>
        /* Same styles as before */
        body {
            font-family: Arial, sans-serif;
            margin: 0;
            padding: 0;
            display: flex;
            flex-direction: column;
            min-height: 100vh;
        }
        nav {
            background-color: #2563eb;
            padding: 1rem;
        }
        nav .container {
            display: flex;
            justify-content: space-between;
            align-items: center;
            max-width: 1200px;
            margin: 0 auto;
        }
        nav .logo {
            color: white;
            font-size: 1.5rem;
            font-weight: bold;
        }
        nav ul {
            list-style-type: none;
            display: flex;
            gap: 1rem;
        }
        nav a {
            color: white;
            text-decoration: none;
        }
        nav a:hover {
            text-decoration: underline;
        }
        .get-started {
            background-color: #22c55e;
            color: white;
            padding: 0.5rem 1rem;
            border-radius: 9999px;
            text-decoration: none;
            display: inline-flex;
            align-items: center;
        }
        .get-started:hover {
            background-color: #16a34a;
        }
        main {
            flex-grow: 1;
            max-width: 1200px;
            margin: 0 auto;
            padding: 2rem;
        }
        table {
            width: 100%;
            border-collapse: collapse;
            margin-bottom: 1rem;
        }
        th, td {
            border: 1px solid #e5e7eb;
            padding: 0.5rem;
            text-align: left;
        }
        th {
            background-color: #f3f4f6;
        }
        .pay-now {
            background-color: #3b82f6;
            color: white;
            padding: 0.5rem 1rem;
            border: none;
            border-radius: 0.25rem;
            cursor: pointer;
        }
        .pay-now:hover {
            background-color: #2563eb;
        }
        footer {
            background-color: #1f2937;
            color: white;
            padding: 2rem;
        }
        .footer-content {
            display: grid;
            grid-template-columns: repeat(3, 1fr);
            gap: 2rem;
            max-width: 1200px;
            margin: 0 auto;
        }
        .footer-section h3 {
            font-size: 1.25rem;
            margin-bottom: 0.5rem;
        }
        .footer-section ul {
            list-style-type: none;
            padding: 0;
        }
        .footer-section a {
            color: white;
            text-decoration: none;
        }
        .footer-section a:hover {
            text-decoration: underline;
        }
        .social-icons {
            display: flex;
            gap: 1rem;
            margin-top: 0.5rem;
        }
        .social-icons a {
            color: white;
            text-decoration: none;
        }
        .copyright {
            text-align: center;
            margin-top: 2rem;
        }

    </style>
</head>
<body>
    <nav>
        <div class="container">
            <span class="logo">RideEase</span>
            <ul>
                <li><a href="#">Home</a></li>
                <li><a href="#">Book a Ride</a></li>
                <li><a href="#">My Bookings</a></li>
                <li><a href="#">Contact</a></li>
                <li><a href="#" class="get-started">Get Started</a></li>
            </ul>
        </div>
    </nav>

    <div class="container mt-5">
        <h1 class="text-center mb-4">Register Your Vehicle</h1>
        <div class="row justify-content-center">
            <div class="col-md-6">
                <form action="${pageContext.request.contextPath}/register" method="post" onsubmit="return validateForm()">
                    <div class="mb-3">
                        <label for="brand" class="form-label">Vehicle Brand</label>
                        <input type="text" class="form-control" id="brand" name="brand" required>
                    </div>
                    <div class="mb-3">
                        <label for="color" class="form-label">Vehicle Color</label>
                        <input type="text" class="form-control" id="color" name="color" required>
                    </div>
                    <div class="mb-3">
                        <label for="type" class="form-label">Vehicle Type</label>
                        <input type="text" class="form-control" id="type" name="type" required>
                    </div>
                    <div class="mb-3">
                        <label for="name" class="form-label">Vehicle Name</label>
                        <input type="text" class="form-control" id="name" name="name" required>
                    </div>
                    <div class="mb-3">
                        <label for="capacity" class="form-label">Capacity (persons)</label>
                        <input type="number" class="form-control" id="capacity" name="capacity" required>
                    </div>
                    <div class="mb-3">
                        <label for="pricePerHour" class="form-label">Price per Hour</label>
                        <input type="number" step="0.01" class="form-control" id="pricePerHour" name="pricePerHour" required>
                    </div>
                    <div class="text-center">
                        <button type="submit" class="btn btn-primary">Register Vehicle</button><br><br>
                    </div>
                </form>
            </div>
        </div>
    </div>

    <footer>
        <div class="footer-content">
            <div class="footer-section">
                <h3>RideEase</h3>
                <p>Your trusted partner for comfortable and reliable transportation.</p>
            </div>
            <div class="footer-section">
                <h3>Quick Links</h3>
                <ul>
                    <li><a href="#">About Us</a></li>
                    <li><a href="#">Services</a></li>
                    <li><a href="#">Terms of Service</a></li>
                    <li><a href="#">Privacy Policy</a></li>
                </ul>
            </div>
            <div class="footer-section">
                <h3>Connect With Us</h3>
                <div class="social-icons">
                    <a href="#">Facebook</a>
                    <a href="#">Twitter</a>
                    <a href="#">Instagram</a>
                </div>
                <p>Email: info@rideease.com</p>
                <p>Phone: (555) 123-4567</p>
            </div>
        </div>
        <div class="copyright">
            <p>&copy; 2024 RideEase. All rights reserved.</p>
        </div>
    </footer>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>

    <script>
        function validateForm() {
            var capacity = document.getElementById("capacity").value;
            var pricePerHour = document.getElementById("pricePerHour").value;

            if (capacity <= 0) {
                alert("Capacity must be greater than 0");
                return false;
            }
            if (pricePerHour <= 0) {
                alert("Price per hour must be greater than 0");
                return false;
            }
            return true;
        }
    </script>
</body>
</html>
