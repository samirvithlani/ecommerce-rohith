<%@page import="com.ecommerce.bean.ProductBean"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1" isELIgnored="false"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
hello
	<table style="border: solid; color: red;">
		<tr>
			<th>PRODUCT ID</th>
			<th>PRODUCT NAME</th>
			<th>PRODUCT PRICE</th>
			<th>PRODUCT DESC</th>
			<th>PRODUCT Categoty</th>
		</tr>

		<%-- <%
			List<ProductBean> productList = (List<ProductBean>) request.getAttribute("products");

		for (int i = 0; i < productList.size(); i++) {
			ProductBean productBean = productList.get(i);
		%>

		<tr>
			<td><%=productBean.getcId()%></td>
			<td><%=productBean.getpName()%></td>
			<td><%=productBean.getpPrice()%></td>
			<td><%=productBean.getpDescription()%></td>
			<td><%=productBean.getcName()%></td>
		</tr>


		<%
			}
		%> --%>
		<c:forEach var="products"  items="${products}">
		<tr>
		
		 <td>${products.pId }</td>
		<td>${products.pName }</td>
		<td>${products.pPrice }</td>
		<td>${products.pDescription }</td>
		<td>${products.cName }</td>
		</tr>
		
		</c:forEach>

	</table>
</body>
</html>