<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
	<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
   <h1>Booking List</h1>
   
   <h4>Total Bookings: ${total}</h4>

    <c:forEach items="${bookings}" var="booking">
        <div class="booking-entry">
            <p>ID: ${booking.bookingid}</p>
            <p>Name: ${booking.name}</p>
            <p>Pickup: ${booking.pickup}</p>
            <p>Destination: ${booking.destination}</p>
            <p>Time: ${booking.time}</p>
            <p>Fare: ${booking.fare}</p>
            <hr/>
        </div>
    </c:forEach>
</body>
</html>