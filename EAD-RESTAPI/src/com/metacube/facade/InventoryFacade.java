package com.metacube.facade;

import java.util.List;

import com.metacube.DAO.InventoryDAO;
import com.metacube.enums.Status;
import com.metacube.services.Inventory;

public class InventoryFacade {
	
	InventoryDAO inventoryDao = InventoryDAO.getInstance();
	
	public Status insertInventory(String name,Integer quantity) throws Exception{
		return inventoryDao.insertInventory(name, quantity);
	}
	
	public List<Inventory> getAllInventory() throws Exception{
		return inventoryDao.getAllInventory();
	}
	
	public Inventory getInventoryByName(String name) throws Exception{
		return inventoryDao.getInventoryByName(name);
	}
	
	public Status updateInventory(String name,Integer quantity) throws Exception{
		return inventoryDao.updateInventory(name, quantity);
	}
	
	public Status deleteInventory(String name) throws Exception{
		return inventoryDao.deleteInventory(name);
	}
	
	public Status replaceInventory(String name,Inventory inventory) throws Exception{
		return inventoryDao.replaceInventory(name, inventory);
	}
	
	public Status deleteall() throws Exception{
		return inventoryDao.deleteall();
	}

}
