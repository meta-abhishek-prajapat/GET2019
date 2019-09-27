<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:set var="pageTitle" scope="request" value="Home" />
<%@include file="../includes/header.jsp"%>



			<a href="getUser">Get User Details</a>
			<br> <br>
			<a href = "updateUser">Update User Details</a>
			<br> <br>
			<a href = "getAdmin">Get Admin Details</a>
			<br> <br>
			<a href = "updateAdmin">Update Admin Details</a>
			<br> <br>
			<form  method="POST" action="/logout">
				<input type="submit" value="LogOut">
			</form>

<jsp:include flush="true" page="../includes/footer.jsp"></jsp:include>