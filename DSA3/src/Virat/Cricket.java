package Virat;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Cricket {

	/**
	 * @param numberOfBalls  which virat going to play
	 * @param numberOfBowlers
	 * @param ballsForEachBowler[]
	 * 
	 * @return arrangedOrderOfBowlers[] order of bowlers for each balls which virat going to play
	 * i.e. which ball will throw by which bowler
	 * */
	public static int [] findOrderOfBolres(int numberOfBalls,int numberOfBowlers,int ballsForEachBowler[]) throws Exception {

		//for storing arranging of bowler 
		int arrangedOrderOfBowlers[] = new int[numberOfBalls];

		
		/*************Validation checking******************/
		
		//if bowls allocation per baller is incorrect then throw exception
		if(numberOfBowlers!=ballsForEachBowler.length) {
			throw new Exception("bowls allocation per boller is incorrect");
		}


		//adding all the allocated balls that should be equal to numberOfBalls virat going to play
		int sum = 0;
		for(int bowls : ballsForEachBowler) {
			sum+=bowls;
		}

		//if all the allocated balls sum aren't equal to numberOfBalls virat going to play then throw exception
		if(sum!= numberOfBalls) {
			throw new Exception("numberOfBalls and sum of all allocated balls to bowler are not equal");
		}

		/****************************************************/
		

		
		//putting data in hashmap
		//Key is BowlerNumber Value balls associated with that bowler
		HashMap<Integer, Integer> bowlerData = new HashMap<Integer, Integer>();
		int key=0;
		for(int i=0;i<numberOfBowlers;i++) {
			bowlerData.put(++key, ballsForEachBowler[i]);
		}


		int i=0;//for arrangedOrderOfBowlers array
		
		while(numberOfBalls!=0) {
			
			//getting maximum value stored in hashMap
			int maxBalls = Collections.max(bowlerData.values());
			
			for(Map.Entry<Integer, Integer> entry : bowlerData.entrySet()) {
				//if value matches get it's key 
				if(entry.getValue() == maxBalls) {
					int bowlerNumber = entry.getKey();//getting bowlerNumber as it stored as key
					arrangedOrderOfBowlers[i++] = bowlerNumber; //storing order of bowler
					bowlerData.put(bowlerNumber, --maxBalls);//updating number of balls for particular bowler
					numberOfBalls--;//decrementing value of balls 
					break;//after updating all the  information break from this loop 
				}
			}
			
		}
		

		return arrangedOrderOfBowlers;
	}

}