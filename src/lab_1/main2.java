package lab_1;

import java.util.*;

public class main2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Type in your message: ");
		String text = keyboard.nextLine();
		Map<String, Integer> letters = get_frequency(text);
		Iterator<String> keySetIterator = letters.keySet().iterator();

		while (keySetIterator.hasNext()) {
			String key = keySetIterator.next();
			System.out.println("key: " + key + " value: " + letters.get(key));
		}
		int size = letters.size();
		Tree theTree = new Tree();
		String newKey;
		for (int i = 0; i < size; i++) {
			String minimal_key = get_minimum_key(letters, text.length());
			int frequency = letters.get(minimal_key);
			letters.remove(minimal_key);
			String minimal_key2 = get_minimum_key(letters, text.length());
			int frequency2 = letters.get(minimal_key2);
			letters.remove(minimal_key2);
			newKey = combine_keys(minimal_key, minimal_key2);
			System.out.println(newKey);
			letters.put(newKey, frequency+frequency2);
			
			//System.out.println(minimal_key + " " + (int) minimal_key);
		}
		//theTree.displayTree();

	}
	public static String combine_keys(String a, String b){
		System.out.println("a= " +a+" b= "+b);
		return a+b;
	}

	public static Map<String, Integer> get_frequency(String text) {
		Map<String, Integer> letters = new Hashtable<String, Integer>();
		for (int i = 0; i < text.length(); i++) {

			if (letters.containsKey(text.charAt(i)+"")) {
				//System.out.println(letters.get(text.charAt(i)+""));
				letters.put(text.charAt(i)+"",
						letters.get(text.charAt(i)+"") + 1);
			} else {
				letters.put(text.charAt(i)+"", 1);
			}
		}
		return letters;
	}

	public static String get_minimum_key(Map<String, Integer> letters, int size) {
		int minimalvalue = size;
		String minimalkey = "?";
		Iterator<String> keySetIterator = letters.keySet().iterator();

		while (keySetIterator.hasNext()) {

			String key = keySetIterator.next();
			if (letters.get(key) < minimalvalue) {
				minimalvalue = letters.get(key);
				minimalkey = key;
			}
		}
		// System.out.println("Minimal key = " + minimalkey);
		return minimalkey;

	}
	
}
