package lab_1;
import java.util.*;
public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Type in your message: ");
		String text = keyboard.nextLine();
		Map<Character,Integer > letters = get_frequency(text);
		Iterator<Character> keySetIterator = letters.keySet().iterator();

		while(keySetIterator.hasNext()){
		  Character key = keySetIterator.next();
		  System.out.println("key: " + key + " value: " + letters.get(key));
		}
		Map<Character,Integer > sortedLetters = sort(letters, text.length());
		
		Iterator<Character> keySortedIterator = sortedLetters.keySet().iterator();
		System.out.println(" ");
		while(keySortedIterator.hasNext()){
		  Character key = keySortedIterator.next();
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
	public static Map<Character,Integer> sort(Map<Character,Integer> letters, int size){
		Map<Character,Integer> sortedLetters = new Hashtable<Character,Integer>();
		int minimalvalue;
		char minimalkey;
		int i = 0;
		System.out.println(letters.size());
		while(!letters.isEmpty()&&i<50){
			Iterator<Character> keySetIterator = letters.keySet().iterator();
			minimalvalue=size;
			minimalkey='?';
			while(keySetIterator.hasNext()){
				
				  Character key = keySetIterator.next();
				  if (letters.get(key)<minimalvalue){
					  minimalvalue=letters.get(key);
					  minimalkey=key;
				  }
			}
			System.out.println(minimalvalue);
			sortedLetters.put(minimalkey, minimalvalue); 
			letters.remove(minimalkey);
			i++;
		}
		
		return sortedLetters;
	}

}
