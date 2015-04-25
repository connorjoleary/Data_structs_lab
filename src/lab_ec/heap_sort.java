package lab_ec;

import java.util.Random;

public class heap_sort {
	static int[] arr= new int[7];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		arr = make_initial_tree();
		int[] sorted = sort(0, 7);
	}
	public static int[] make_initial_tree(){
		int[] arr = new int[7];
		for (int i=0; i<6; i++){
			Random generator = new Random(); 
			int j = generator.nextInt(24) + 1;
			arr[i]=j;
		}
		return arr;
	}
	public static void sort(int index, int n){
		if (index>n/2){
			return;
		}
		else{
			sort(index*2+1, n);
			sort(index*2+2, n);
			trickle_down(index);
		}
		
	}
	public static trickle_down(int x){
		while (arr[x] < arr[2*x+1] ||
				arr[x] < arr[2*x+2]){
			 int largerChild = max(heapArray[2x+1], heapArray[2x+2]);
			 swap(heapArray[x], largerChild);
			 if (largerChild was left child)
			 x = 2x+1;
			 else{
			 x = 2x+2; 
			 }
		}
	}
}
