package com.ecommerce.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ecommerce.bean.ProductBean;
import com.ecommerce.dao.ProductDao;

/**
 * Servlet implementation class InsertProductController
 */
public class InsertProductController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String pName = request.getParameter("txtProductName");
		String price = request.getParameter("txtProductPrice");
		int pPrice = 0;
		if (price != null || !price.equals("")) {

			pPrice = Integer.parseInt(price);
		}
		String pDescription = request.getParameter("txtProductDescription");
		int cId = Integer.parseInt(request.getParameter("cid"));

		ProductBean productBean = new ProductBean();
		productBean.setpName(pName);
		productBean.setpPrice(pPrice);
		productBean.setcId(cId);
		productBean.setpDescription(pDescription);

		ProductDao productDao = new ProductDao();
		boolean flag = productDao.addProduct(productBean);
		if (flag == true) {

			response.sendRedirect("productlistcontroller");
		} else {
			response.sendError(500);
		}

		doGet(request, response);
	}

}
