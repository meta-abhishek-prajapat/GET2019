package com.metacube.zoo;

import java.util.ArrayList;
import java.util.List;

public class Zone {
	
	private static Integer newId=0;
	public static Integer getNewId() {
		return newId;
	}
	public static void setNewId(Integer newId) {
		Zone.newId = newId;
	}
	public String getZoneName() {
		return zoneName;
	}
	public void setZoneName(String zoneName) {
		this.zoneName = zoneName;
	}
	public Integer zoneId;
	private String zoneName;
	public Integer maximumCages;
	private boolean hasCanteen;
	private boolean hasPark;
	public String animalCategory;
	public List<Cage> cagesList=new ArrayList<Cage>();
	public Zone(String zoneName,Integer maximumCages, boolean hasCanteen, boolean hasPark,String animalCategory) {
		newId++;
		this.zoneId=newId;
		this.zoneName=zoneName;
		this.maximumCages = maximumCages;
		this.hasCanteen = hasCanteen;
		this.hasPark = hasPark;
		this.animalCategory = animalCategory;
	}
	public List<Cage> getCagesList() {
		return cagesList;
	}
	public void setCagesList(List<Cage> cagesList) {
		this.cagesList = cagesList;
	}
	
	

}
