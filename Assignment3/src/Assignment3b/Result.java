package Assignment3b;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Result {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner input=new Scanner(System.in);
		List<Marksheet> marksheet=new ArrayList<Marksheet>();
		Integer total;
		Double grade;
		System.out.println("Enter total number of grades:");
		total=input.nextInt();
		for(int loop=0;loop<total;loop++){
			System.out.println("Enter grade : ");
			grade=input.nextDouble();
			Marksheet mark=new Marksheet(grade);
			if(grade>100 || grade<0){
				System.out.println("Invalid Grade.Enter Again");
				loop--;
			}
			else	
			marksheet.add(mark);
		}
		Marksheet result=new Marksheet();
		System.out.println("Average of grades : "+String.format("%.2f", result.AverageGrade(marksheet)));
		System.out.println("Maximum grades : "+String.format("%.2f",result.MaxGrade(marksheet)));
		System.out.println("Minimum grades : "+String.format("%.2f",result.MinGrade(marksheet)));
		System.out.println("Percentage student Passed : "+String.format("%.2f",result.StudentPassed(marksheet)));

		}

}
