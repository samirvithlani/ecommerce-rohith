package com.ecommerce.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ecommerce.bean.CategoryBean;
import com.ecommerce.util.DBConnection;

public class CategoryDao {

	public List<CategoryBean> categories() {

		List<CategoryBean> listofCategories = new ArrayList<CategoryBean>();
		Connection conn = DBConnection.getConnection();
		if (conn != null) {

			String selectSQl = "select * from category";
			try {
				PreparedStatement pstmt = conn.prepareStatement(selectSQl);
				ResultSet rs = pstmt.executeQuery();
				while (rs.next()) {

					CategoryBean categoryBean = new CategoryBean();
					categoryBean.setcId(rs.getInt("cid"));
					categoryBean.setcName(rs.getString("cname"));
					listofCategories.add(categoryBean);

				}

			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

		return listofCategories;
	}
}
