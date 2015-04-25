package lab_ec;

import java.util.Random;

public class heap_sort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Tree t = make_initial_tree();
		t.displayTree();
		
	}
	public static Tree make_initial_tree(){
		Tree theTree = new Tree();
		for (int i=0; i<5; i++){
			Random generator = new Random(); 
			int j = generator.nextInt(24) + 1;
			theTree.insert(j);
		}
		return theTree;
	}

}
