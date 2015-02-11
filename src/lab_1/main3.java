package lab_1;
import java.io.*;
import java.util.*; 
import static lab_1.TreeApp.getChar;


public class main3 {

	public static void main(String[] args) throws IOException {
            
            Map<String, Integer> letters = null;
            String text = null;
            Tree theTree = new Tree();
            Node[] nodeArray = null;
            int minNodeLoc = -1;
            Map<String, Character> codeArray = null;
            
            while (true) {
                System.out.print("Enter first letter of ");
                System.out.print("enter, show, code, decode, or finish: ");
                int choice = getChar();
                Scanner keyboard = new Scanner(System.in);
                switch (choice) {
                    case 'e':
                    	System.out.println(
        						"Enter text lines, terminate with $");
        				text = getText();
        				System.out.println("pass");
                        letters = get_frequency(text);
                        Iterator<String> keySetIterator = letters.keySet().iterator();
                        while (keySetIterator.hasNext()) {
                            String key = keySetIterator.next();
                            System.out.println("key: " + key + " value: " + letters.get(key));
                        }
                        int size = letters.size();
                        nodeArray = theTree.makeArray(letters);
                        String newKey;

                        for (int i = 0; i < size - 1; i++) {
                            String minimal_key = get_minimum_key(letters, text.length());
                            int frequency = letters.get(minimal_key);
                            Node minNode1 = new Node();
                            minNodeLoc = -1;
                            for (int i1 = 0; i1 < nodeArray.length; i1++) {
                                if (nodeArray[i1].iData.compareTo(minimal_key) == 0) {
                                    minNode1 = nodeArray[i1];
                                    minNodeLoc = i1;
                                }
                            }
                            letters.remove(minimal_key);

                            String minimal_key2 = get_minimum_key(letters, text.length());
                            int frequency2 = letters.get(minimal_key2);
                            Node minNode2 = new Node();
                            for (int i2 = 0; i2 < nodeArray.length; i2++) {
                                if (nodeArray[i2].iData.compareTo(minimal_key2) == 0) {
                                    minNode2 = nodeArray[i2];
                                }
                            }
                            letters.remove(minimal_key2);

                            newKey = combine_keys(minimal_key, minimal_key2);
                            letters.put(newKey, frequency + frequency2);

                            Node newNode = new Node();
                            newNode.dData = letters.get(newKey);
                            newNode.iData = newKey;
                            newNode.leftChild = minNode1;
                            newNode.rightChild = minNode2;
                            nodeArray[minNodeLoc] = newNode;
                        }
                        theTree.root = nodeArray[minNodeLoc];
                        break;
                    case 's':
                        System.out.println("Enters will be displayed in the tree as |");
                        theTree.displayTree();
                        break;
                    case 'c':
                        codeArray = theTree.makeCodeTable(nodeArray[minNodeLoc], "");
                        encodeMessage(theTree, text);
                        System.out.println("");
                        break;
                    case 'd':
                    	System.out.println("Type in your message: ");
                        String code = keyboard.nextLine();
                    	decodeMessage(codeArray, code);
                        System.out.println("");
                        break;
                    case 'f':
                        System.exit(0);
                        break;
                    default:
                        System.out.print("Invalid entry\n");
                }
            }
                        
	}
	public static String getText() throws IOException
	{
		String outStr="", str = "";
		while(true)
		{
			str = getString();
			if( str.equals("$") )
				return outStr;
			outStr = outStr + str + "|";
		}
	} 
	public static String getString() throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	public static void decodeMessage(Map<String, Character> codeArray, String code){
		int i2 = 0;
		for (int i=0; i <=code.length(); i++) {
			Iterator<String> keySetIterator = codeArray.keySet().iterator();
            while (keySetIterator.hasNext()) {
            	String key = keySetIterator.next();
            	if (code.substring(i2, i).compareTo(key)==0 ){
            		if (codeArray.get(key).equals('|')){
            			System.out.println("");
            		}
            		else {
            		System.out.print(codeArray.get(key));
            		}
            		i2=i;
            	}
            }
			
		}
	}

	public static void encodeMessage(Tree theTree, String Message){
		Node node = new Node();
		for (int i = 0; i<Message.length(); i++){
			node = theTree.find(Message.charAt(i)+"");
			System.out.print(node.code);
		}
	}
	
	public static String combine_keys(String a, String b) {
		return a + b;
	}

	public static Map<String, Integer> get_frequency(String text) {
		Map<String, Integer> letters = new Hashtable<String, Integer>();
		for (int i = 0; i < text.length(); i++) {

			if (letters.containsKey(text.charAt(i) + "")) {
				letters.put(text.charAt(i) + "",
						letters.get(text.charAt(i) + "") + 1);
			} else {
				letters.put(text.charAt(i) + "", 1);
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
		return minimalkey;

	}



}
