package com.metacube.dbms;

import java.util.ArrayList;
import java.util.List;

public class MainClass {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StoreFront sf = new StoreFront();
		sf.fetchOrders(1);
		List<String> listOfImages=new ArrayList<>();
        listOfImages.add("shirt1.jpg");
        listOfImages.add("shirt2.jpg");
        listOfImages.add("shirt3.jpg");
        listOfImages.add("shirt4.jpg");
        listOfImages.add("shirt5.jpg");
        sf.addImage(1, listOfImages);
        
        int numOfInactives=sf.setInactive();
        System.out.print("Number of inactives= " + numOfInactives);
        
        sf.showCategories();
	}

}
