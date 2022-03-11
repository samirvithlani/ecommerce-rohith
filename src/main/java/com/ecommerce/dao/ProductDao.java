package com.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ecommerce.bean.ProductBean;
import com.ecommerce.util.DBConnection;

public class ProductDao {

	public List<ProductBean> searchList(String name) {

		List<ProductBean> list = new ArrayList<ProductBean>();
		Connection conn = DBConnection.getConnection();
		if (conn != null) {

			String searchSQl = "select * from product natural join category where pname = ?";
			try {
				PreparedStatement pstmt = conn.prepareStatement(searchSQl);
				pstmt.setString(1, name);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {

					ProductBean productBean = new ProductBean();
					productBean.setpId(rs.getInt("pid"));
					productBean.setpName(rs.getString("pname"));
					productBean.setpPrice(rs.getInt("pprice"));
					productBean.setcId(rs.getInt("cid"));
					productBean.setpDescription(rs.getString("pdescription"));
					productBean.setcName(rs.getString("cname"));
					list.add(productBean);
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return list;
	}

	public boolean addProduct(ProductBean productBean) {

		boolean flag = false;
		Connection conn = DBConnection.getConnection();
		if (conn != null) {

			String insertSQl = "insert into product(pname,pprice,pdescription,cid)values(?,?,?,?)";
			try {
				PreparedStatement pstmt = conn.prepareStatement(insertSQl);
				pstmt.setString(1, productBean.getpName());
				pstmt.setInt(2, productBean.getpPrice());
				pstmt.setString(3, productBean.getpDescription());
				pstmt.setInt(4, productBean.getcId());

				int res = pstmt.executeUpdate();
				if (res > 0) {

					flag = true;
				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return flag;
	}

	public List<ProductBean> listofProducts() {

		List<ProductBean> productlist = new ArrayList<ProductBean>();

		Connection conn = DBConnection.getConnection();
		if (conn != null) {

			String selectSQl = "select * from product natural join category";
			try {
				PreparedStatement pstmt = conn.prepareStatement(selectSQl);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {
					ProductBean productBean = new ProductBean();
					productBean.setpId(rs.getInt("pid"));
					productBean.setpName(rs.getString("pname"));
					productBean.setpPrice(rs.getInt("pprice"));
					productBean.setcId(rs.getInt("cid"));
					productBean.setpDescription(rs.getString("pdescription"));
					productBean.setcName(rs.getString("cname"));
					productlist.add(productBean);

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return productlist;
	}
	
}
