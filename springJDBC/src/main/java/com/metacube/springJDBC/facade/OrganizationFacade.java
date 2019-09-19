package com.metacube.springJDBC.facade;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.metacube.springJDBC.dao.OrganizationDAO;
import com.metacube.springJDBC.entities.Organization;


@Service
public class OrganizationFacade {

	@Autowired
	OrganizationDAO orgDao;
	
	public Organization getOrganization(Integer id) throws Exception{
		return orgDao.getOrganization(id);
	}
	
	public List<Organization> getAllOrganization() throws Exception{
		return orgDao.getAllOrganization();
	}
}
