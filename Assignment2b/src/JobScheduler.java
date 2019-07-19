

import java.util.Scanner;

public class JobScheduler {

	public static void main(String[] args) {
		Integer totalProcess;
		Integer processTimings[][];
		Scanner input=new Scanner(System.in);	
		System.out.print("Enter the Number of Process:");
		totalProcess=input.nextInt();
		processTimings=new Integer[totalProcess][2];
		for(int loop=0;loop<totalProcess;loop++){
			System.out.println("Enter process "+ (loop+1)+" details:");
			System.out.print("Enter Arrival Time:");
			processTimings[loop][0]=input.nextInt();
			System.out.print("Enter Burst Time:");
			processTimings[loop][1]=input.nextInt();	
		}
		Processes process=new Processes(totalProcess, processTimings);
		process.Evaluate();
		process.ShowInfo();
		input.close();
	}


}

