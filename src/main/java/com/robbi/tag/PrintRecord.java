package com.robbi.tag;

import javax.servlet.jsp.JspException;
import javax.servlet.jsp.JspWriter;
import javax.servlet.jsp.tagext.TagSupport;
import java.sql.*;

public class PrintRecord extends TagSupport {
	private String id;
	private String table;


	public void setId(String id) {
		this.id = id;
	}

	public void setTable(String table) {
		this.table = table;
	}

	public int doStartTag() throws JspException {
		JspWriter out = pageContext.getOut();
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
			
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/hybris5", "root", "hybrisdb");
			PreparedStatement ps = con.prepareStatement("select * from " + table + " where PK=?");
			ps.setLong(1,Long.parseLong(id));
			
			ResultSet rs = ps.executeQuery();
			if (rs != null) {
				ResultSetMetaData rsmd = rs.getMetaData();
				int totalcols = rsmd.getColumnCount();
				// column name
				out.write("<table border='1'>");
				out.write("<tr>");
				for (int i = 1; i <= totalcols; i++) {
					out.write("<th style=\"font-size: 10px;\">" + rsmd.getColumnName(i) + "</th>");
				}
				out.write("</tr>");
				// column value

				if (rs.next()) {
					out.write("<tr>");
					for (int i = 1; i <= totalcols; i++) {
						out.write("<td style=\"font-size: 10px;\">" + rs.getString(i) + "</td>");
					}
					out.write("</tr>");

				} else {
					out.write("Table or Id doesn't exist");
				}
				out.write("</table>");

			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
		return SKIP_BODY;
	}
}