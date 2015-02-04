package lab_1;

import java.util.*;

public class main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner keyboard = new Scanner(System.in);
		System.out.println("Type in your message: ");
		String text = keyboard.nextLine();
		Map<Integer, Integer> letters = get_frequency(text);
		Iterator<Integer> keySetIterator = letters.keySet().iterator();

		while (keySetIterator.hasNext()) {
			int key = keySetIterator.next();
			System.out.println("key: " + key + " value: " + letters.get(key));
		}
		int size = letters.size();
		Tree theTree = new Tree();

		for (int i = 0; i < size; i++) {
			int minimal_key = get_minimum_key(letters, text.length());
			

			letters.remove(minimal_key);
			//System.out.println(minimal_key + " " + (int) minimal_key);
		}
		theTree.displayTree();

	}

	public static Map<Integer, Integer> get_frequency(String text) {
		Map<Integer, Integer> letters = new Hashtable<Integer, Integer>();
		for (int i = 0; i < text.length(); i++) {

			if (letters.containsKey((int) text.charAt(i))) {
				letters.put((int) text.charAt(i),
						letters.get((int) text.charAt(i)) + 1);
			} else {
				letters.put((int) text.charAt(i), 1);
			}
		}
		return letters;
	}

	public static int get_minimum_key(Map<Integer, Integer> letters, int size) {
		int minimalvalue = size;
		int minimalkey = 20;
		Iterator<Integer> keySetIterator = letters.keySet().iterator();

		while (keySetIterator.hasNext()) {

			int key = keySetIterator.next();
			if (letters.get(key) < minimalvalue) {
				minimalvalue = letters.get(key);
				minimalkey = key;
			}
		}
		// System.out.println("Minimal key = " + minimalkey);
		return minimalkey;

	}
	/*
	 * public static Map<Character,Integer> sort(Map<Character,Integer> letters,
	 * int size){ Map<Character,Integer> sortedLetters = new
	 * Hashtable<Character,Integer>(); int minimalvalue; char minimalkey; int i
	 * = 0; System.out.println(letters.size()); while(!letters.isEmpty()&&i<50){
	 * Iterator<Character> keySetIterator = letters.keySet().iterator();
	 * minimalvalue=size; minimalkey='?'; while(keySetIterator.hasNext()){
	 * 
	 * Character key = keySetIterator.next(); if
	 * (letters.get(key)<minimalvalue){ minimalvalue=letters.get(key);
	 * minimalkey=key; } } System.out.println(minimalvalue);
	 * sortedLetters.put(minimalkey, minimalvalue); letters.remove(minimalkey);
	 * i++; }
	 * 
	 * return sortedLetters; }
	 */

}
