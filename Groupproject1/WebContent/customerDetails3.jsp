<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"
	import="java.util.List ,adminaddexchangepoint.arrPojo  "%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


	<h2 align="center" >Package Details</h2>

	Customer saved successfully .. Please note customer Id is
	<%=request.getAttribute("consignmentid")%>


	
	<%!List<arrPojo> clist = null;%>

	<%
		clist = (List<arrPojo>) request.getAttribute("cusList");
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
			
		</tr>
		<%
			for (arrPojo arrPojo : clist) {
		%>
		<tr>
			
			<td><%=arrPojo.getName()%></td>
			<td><%=arrPojo.getPhnumber()%></td>
						<td><%=arrPojo.getWeight()%></td>
			<td><%=arrPojo.getFromcity()%></td>
			<td><%=arrPojo.getTocity()%></td>
				<td><%=arrPojo.getAccepteddate()%></td>
				<td><%=arrPojo.getCost()%></td>
				<td><%=arrPojo.getConsignmentid()%></td>
				
			
		</tr>
		<%
			}
		%>




	</table>


</body>
</html>