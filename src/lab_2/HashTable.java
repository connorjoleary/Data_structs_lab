package lab_2;

import java.io.IOException;
import static java.lang.System.exit;
import static java.lang.System.in;
import static java.lang.System.out;
import java.util.Hashtable;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author Joe
 */
public class HashTable {

    //public static Tree theTree = new Tree();
    public static Hashtable table = new Hashtable<Integer, Tree>();
    public static int index = 0;

    
    public static void main(String[] args) throws IOException {
        // TODO code application logic here
        out.print("Enter size(max 15): ");
        Scanner size = new Scanner(in);
        index = size.nextInt();
        out.print("Enter first letter of ");
        out.print("insert, show, find, or end: ");
        char choice = (char) in.read();
        switch(choice){
            case 's':
                show();
                break;
            case 'f':
                out.print("enter values to find: ");
                Scanner key = new Scanner(in);
                search(key.nextInt());
                break;
            case 'i':
                out.println("Enter the variables for the trees: ");
                for(int i=0; i<index; i++){
                    insert(i);
                    out.println("enter another tree: ");
                }
                break;
            case 'e':
                exit(0);
                break;
            default:
                out.print("Invalid entry\n");
            
        }
    }
        
    public static void insert(int input) {
        Tree theTree = new Tree();
        theTree = null;
        for (int j = 0; j < 4; j++) {
            Scanner keyboard = new Scanner(in);
            out.print("enter values in tree: ");
            theTree.insertTree(keyboard.nextInt());
        }
        table.put(input, theTree);
    }

    public static void search(int key) {
        Tree findTree = new Tree();
        for (int i = 0; i < index; i++) {
            findTree = (Tree) table.get(i);
            findTree.find(key);
        }

    }

    public static void show() {

        Tree displayTree = new Tree();
        for (int i = 0; i < index; i++) {
            displayTree = (Tree) table.get(i);
            out.print(i + ": ");
            displayTree.traverse(2, displayTree.root);
            out.println();
        }

    }

    private static class Tree {

        class Node {

            public int iData; // data item (key)
            public double dData; // data item 
            public String code;//huffman code
            public Node leftChild; // this node's left child
            public Node rightChild; // this node's right child

            public void displayNode() // display ourself
            {
                out.print('{');
                out.print(iData);
                out.print(", ");
                out.print(dData);
                out.print("} ");
            }
        } // end class Node
        Node root;

        public Tree() // constructor
        {
            root = null;
        }
        public void insertTree(int id) {
            Node newNode = new Node(); // make new node
            newNode.iData = id; // insert data
            if (root == null) // no node in root
            {
                root = newNode;
            } else // root occupied
            {
                Node current = root; // start at root
                Node parent;
                while (true) // (exits internally)
                {
                    parent = current;
                    if (id < current.iData) // go left?
                    {
                        current = current.leftChild;
                        if (current == null) // if end of the line,
                        { // insert on left
                            parent.leftChild = newNode;
                            return;
                        }
                    } // end if go left
                    else // or go right?
                    {
                        current = current.rightChild;
                        if (current == null) // if end of the line
                        { // insert on right
                            parent.rightChild = newNode;
                            return;
                        }
                    } // end else go right
                } // end while
            } // end else not root
        } // end insert()
        public void traverse(int traverseType, Node localRoot)
	{
		switch(traverseType)
		{
		case 1: out.print("\nPreorder traversal: ");
		preOrder(localRoot);
		break;
		case 2: out.print("\nInorder traversal: ");
		inOrder(localRoot);
		break;
		case 3: out.print("\nPostorder traversal: ");
		postOrder(localRoot);
		break;
		}
		out.println();
	}
	// -------------------------------------------------------------
	private void preOrder(Node localRoot)
	{
		if(localRoot != null)
		{
			out.print(localRoot.iData + " ");
			preOrder(localRoot.leftChild);
			preOrder(localRoot.rightChild);
		}
	}
	// -------------------------------------------------------------
	private void inOrder(Node localRoot)
	{
		if(localRoot != null)
		{
			inOrder(localRoot.leftChild);
			out.print(localRoot.iData + " ");
			inOrder(localRoot.rightChild);
		}
	}
	// -------------------------------------------------------------
	private void postOrder(Node localRoot)
	{
		if(localRoot != null)
		{
			postOrder(localRoot.leftChild);
			postOrder(localRoot.rightChild);
			out.print(localRoot.iData + " ");
		}
	}

        public Node find(int key) // find node with given key
        { // (assumes non-empty tree)
            Node current = root; // start at root
            //System.out.println(current.iData);
            while (current.iData != key) // while no match,
            {
                if (current.leftChild.iData == key) // go left?
                {
                    current = current.leftChild;
                } else // or go right?
                {
                    current = current.rightChild;
                }
                if (current == null) // if no child,
                {
                    out.println("didn't find "+key);
                    return null; // didn't find it
                }
            }
            out.println("found "+key);
            return current; // found it
        } // end find()

    }

}
