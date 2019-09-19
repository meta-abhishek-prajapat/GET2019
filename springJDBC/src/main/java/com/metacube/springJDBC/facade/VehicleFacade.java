package com.metacube.springJDBC.facade;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.metacube.springJDBC.dao.VehicleDAO;
import com.metacube.springJDBC.entities.Vehicle;

@Service
public class VehicleFacade {
	
	@Autowired
	VehicleDAO vehicleDao;
	
	public  Integer insertVehicle(Vehicle vehicle) throws Exception{
		return vehicleDao.insertVehicle(vehicle);
	}
	
	public  Integer getlastInsertedVehicleId() throws Exception{
		return vehicleDao.getlastInsertedVehicleId();
	}

}
