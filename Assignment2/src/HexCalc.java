import java.util.Scanner;

public class HexCalc {
	
	
	public static Integer base=16;
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner input = new Scanner(System.in);
		
		Integer choice=null;
		System.out.println("Enter HexaDacimal Number1:");
		String number1=input.next();
		
		System.out.println("Enter HexaDacimal Number2:");
		String number2=input.next();
		
		number1=number1.toUpperCase();
		number2=number2.toUpperCase();
		
		do{
			
			System.out.println("Select Option: ");
			System.out.println("1. Arithmetic ");
			System.out.println("2. Compare");
			System.out.println("0. Exit");
			System.out.println("Ënter Your Choice:");
			choice=input.nextInt();
			if(choice==1)
			{
				Arithmetic arithmetic=new Arithmetic();
				System.out.println("Choice Arithmetic Expression");
				
				System.out.println("1. Addition ");
				System.out.println("2. Subtraction");
				System.out.println("3. Multiply");
				System.out.println("4. Divide");
				System.out.println("Choice Option: ");
				Integer option=input.nextInt();
				if(option == 1){
					String hexAddtion=arithmetic.Addition(number1,number2);
					System.out.println("Addition is "+hexAddtion);
				}
				else if(option == 2){
					String hexSubraction=arithmetic.Subtraction(number1,number2);
					System.out.println("Subtraction is "+hexSubraction);
				}
				else if(option == 3){
					String hexMultiply=arithmetic.Multiply(number1,number2);
					System.out.println("Multiply is "+hexMultiply);
				}
				else if(option == 4){
					String hexDivision=arithmetic.Division(number1,number2);
					System.out.println("Division is "+hexDivision);
				}
				else{
					System.out.println("Wrong Option");
				}
			}
			else if(choice==2){
				Comparison compare=new Comparison();
				System.out.println("Choice Comparison Opertor");
				System.out.println("1. EqualTo(==) ");
				System.out.println("2. Greater Than (>)");
				System.out.println("3. Less Than (<)");
				System.out.println("Choice Option: ");
				Integer option=input.nextInt();
				
				if(option==1){
					if(compare.EqualTo(number1,number2))
						System.out.println("Hexadecimal Number are equal");
					else
						System.out.println("Not Equal");
					
				}
				else if(option==2){
					if(compare.GreaterThan(number1,number2))
						System.out.println("Number 1 is Greater");
					else
						System.out.println("Number 1 is not Greater");
					
				}
				else if(option==3){
					if(compare.LessThan(number1,number2))
						System.out.println("Number 1 is Smaller");
					else
						System.out.println("Number 1 is not Smaller");
				}
						
				
			}
			
			
			
		}while(choice!=0);
		
		
		
	}
		
	
}
