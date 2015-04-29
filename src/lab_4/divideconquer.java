package lab_4;
import java.util.*;
import java.util.Random;

/*Implement the divide-and-conquer algorithm you learnt in the class to solve the closest pair of
points problem. You could either hard-code or randomly generate points in your solution. The
running time of your algorithm should be O(nlogn). Sample output of your solution should
look like:*/

public class divideconquer {
    //temp hard code
    public static double [][] input = new double[][]{{2.0,4.0,5.0,10.0,14.0,15.0,17.0,19.0,22.0,25.0,29.0,30.0}, {7.0,13.0,8.0,5.0,9.0,5.0,7.0,10.0,7.0,10.0,14.0,2.0}};
    //public static double input[][];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
            /*input=new double[12][2];
            Random ran = new Random();
            for(int i = 0; i< 12;i++){
                for(int j = 0; j< 2;j++){
                    input[i][j] = ran.nextInt(1000)/10.0;
                    System.out.print(input[i][j]+ " ");
                }
                System.out.println("");
            }*/
            //temp hard code points
            sort_for_x();
            System.out.println("");
            for(int i = 0; i< 12;i++){
            	System.out.println(input[i][0]);
            }
            
            System.out.println("Final result: P1: ("+ ", P2: " +", Distance: ");
	}
	public static void sort_for_x(){
		for (int i=1; i<input.length; i++){
			double[] temp = input[i];
			int j;
			for (j=i-1; j>=0 && temp[0]<input[j][0];j--){
				input[j+1]=input[j];
			}
			input[j+1]=temp;
		}
	}
        public static void sort_for_y(){
		for (int i=1; i<input.length; i++){
			double[] temp = input[i];
			int j;
			for (j=i-1; j>=0 && temp[0]<input[j][1];j--){
				input[j+1]=input[j];
			}
			input[j+1]=temp;
		}
	}
	public static double closest_pair(int s,int p1_index, int p2_index){
		if (s==1){
			return Double.POSITIVE_INFINITY;
                }
		if (s==2){
			return dist(input[p1_index],input[p2_index]);
                }
		int m = (p1_index+p2_index)/2;
		//divide s into s1 and s2
		
		double d1=closest_pair((m-p1_index)+1, p1_index, m );
                double d2=closest_pair((m-p2_index)+1, m+1, p2_index);
                double d3=closest_pair_xcut(m, s, d)
                return(min(d1,d2,d3));
	}
	public static double dist(double[] p1, double[] p2){
		return Math.sqrt(Math.pow((p1[0]+p2[0]),2)+Math.pow((p1[1]+p2[1]),2));
	}
        public static double min(double d1, double d2 ,double d3){
            return 0;
        }
        public static double closest_pair_xcut(m, s, d){
            
        }
	
}

