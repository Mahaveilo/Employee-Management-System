package dao;

import java.sql.*;

import dbc.*;
import model.*;

public class EmployeeDao {
	// constructor, create new connection
	private Connection conn;
	public EmployeeDao() {
		conn = DBconn.getConn();
	}
	
	public void updateRequest(UpdateReq updateReq) {
		// generate the update information, similar as insert a new record in UpdateReq table
		try {
			PreparedStatement ps = conn.prepareStatement("insert into updatereq (ename, password, address, phonenum, imgpath, eid) values (?, ?, ?, ?, ?, ?)");
			ps.setString(1, updateReq.geteName());
			ps.setString(2, updateReq.getPassword());
			ps.setString(3, updateReq.getAddress());
			ps.setString(4, updateReq.getPhoneNum());
			ps.setString(5, updateReq.getImgPath());
			ps.setInt(6, updateReq.getEid());
			ps.executeUpdate();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			DBconn.close(conn);
		}
	}
}
