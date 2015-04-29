package lab_ec;

import static java.lang.System.out;
import java.util.Random;
import java.util.Arrays;
public class heap_sort {
	static int[] arr= new int[16];
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int size=16;
		arr = make_initial_tree(size);
		out.println(Arrays.toString(arr));
		sort(0, size);
		out.println(Arrays.toString(arr));
	}
	public static int[] make_initial_tree(int n){
		int[] arr = new int[n];
		for (int i=0; i<n; i++){
			Random generator = new Random(); 
			int j = generator.nextInt(99) + 1;
			arr[i]=j;
		}
		return arr;
	}
	public static void sort(int index, int n){
		//System.out.println(index);
		if (index>=n/2){
			//System.out.println("leaf");
			return;
		}
		else{
			sort(index*2+1, n);
			sort(index*2+2, n);
			trickle_down(index, n);
		}
		
	}
	public static void trickle_down(int x, int n){
		if (2*x+2==n){
			if (arr[x] < arr[2*x+1]){
				swap(x, x*2+1);
			}
			return;
		}
		//System.out.println("next: "+x);
		while (arr[x] < arr[2*x+1] ||
				arr[x] < arr[2*x+2]){
			 int largerChild = max_child(x);
			 swap(x, largerChild);
			 if (largerChild==2*x+1){
				 x = 2*x+1;
			 }
			 else{
				 x = 2*x+2; 
			 }
			 //System.out.println("next: "+x);
			 if (x>=n/2||x*2+2==n)
				 break;
		}
		if (2*x+2==n){
			if (arr[x] < arr[2*x+1]){
				swap(x, x*2+1);
			}
			return;
		}
	}
	public static int max_child(int x){
		if (arr[2*x+1]>arr[2*x+2])
			return x*2+1;
		else{
			return x*2+2;
		}
	}
	public static void swap(int x, int larger){
		int temp=arr[x];
		arr[x]=arr[larger];
		arr[larger]=temp;
	}
		
}
