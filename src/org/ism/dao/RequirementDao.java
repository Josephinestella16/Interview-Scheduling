package org.ism.dao;
import org.ism.model.Requirement;
public interface RequirementDao {
	boolean register(Requirement req);
	boolean checkReqId(int num);
	boolean edit(Requirement req,int reqId);
}
