package lab_4;

import java.util.Random;

/*Implement the divide-and-conquer algorithm you learnt in the class to solve the closest pair of
points problem. You could either hard-code or randomly generate points in your solution. The
running time of your algorithm should be O(nlogn). Sample output of your solution should
look like:*/

public class divideconquer {
    public static double input[][];

	public static void main(String[] args) {
		// TODO Auto-generated method stub
            //input
            Random ran = new Random();
            for(int i = 0; i< 1;i++){
                for(int j = 0; j< 12;j++){
                    input[i][j] = ran.nextInt(31);
                    System.out.println(input[i][j]);
                }
            }
	}

}
