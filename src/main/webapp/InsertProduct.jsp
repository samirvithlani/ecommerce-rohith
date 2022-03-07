<%@page import="com.ecommerce.bean.CategoryBean"%>
<%@page import="java.util.List"%>
<%@page import="com.ecommerce.dao.CategoryDao"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
<%@include file="base.jsp"%>
</head>
<body>

	<form action="insertproductcontroller" method="post">
		<div class="form-group">
			<label for="exampleInputEmail1">Product Name</label> <input
				type="text" class="form-control" placeholder="Enter product Name"
				name="txtProductName">
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">Product Price</label> <input
				type="text" class="form-control" placeholder="Enter product price"
				name="txtProductPrice">
		</div>
		<div class="form-group">
			<label for="exampleInputEmail1">Product Description</label> <input
				type="text" class="form-control"
				placeholder="Enter product descripton" name="txtProductDescription">
		</div>



		<div class="form-group">
			<select class="form-control form-control-lg" name="cid">
				<%
					CategoryDao categoryDao = new CategoryDao();
				List<CategoryBean> listofCategories = categoryDao.categories();
				for (int i = 0; i < listofCategories.size(); i++) {

					CategoryBean categoryBean = listofCategories.get(i);
				%>
				<option value="<%=categoryBean.getcId()%>"><%=categoryBean.getcName()%></option>
				<%
					}
				%>
			</select>
		</div>




		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
</body>
</html>