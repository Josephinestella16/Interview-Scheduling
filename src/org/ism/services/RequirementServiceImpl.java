package org.ism.services;

import org.ism.dao.RequirementDao;
import org.ism.dao.RequirementDaoImpl;
import org.ism.model.Requirement;

public class RequirementServiceImpl implements RequirementService{
	RequirementDao dao = new RequirementDaoImpl();
	@Override
	public boolean addRequirement(Requirement req) {
		boolean flag = dao.register(req);
		return flag;
	}
	@Override
	public boolean editRequirement(int num) {
		boolean flag = dao.checkReqId(num);
		return flag;
	}
	@Override
	public boolean edit(Requirement req,int num) {
		boolean flag = dao.edit(req, num);
		return flag;
	}
}