<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.List ,Search1.CusPojo  "%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<style>

</style>
</head>
<body bgcolor=#c0c0c0>

	<h2 align="center">Package Details</h2>



	
	<%!List<CusPojo> clist = null;%>

	<%
		clist = (List<CusPojo>) request.getAttribute("cusList");
	%>

	<br>



	<table border="1">
		<tr>
			<th>Name</th>
			<th>number</th>
			<th>weight</th>
			<th>from city</th>
			<th>to city</th>
			<th>date</th>
			<th>cost</th>
			<th>id</th>
			<th>Exchange point</th>
			<th>date</th>
		</tr>
		<%
			for (CusPojo cusPojo : clist) {
		%>
		<tr>
			
			<td><%=cusPojo.getName()%></td>
			<td><%=cusPojo.getPhno()%></td>
			<td><%=cusPojo.getWeight()%></td>
			<td><%=cusPojo.getFcity()%></td>
			<td><%=cusPojo.getTcity()%></td>
				<td><%=cusPojo.getAdate()%></td>
				<td><%=cusPojo.getCost()%></td>
				<td><%=cusPojo.getCid()%></td>
				<td><%=cusPojo.getCexp()%></td>
				<td><%=cusPojo.getDate1()%></td>
			
		</tr>
		<%
			}
		%>




	</table>
	<br> <br>
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;

&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;


<input type="submit" value="Logout" onclick="location.href='SendCourier.html'">
</body>
</html>