package com.metacube.zoo;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Zoo {

	public static List<Zone> zones = new ArrayList<Zone>();
	public static Scanner input = new Scanner(System.in);
	public static List<String> animals = new ArrayList<String>();

	public static void main(String[] args) {
		animals.add("Lion");
		animals.add("Peacock");
		animals.add("Snake");
		Integer choice = null;

		do {
			System.out.println("1.Add New Zone");
			System.out.println("2.Add New Cage");
			System.out.println("3.Add New Animal");
			System.out.println("4.Delete Animal");
			System.out.println("5.Show detail of Zone");
			System.out.print("Select Your Choice:");
			choice = input.nextInt();
			if (choice == 1) {
				input.nextLine();
				if (AddNewZone()) {
					System.out.println("Zone Added Successfully");
				} else
					System.out.println("Some Error Occur Do Again ");
			} else if (choice == 2) {
				input.nextLine();
				if (AddCage()) {
					System.out.println("Cage Added Successfully");
				} else {
					System.out.println("Cage Not Added");
				}
			} else if(choice == 3){
				if(AddNewAnimal()){
					System.out.println("Animal Added Successfully");
				}else {
					System.out.println("Animal Not Added");
				}
					
			}
			
			System.out.println("--------------------------------------------------------------------");
		} while (choice != 0);

	}

	public static boolean AddNewZone() {
		boolean result = false;
		try {
			System.out.println("New Zone Name:");
			String zoneName = input.nextLine();
			System.out.println("1. Mammal");
			System.out.println("2. Reptile");
			System.out.println("3. Bird");
			System.out.print("Enter Animal Category for zone:");
			Integer categoryid = input.nextInt();
			String category = "";
			if (categoryid == 1)
				category = "Mammal";
			else if (categoryid == 2)
				category = "Reptile";
			else if (categoryid == 3)
				category = "Bird";
			else
				category = null;
			System.out.println("Enter total cages for zone:");
			Integer cages = input.nextInt();
			input.nextLine();
			System.out.println("Zoo has canteen(yes or no):");
			String canteen = input.nextLine();
			System.out.println("Zoo has park(yes or no):");
			String park = input.nextLine();

			boolean hasPark = false, hasCanteen = false;
			if (canteen.equalsIgnoreCase("yes"))
				hasCanteen = true;
			if (park.equalsIgnoreCase("yes"))
				hasPark = true;
			Zone zone = new Zone(zoneName, cages, hasCanteen, hasPark, category);
			if (zone != null) {
				zones.add(zone);
				result = true;
			}
		} catch (Exception ex) {
			result = false;
		}
		return result;
	}

	public static boolean AddCage() {

		System.out.println("Create Cage for");
		System.out.println("1. Mammal");
		System.out.println("2. Reptile");
		System.out.println("3. Bird");
		Integer categoryid = input.nextInt();
		String category = "";
		if (categoryid == 1)
			category = "Mammal";
		else if (categoryid == 2)
			category = "Reptile";
		else if (categoryid == 3)
			category = "Bird";
		List<Zone> availableZones = AvailableSpace(category);
		if (availableZones.size() < 1) {
			System.out.println("No zone available for this type of animals");
			return false;
		}
		System.out.println("Enter cage details:");
		System.out.println("Capacity of cage: ");
		Integer cageCapacity = input.nextInt();
		System.out.println("Select Animal for cage:");
		for (String animal : animals) {
			System.out.println(animal);
		}
		input.nextLine();
		System.out.println("Your Choice:");
		String type = input.nextLine();
		for (Zone zone : zones) {
			System.out.println(zone.zoneId + ". " + zone.getZoneName());
		}
		System.out.println("Select Zone where you want to place cage:");
		Integer zoneid = input.nextInt();

		Cage cage = new Cage(cageCapacity, type, zoneid);
		for (Zone zone : zones) {
			if (zone.zoneId == zoneid) {
				zone.cagesList.add(cage);
			}
		}

		return true;

	}
	
	
	public static boolean AddNewAnimal(){
		System.out.println("Select Animal:");
		for(String animal:animals){
			System.out.println("");
		}
		return true;
		
	}

	public static List<Zone> AvailableSpace(String category) {
		List<Zone> availableZones = new ArrayList<Zone>();

		for (Zone zone : zones) {
			if (zone.animalCategory.equalsIgnoreCase(category)
					&& zone.maximumCages > zone.cagesList.size()) {
				availableZones.add(zone);
			}
		}
		return availableZones;

	}

}
