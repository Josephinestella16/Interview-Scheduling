package org.ism.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.ism.model.Candidate;
//import org.ism.util.DBConstant;
import org.ism.util.DBUtil;

public class CandidateDaoImpl implements CandidateDao{
	@Override
	public boolean register(Candidate candidate) {
		Connection con=null;
		PreparedStatement pst=null;
		boolean isRegistered=false;
		try {
			con=DBUtil.getConnection();
			if(con!=null)
			{
				pst=con.prepareStatement("insert into candidate(firstname,lastname,password,dob,address,city,state,pincode,phone,degree,yop,marks,email,domain,yoe,companyHistory,rank,job,status) values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
				pst.setString(1, candidate.getFirstName());
				pst.setString(2, candidate.getLastName());
				pst.setString(3, candidate.getPassword());
				pst.setString(4, candidate.getDob());
				pst.setString(5, candidate.getAddress());
				pst.setString(6, candidate.getCity());
				pst.setString(7, candidate.getState());
				pst.setString(8, candidate.getPincode());
				pst.setString(9, candidate.getContactNumber());
				pst.setString(10, candidate.getDegree());
				pst.setString(11, candidate.getYop());
				pst.setString(12, candidate.getMarks());
				pst.setString(13, candidate.getEmail());
				pst.setString(14, candidate.getDomain());
				pst.setInt(15, candidate.getYoe());
				pst.setString(16, candidate.getCompanyHistory());
				pst.setString(17, candidate.getRank());
				pst.setString(18, candidate.getJobType());
				pst.setBoolean(19, candidate.isStatus());
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
	public boolean isMailPresent(String email) {
		Connection con=null;
		PreparedStatement pst=null;
		boolean isPresent=false;
		try {
			con=DBUtil.getConnection();
			if(con!=null)
			{
				pst=con.prepareStatement("SELECT COUNT(email) AS rowcount FROM candidate WHERE email = ?");
				pst.setString(1,email);
				ResultSet rs=pst.executeQuery();
				rs.next();
				int count=rs.getInt("rowcount");
				rs.close();
				if(count==0)
					isPresent=true;
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
		return isPresent;
	}
	}


