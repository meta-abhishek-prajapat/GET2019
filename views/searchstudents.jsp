<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ page import="com.metacube.eadsession3.Student" %>
<%@ page import="java.util.ArrayList" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<script>
function searchstudents() {
	
	var searchbyname = document.getElementById("searchbyname");
	searchbyname.style.display="none";
	var filterbyclass = document.getElementById("filterbyclass");
	filterbyclass.style.display="none";
}

function changeSearch(){
	var val = document.getElementById("changeSearch").value;
	if(val == ""){
		alert("select search by option");
		return false;
	}
	else if(val == "searchbyname"){
		var filterbyclass = document.getElementById("filterbyclass");
		filterbyclass.style.display="none";
		var searchbyname = document.getElementById("searchbyname");
		searchbyname.style.display="block";
		return false;
	}
	else{
		var filterbyclass = document.getElementById("filterbyclass");
		filterbyclass.style.display="block";
		var searchbyname = document.getElementById("searchbyname");
		searchbyname.style.display="none";
		return false;
	}
	
}
</script>
</head>
<body onload="searchstudents()">
<p align="left"><a href="index.html">Home</a></p>	
<center><h3>Search Students</h3>
<div id="searchoption">
		<select name="searchby" id="changeSearch" onchange="changeSearch()">
		<option value="">--Select Search By--</option>
		<option value="searchbyname">Search by Name</option>
		<option value="classwise">Search by Class Wise</option>
		</select>
	
</div>
<pre>
<div id="searchbyname">
<form action="Search" method="post">
<input type="text" name="value" required>
<label><input type="radio" name="column" value="firstname" checked="checked">First Name</label><label><input type="radio" name="column" value="lastname">Last Name</label>
<input type="submit" name="search" value="Search By Name">
</form>
</div>
<div id="filterbyclass">
<form action="Search" method="post">

<select name="class">
<option value="">--Select Class--</option>
<option value="1">1</option>
<option value="2">2</option>
<option value="3">3</option>
<option value="4">4</option>
<option value="5">5</option>
<option value="6">6</option>
<option value="7">7</option>
<option value="8">8</option>
<option value="9">9</option>
<option value="10">10</option>
</select>
<input type="submit" name="search" value="Filter">
</form>
</div>

</pre>
<table align="center" border="1"> 
<tr>
	<th align="center">Name</th>
	<th align="center">Father Name</th>
	<th align="center">Email</th>
	<th align="center">Class</th>
	<th align="center">Age</th>
</tr>
<%
	if(request.getAttribute("student_list")!=null){
		Student st = new Student();
		ArrayList<Student> list = (ArrayList<Student>) request.getAttribute("student_list");
		for(Student student : list){
%>
	<tr>
	<td align="center"><%=student.getFirst_name() %> <%=student.getLast_name() %></td>
	<td align="center"><%=student.getFname() %></td>
	<td align="center"><%=student.getEmail() %></td>
	<td align="center"><%=student.getClass_name() %></td>
	<td align="center"><%=student.getAge() %></td>
	</tr>
<%
		}
		} %>
</table>
</center>
</body>
</html>
