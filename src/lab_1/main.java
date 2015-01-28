package lab_1;
import java.util.*;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Type in your message: ");
		String text = keyboard.nextLine();
		Map<Character,Integer> letters = get_frequency(text);
		Iterator<Character> keySetIterator = letters.keySet().iterator();

		while(keySetIterator.hasNext()){
		  Character key = keySetIterator.next();
		  System.out.println("key: " + key + " value: " + letters.get(key));
		}
		
		
	}
	
	public static Map<Character,Integer> get_frequency(String text){
		Map<Character,Integer> letters = new Hashtable<Character,Integer>();
		for (int i=0; i<text.length(); i++){
			 if (letters.containsKey(text.charAt(i))){
				 letters.put(text.charAt(i), letters.get(text.charAt(i))+1);
			 }
			 else {
				 letters.put(text.charAt(i), 1);
			 }
		}
		
		return letters;
	}

}
