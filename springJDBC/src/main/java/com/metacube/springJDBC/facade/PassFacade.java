package com.metacube.springJDBC.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.metacube.springJDBC.dao.PassDAO;
import com.metacube.springJDBC.entities.Pass;

@Service
public class PassFacade {
	
	@Autowired
	PassDAO passDao;
	
	public Integer insertPass(Pass pass) throws Exception{
		return passDao.insertPass(pass);
	}
	

}
