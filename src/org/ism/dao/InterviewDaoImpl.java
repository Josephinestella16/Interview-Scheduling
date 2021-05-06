package org.ism.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.ism.model.Candidate;
import org.ism.model.Interview;
import org.ism.model.Requirement;
//import org.ism.util.DBConstant;
import org.ism.util.DBUtil;

public class InterviewDaoImpl implements InterviewDao{

	@Override
	public boolean checkReq(int id) {
		Connection con=null;
		boolean isPresent=false;
		try {
			con=DBUtil.getConnection();
			if(con!=null)
			{
				Statement s = con.createStatement();
				ResultSet r = s.executeQuery("SELECT COUNT(reqId) AS rowcount FROM interview1.interview WHERE reqId = "+id);
				r.next();
				int count = r.getInt("rowcount") ;
				r.close() ;
				if(count == 0)
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
	@Override
	public List<Candidate> getCandidates(String domain,int exp,int vac){
		Connection con = null;
		List<Candidate> candidates = new ArrayList<>();
		try {
			con=DBUtil.getConnection();
			Statement s = con.createStatement();
			ResultSet result = s.executeQuery("SELECT * FROM candidate WHERE domain = '"+ domain +"' AND yoe >= "+exp+" AND status = "+false+" LIMIT "+(vac*3));
			while(result.next()) {
				Candidate c = new Candidate();
				c.setFirstName(result.getString(1));
				c.setLastName(result.getString(2));
				c.setPassword(result.getString(3));
				c.setDob(result.getString(4));
				c.setAddress(result.getString(5));
				c.setCity(result.getString(6));
				c.setState(result.getString(7));
				c.setPincode(result.getString(8));
				c.setContactNumber(result.getString(9));
				c.setDegree(result.getString(10));
				c.setYop(result.getString(11));
				c.setMarks(result.getString(12));
				c.setEmail(result.getString(13));
				c.setDomain(result.getString(14));
				c.setYoe(result.getInt(15));
				c.setCompanyHistory(result.getString(16));
				c.setRank(result.getString(17));
				c.setJobType(result.getString(18));
				c.setStatus(result.getBoolean(19));
				c.setCandidateNumber(result.getInt(20));
				candidates.add(c);
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
		return candidates;
	}
	@Override
	public Requirement getRequirement(int id) {
		Connection con = null;
		Requirement req = new Requirement();
		try {
			con=DBUtil.getConnection();
			Statement s = con.createStatement();
			ResultSet res = s.executeQuery("SELECT * FROM requirement WHERE reqId = "+id);
			while(res.next()) {
				req.setReqId(res.getInt(1));
				req.setEmployeeId(res.getString(2));
				req.setDomain(res.getString(3));
				req.setVacancies(res.getInt(4));
				req.setClosingDate(res.getString(5));
				req.setPriority(res.getString(6));
				req.setExperience(res.getInt(7));
				req.setMode(res.getString(8));
				req.setRequestDate(res.getString(9));
				
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
		return req;
	}
	
	@Override
	public boolean saveInterview(Interview interview) {
		Connection con = null;
		boolean isSaved = false;
		try {
			con=DBUtil.getConnection();
			if(con!=null) {
				PreparedStatement pst = con.prepareStatement("INSERT INTO interview(interviewId,venue,reqId,interviewDate,rank,candidateName,qualification,status,result) VALUES (?,?,?,?,?,?,?,?,?)");
				pst.setString(1,interview.getInterviewId());
				pst.setString(2,interview.getVenue());
				pst.setInt(3,interview.getReqId());
				pst.setString(4,interview.getInterviewDate());
				pst.setString(5,interview.getRank());
				pst.setString(6,interview.getCandidateName());
				pst.setString(7,interview.getQualification());
				pst.setBoolean(8, interview.isStatus());
				pst.setString(9, interview.getResult());
				int a=pst.executeUpdate();
				//System.out.println(a);
				if(a>0)
					isSaved=true;
			}
		}catch (Exception e) {
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
		
		return isSaved;
	}
	@Override
	public void changeStatus(int id) {
		Connection con = null;
		try {
			con=DBUtil.getConnection();
			if(con!=null) {
				PreparedStatement pst = con.prepareStatement("UPDATE candidate SET status = true WHERE candidateNumber ="+id);
				pst.executeUpdate();
			}
		}catch (Exception e) {
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
	}
	
	@Override
	public boolean isPresent(int id) {
		Connection con=null;
		boolean isPresent=false;
		try {
			con=DBUtil.getConnection();
			if(con!=null)
			{
				PreparedStatement pst = con.prepareStatement("SELECT COUNT(reqId) AS rowcount FROM requirement WHERE reqId = ?");
				pst.setInt(1, id);
				ResultSet r = pst.executeQuery();
				r.next();
				int count = r.getInt("rowcount") ; 
				r.close();
				if(count == 1)
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
	
	@Override
	public boolean isChecked(String id) {
		Connection con=null;
		boolean isMarked=false;
		try {
			con=DBUtil.getConnection();
			if(con!=null)
			{
				PreparedStatement pst = con.prepareStatement("SELECT COUNT(interviewId) AS rowcount FROM interview WHERE interviewId = ? AND status = false");
				pst.setString(1, id);
				ResultSet r = pst.executeQuery();
				r.next();
				int count = r.getInt("rowcount") ; 
				r.close();
				if(count == 1)
					isMarked=true;
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
		return isMarked;
	}
	
	@Override
	public Candidate getCandidateDetail(int id) {
		Connection con = null;
		 
		try {
			con=DBUtil.getConnection();
			Statement s = con.createStatement();
			ResultSet result = s.executeQuery("SELECT * FROM canditate WHERE candidateNumber = "+id);
			Candidate c = new Candidate();
			while(result.next()) {
				c.setFirstName(result.getString(1));
				c.setLastName(result.getString(2));
				c.setPassword(result.getString(3));
				c.setDob(result.getString(4));
				c.setAddress(result.getString(5));
				c.setCity(result.getString(6));
				c.setState(result.getString(7));
				c.setPincode(result.getString(8));
				c.setContactNumber(result.getString(9));
				c.setDegree(result.getString(10));
				c.setYop(result.getString(11));
				c.setMarks(result.getString(12));
				c.setEmail(result.getString(13));
				c.setDomain(result.getString(14));
				c.setYoe(result.getInt(15));
				c.setCompanyHistory(result.getString(16));
				c.setRank(result.getString(17));
				c.setJobType(result.getString(18));
				c.setStatus(result.getBoolean(19));
				c.setCandidateNumber(result.getInt(20));
				return c;
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
		return null;
	}
	@Override
	public void changeStatusToFalse(int id) {
		Connection con = null;
		try {
			con=DBUtil.getConnection();
			if(con!=null) {
				PreparedStatement pst = con.prepareStatement("UPDATE candidate SET status = false WHERE candidateNumber ="+id);
				pst.executeUpdate();
			}
		}catch (Exception e) {
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
	}
	@Override	
	public void updateInterview(String result,String interviewId) {
	Connection con = null;
	try {
		con=DBUtil.getConnection();
		if(con!=null) {
			PreparedStatement pst = con.prepareStatement("UPDATE interview1.interview SET status = true,result ='"+result+"' WHERE interviewId ='"+interviewId+"'");
			int a=pst.executeUpdate();
			System.out.println(a);
		}
	}catch (Exception e) {
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

	}

	@Override
	public void reduceVacancy(int reqId) {
		Connection con = null;
		try {
			con=DBUtil.getConnection();
			if(con!=null) {
				PreparedStatement pst = con.prepareStatement("UPDATE requirement SET vacancy = vacancy-1 WHERE reqId = "+reqId);
				pst.executeUpdate();
			}
		}catch (Exception e) {
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

	}



}
