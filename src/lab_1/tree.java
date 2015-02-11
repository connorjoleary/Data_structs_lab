package lab_1;
import java.io.*;
import java.util.*; // for Stack class
////////////////////////////////////////////////////////////////
class Node
{
	public String iData; // data item (key)
	public int dData; // data item
	public String code; //huffman code
	public Node leftChild; // this node's left child
	public Node rightChild; // this node's right child
	public void displayNode() // display ourself
	{
		System.out.print('{');
		System.out.print(iData);
		System.out.print(", ");
		System.out.print(dData);
		System.out.print("} ");
	}
} // end class Node
////////////////////////////////////////////////////////////////
class Tree
{
	Node root; // first node of tree
	// -------------------------------------------------------------
	public Tree() // constructor
	{ root = null; } // no nodes in tree yet
	//-------------------------------------------------------------
	public Node find(String key) // find node with given key
	{ // (assumes non-empty tree)
		Node current = root; // start at root
		while(current.iData.compareTo(key)!=0) // while no match,
		{
			if(current.leftChild.iData.contains(key)) // go left?
				current = current.leftChild;
			else // or go right?
				current = current.rightChild;
			if(current == null) // if no child,
				return null; // didn't find it
		}
		return current; // found it
	} // end find()
	// -------------------------------------------------------------
	public Node[] makeArray(Map<String, Integer> letters){
		Node[] array = new Node[letters.size()];
		int i = 0;
		Iterator<String> keySetIterator = letters.keySet().iterator();
		while (keySetIterator.hasNext()) {
			Node newNode = new Node();
			String key = keySetIterator.next();
			newNode.dData=letters.get(key);
			newNode.iData=key;
			newNode.leftChild=null;
			newNode.rightChild=null;
			array[i]=newNode;
			i++;
		}
		
		return array;
	}
	public Map<String, Character> makeCodeTable(Node nd, String bc)
	{
        Map<String, Character> codeArray = new Hashtable<String, Character>();;
		if(nd.iData.length()>1)                   // not a leaf node
		{
			codeArray.putAll(makeCodeTable(nd.leftChild, bc+"0"));  // call ourself
			codeArray.putAll(makeCodeTable(nd.rightChild, bc+"1")); // recursively
		}
		else                               // leaf node, so put
		{                               //    in code table
			System.out.println(nd.iData + " has the code of: " + bc);
            nd.code = bc;
            codeArray.put(bc, nd.iData.charAt(0));
		}
		return codeArray;
	}// end makeCodeTable()
	// -------------------------------------------------------------
	public void traverse(int traverseType, Node localRoot)
	{
		switch(traverseType)
		{
		case 1: System.out.print("\nPreorder traversal: ");
		preOrder(localRoot);
		break;
		}
		System.out.println();
	}
	// -------------------------------------------------------------
	private void preOrder(Node localRoot)
	{
		if(localRoot != null)
		{
			System.out.print(localRoot.iData + " ");
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}
	// -------------------------------------------------------------
	public void displayTree()
	{
		Stack globalStack = new Stack();
		globalStack.push(root);
		int nBlanks = 32;
		boolean isRowEmpty = false;
		System.out.println(
				"......................................................");
		while(isRowEmpty==false)
		{
			Stack localStack = new Stack();
			isRowEmpty = true;
			for(int j=0; j<nBlanks; j++)
				System.out.print(' ');
			while(globalStack.isEmpty()==false)
			{
				Node temp = (Node)globalStack.pop();
				if(temp != null)
				{
					System.out.print(temp.iData);
					localStack.push(temp.leftChild);
					localStack.push(temp.rightChild);
					if(temp.leftChild != null ||
							temp.rightChild != null)
						isRowEmpty = false;
				}
				else
				{
					System.out.print("--");
					localStack.push(null);
					localStack.push(null);
				}
				for(int j=0; j<nBlanks*2-2; j++)
					System.out.print(' ');
			} // end while globalStack not empty
			System.out.println();
			nBlanks /= 2;
			while(localStack.isEmpty()==false)
				globalStack.push( localStack.pop() );
		} // end while isRowEmpty is false
		System.out.println(
				"......................................................");
	} // end displayTree()
	// -------------------------------------------------------------
} // end class Tree
////////////////////////////////////////////////////////////////
class TreeApp
{
	
	// -------------------------------------------------------------
	public static String getString() throws IOException
	{
		InputStreamReader isr = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(isr);
		String s = br.readLine();
		return s;
	}
	// -------------------------------------------------------------
	public static char getChar() throws IOException
	{
		String s = getString();
		return s.charAt(0);
	}
	//-------------------------------------------------------------
} // end class TreeApp
////