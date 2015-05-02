package lab_4;

import java.util.*;
import java.util.Random;

/*Implement the divide-and-conquer algorithm you learnt in the class to solve the closest pair of
 points problem. You could either hard-code or randomly generate points in your solution. The
 running time of your algorithm should be O(nlogn). Sample output of your solution should
 look like:*/

public class divideconquer {
   //temp hard code
    public static double [][] input = new double[][]{{2.0,4.0},{5.0,10.0},{14.0,15.0},{17.0,19.0},{22.0,25.0},{29.0,30.0},{7.0,13.0},{8.0,5.0},{9.0,5.0},{7.0,10.0},{7.0,10.0},{14.0,2.0}};
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
            /*for(int i = 0; i< 12;i++){
            	System.out.println(input[i][0]);
                System.out.println(input[i][1]);
            }*/
            double d = closest_pair(12, 0, 11);
            System.out.println("Final result: P1: ("+ ", P2: " +", Distance: "+d);
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
        public static double[][] sort_for_y(double[][] arr){
		for (int i=1; i<arr.length; i++){
			double[] temp = arr[i];
			int j;
			for (j=i-1; j>=0 && temp[1]<arr[j][1];j--){
				arr[j+1]=arr[j];
			}
			arr[j+1]=temp;
		}
		return arr;
	}
	public static double closest_pair(int s,int p1_index, int p2_index){
            System.out.println("Solving Problem: Point["+p1_index+"] ... Point["+p2_index+"]");
            System.out.println(s);
		if (s<=1){
			return Double.POSITIVE_INFINITY;
                }
		if (s==2){
			return dist(input[p1_index],input[p2_index]);
                }
		int m = (p1_index+p2_index)/2;
		//divide s into s1 and s2
		System.out.println("Divide at Point["+m+"]");
		double d1=closest_pair((m-p1_index)+1, p1_index, m );
                System.out.println("Found Result At Points:("+input[p1_index][0]+","+input[p1_index][1]+")("+input[p2_index][0]+","+input[p2_index][1]+") Distance:"+d1); 
                double d2=closest_pair((m-p2_index)+1, m+1, p2_index);
                double[][] arr = Arrays.copyOfRange(input, p1_index, p2_index+1);
                double d3=closest_pair_xcut(m, min(d1, d2, Double.POSITIVE_INFINITY), arr);
                return(min(d1,d2,d3));
	}
	public static double dist(double[] p1, double[] p2){
		return Math.sqrt(Math.pow((p1[0]-p2[0]),2)+Math.pow((p1[1]-p2[1]),2));
	}
        public static double min(double d1, double d2 ,double d3){
             if(d1 <= d2 && d1 <= d3){
                return d1;
            }else if(d2 <= d1 && d2 <= d3){
                return d2;
            }else if(d3 <= d1 && d3 <= d2){
                return d3;
            }
            return 0;
        }
        public static double closest_pair_xcut(int m, double d, double[][] s){
            System.out.println("Combining problems:");
            double [][] s_y = sort_for_y(s);
            ArrayList<double[]> s_c = new ArrayList<double[]>();
            //System.out.println("Here: "+Arrays.deepToString(s));
            //System.out.println("Here: "+Arrays.deepToString(s_y));
            for(int i = 0; i<s_y.length;i++){
                if(Math.abs(s_y[i][0]-m)<d){
                    s_c.add(s_y[i]);
                }
            }for (int j = 0; j < s_c.size(); j++) {
                    if ((s_c.get(j)[0] - s_y[j][0]) < m) {
                        for(int k =0; k<4;k++){
                        d = min(d, dist(s_y[j],s_y[j+k]), dist(s_y[j],s_y[j-k]));
                        }     
                    }
                }
            return d;
        }

}
