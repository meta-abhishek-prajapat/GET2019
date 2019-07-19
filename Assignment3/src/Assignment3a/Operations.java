package Assignment3a;

import java.util.Scanner;

public class Operations {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			Scanner input = new Scanner(System.in);
			String first;
			Integer choice = null;
			do{
				StringOperation operation=new StringOperation();
				System.out.println("1.Compare Two String\n2.Reverse String\n3.Toggle String\n4.Largest Word\n0.Exit");
				choice=input.nextInt();
				first=input.nextLine();
				if(choice==1){
					System.out.println("Enter String 1:");
					first=input.nextLine();
					input.reset();
					System.out.println("Enter String 2:");
					String second=input.nextLine();
					input.reset();
					if(operation.CompareStrings(first, second)==1){
						System.out.println("String are Equals");
					}
					else
						System.out.println("Not Matched");
				}
				else if(choice==2){
					System.out.println("Enter String : ");
					first=input.nextLine();
					input.reset();
					System.out.println("Reverse String : "+operation.ReverseString(first));
				}
				else if(choice==3){
					System.out.println("Enter String : ");
					first=input.nextLine();
					input.reset();
					System.out.println("Toggle String : "+operation.ToggleString(first));
				}
				else if(choice==4){
					System.out.println("Enter String : ");
					first=input.nextLine();
					input.reset();
					System.out.println("Largest Word : "+operation.LargestWord(first));
				}
				else if(choice==0)
					break;
				else
					System.out.println("Wrong Choice do again");

				System.out.println("---------------------------------------------------------");
		}while(choice!=0);
		}

}


