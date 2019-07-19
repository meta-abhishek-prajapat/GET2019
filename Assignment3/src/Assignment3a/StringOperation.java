package Assignment3a;

import java.util.ArrayList;
import java.util.List;

public class StringOperation {
	
	 	/**
	 	 * Compare Two Strings.
	 	 * @param first string.
	 	 * @param second string.
	 	 * @return return 0 if strings are equal otherwise return 0.
	 	 */
		public Integer CompareStrings(String first,String second){
				if(first.length()!=second.length()){
					return 0;
				}
				else
				{
					Integer length=first.length();
					Integer loop=0;
					while(loop<length){
						if(first.charAt(loop)!=second.charAt(loop)){
							return 0;
						}
						loop++;
					}
					return 1;
				}
		}
		
		/**
		 * Reverse the String
		 * @param string
		 * @return reverse of string
		 */
		public String ReverseString(String string){
				String revString="";
				Integer length=string.length()-1;
				while(length>=0){
					revString=revString+Character.toString(string.charAt(length));
					length--;
				}
				return revString;
		}

		/**
		 * Toggle the String convert uppercase into lowercase and vice versa
		 * @param string
		 * @return toggle string
		 */
		public String ToggleString(String string){
				Integer length=string.length();
				String toggleString="";
				char ch;
				for(int loop=0;loop<length;loop++){
					ch=string.charAt(loop);
					if(CheckLowerCase(ch)){
						ch=Character.toUpperCase(ch);
						toggleString=toggleString+Character.toString(ch);
					}
					else if(CheckUpperCase(ch)){
						ch=Character.toLowerCase(ch);
						toggleString=toggleString+Character.toString(ch);
					}
					else
						toggleString=toggleString+Character.toString(ch);

				}
				return toggleString;
		}

		/**
		 * Find the largest word in the String
		 * @param string 
		 * @return largestWord present in the String
		 */
		public String LargestWord(String string){
				String largestWord="";
				Integer wordLength=0;
				List<String> words=SplitWords(string);
				for(String str:words){
					if(wordLength<=(str.length())){
						largestWord=str;
						wordLength=str.length();
					}
				}
				return largestWord;
		}

		public static boolean CheckLowerCase(char ch){
			
			if(ch>=65 && ch<=90)
				return false;
			else
				return true;
			
		}
		
		public static boolean CheckUpperCase(char ch){
			
			if(ch>=65 && ch<=90)
				return true;
			else
				return false;
			
		}
		
		/**
		 * Make list of words present in string
		 * @param string
		 * @return list of words
		 */
		public static List<String> SplitWords(String string){
			Integer length=string.length();
			List<String> words = new ArrayList<String>();
			String word="";
			Integer loop=0;
			while(loop<length){
				while( loop<length && string.charAt(loop)==' '){
					loop++;
				}
				word="";
				while(loop<length && string.charAt(loop)!=' '){
					word=word+Character.toString(string.charAt(loop));
					loop++;
				}
				words.add(word);
			}
			return words;
		}	
}
