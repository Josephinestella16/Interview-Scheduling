 package org.ism.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.ism.model.Requirement;
//import org.ism.util.DBConstant;
import org.ism.util.DBUtil;

public class RequirementDaoImpl implements RequirementDao{

	@Override
	public boolean register(Requirement req) {
		Connection con=null;
		PreparedStatement pst=null;
		boolean isRegistered=false;
		try {
			con=DBUtil.getConnection();
			if(con!=null)
			{
				pst=con.prepareStatement("insert into requirement(employeeId,domain,vacancy,closingDate,priority,experience,mode,reqDate) values(?,?,?,?,?,?,?,?)");
				pst.setString(1, req.getEmployeeId());
				pst.setString(2,req.getDomain());
				pst.setInt(3,req.getVacancies());
				pst.setString(4,req.getClosingDate());
				pst.setString(5,req.getPriority());
				pst.setInt(6,req.getExperience());
				pst.setString(7,req.getMode());
				pst.setString(8, req.getRequestDate());
				int a=pst.executeUpdate();
				System.out.println(a);
				if(a>0)
					isRegistered=true;
			}
		} catch (Exception e) {
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		return isRegistered;
	}
	
	@Override
	public boolean checkReqId(int num) {
		Connection con=null;
		PreparedStatement pst=null;
		boolean isRegistered=false;
		try {
			con=DBUtil.getConnection();
			if(con!=null)
			{
				pst = con.prepareStatement("SELECT COUNT(reqId) AS rowcount FROM requirement WHERE reqId = ?");
				pst.setInt(1, num);
				ResultSet rs = pst.executeQuery();
				rs.next();
				int count = rs.getInt("rowcount") ;
				rs.close() ;
				if(count>0)
					isRegistered=true;
			}
		} catch (Exception e) {
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		return isRegistered;
	}
	@Override
	public boolean edit(Requirement req,int reqId) {
		Connection con=null;
		PreparedStatement pst=null;
		boolean isRegistered=false;
		try {
			con=DBUtil.getConnection();
			if(con!=null)
			{
				pst=con.prepareStatement("UPDATE requirement SET domain = ?, vacancy = ?, closingDate = ?, priority = ?, experience = ?, mode = ?,employeeId = ? WHERE reqId = ?");
				pst.setString(1, req.getDomain());
				pst.setInt(2,req.getVacancies());
				pst.setString(3,req.getClosingDate());
				pst.setString(4,req.getPriority());
				pst.setInt(5,req.getExperience());
				pst.setString(6,req.getMode());
				pst.setString(7,req.getEmployeeId());
				pst.setInt(8,reqId);
				int a=pst.executeUpdate();
				System.out.println(a);
				if(a>0)
					isRegistered=true;
			}
		} catch (Exception e) {
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		}
		return isRegistered;
	}
}
