<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>Book Your Cab</h1>
	<form action="/add-booking" method="post">
		<div>
			Name: <input type="text" name="name">
		</div>
		<div>
			Pickup: <input type="text" name="pickup">
		</div>
		<div>
			Destination: <input type="text" name="destination">
		</div>
		<div>
			Time: <input type="text" name="time">
		</div>
		<div>
			<button type="submit">Book Now</button>
		</div>
	</form>
</body>
</html>