package com.google.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.google.vo.UserRoles;
public class MysqlDataObject {
	public static List getConnectionObject(String args) {
		List l =  new ArrayList();
		try{  
			Class.forName("com.mysql.cj.jdbc.Driver");  
			Connection con=DriverManager.getConnection(  
			"jdbc:mysql://localhost:3306/test","root","tiger@123");  
			//here sonoo is database name, root is username and password  
			//Statement stmt=con.createStatement();  
			PreparedStatement stmt=con.prepareStatement("select pg.description,up.role from USER_PRIVILEGES up,privilege_group pg where user_id=(select user_id from user where name=?)\n"
					+ "and pg.privilege_id=up.privilege_group_id;");  
			stmt.setString(1,args);
			ResultSet rs=stmt.executeQuery(); 
			System.out.println("@@@@@@@@@@ rs"+rs);
			
			while(rs.next()) { 
				UserRoles Ur = new UserRoles();
				Ur.setPortalName(rs.getString(1));
				Ur.setRole(rs.getNString(2));
				l.add(Ur);
			System.out.println(rs.getString(1)+"  "+rs.getString(2));
			}
			//return con;
			con.close();
			return l;
			}catch(Exception e){ System.out.println(e);
			return l;
			}  
	}

}
