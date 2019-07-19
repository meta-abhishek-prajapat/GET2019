
public class Arithmetic {

	
	public static String hexaDecimals="0123456789ABCDEF";
	
	
	public  String Addition(String number1,String number2){
		Integer num1=HexaToDecimal(number1);
		Integer num2=HexaToDecimal(number2);
		return DecimalToHexa(num1+num2);
		
	}
	
	public String Subtraction(String number1,String number2){
		Integer num1=HexaToDecimal(number1);
		Integer num2=HexaToDecimal(number2);
		return DecimalToHexa(num1-num2);
		
	}
	

	public String Division(String number1, String number2) {
		// TODO Auto-generated method stub
		Integer num1=HexaToDecimal(number1);
		Integer num2=HexaToDecimal(number2);
		return DecimalToHexa(num1/num2);
	}



	public String Multiply(String number1, String number2) {
		// TODO Auto-generated method stub
		Integer num1=HexaToDecimal(number1);
		Integer num2=HexaToDecimal(number2);
		return DecimalToHexa(num1*num2);
	}
	
	
	
	public static Integer HexaToDecimal(String hexaNumber){
		
		Integer decimalNumber=0,loop,position=0;
		Integer length=hexaNumber.length()-1;
		for(loop=length;loop>=0;loop--){
			
			char ch = hexaNumber.charAt(loop);
			decimalNumber=decimalNumber + ((Power(16,position)) * hexaDecimals.indexOf(ch));
			position++;
		}
		return decimalNumber;
		
	}
	
	
	public static String DecimalToHexa(Integer decimalNumber){
		String hexaNumber="";
		while(decimalNumber>0){
			Integer mode = decimalNumber%16;
			char hexa=hexaDecimals.charAt(mode);
			hexaNumber=(Character.toString(hexa))+hexaNumber;
			decimalNumber=decimalNumber/16;
		}
		return hexaNumber;
		
	}
	
	public static Integer Power(Integer number,Integer power){
		
		if(power==0)
			return 1;
		else
		{
			Integer result=1;
			while(power!=0){
				result*=number;
				power--;
			}
			return result;
		}
				
	}
	
	
}
