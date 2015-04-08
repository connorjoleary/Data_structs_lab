package lab_3;
import java.util.Arrays;
import java.util.Scanner;
//1 let dist be a |V| � |V| array of minimum distances initialized to (infinity)
//2 for each vertex v
//3    dist[v][v] <- 0
//4 for each edge (u,v)
//5    dist[u][v] <- w(u,v)  // the weight of the edge (u,v)
//6 for k from 1 to |V|
//7    for i from 1 to |V|
//8       for j from 1 to |V|
//9          if dist[i][j] > dist[i][k] + dist[k][j] 
//10             dist[i][j] <- dist[i][k] + dist[k][j]
//11         end if

public class Floyd_algorithm {
    public static int table[][] = {{Integer.MAX_VALUE,50,Integer.MAX_VALUE,80,Integer.MAX_VALUE}
		,{Integer.MAX_VALUE,Integer.MAX_VALUE,60,90,Integer.MAX_VALUE}
		,{Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE,40},
		{Integer.MAX_VALUE,Integer.MAX_VALUE,20,Integer.MAX_VALUE,70},
		{Integer.MAX_VALUE,50,Integer.MAX_VALUE,Integer.MAX_VALUE,Integer.MAX_VALUE}};;

	public static void main(String[] args) {
            System.out.println("Starting Matrix");
            displayMatrix();
            Scanner in = new Scanner(System.in);
            Scanner keyboard = new Scanner(System.in);
            
            for (int k = 0; k < 5; k++) {
                for (int i = 0; i < 5; i++) {
                    for (int j = 0; j < 5; j++) {
                        if (table[i][j] > (table[i][k] + table[k][j]) && (table[i][k] + table[k][j]) >= 0) {
                            table[i][j] = table[i][k] + table[k][j];
                            System.out.println("Press enter to continue...");
                            keyboard.nextLine();

                            displayMatrix();
                            //System.out.println(k + " " + i + " " + j + "\n");
					}
				}
			}
		}
	}

    public static void displayMatrix() {
        char colum[] = {'A','B','C','D','E'};
        System.out.println("    A    B     C    D    E   ");
        for (int i = 0; i < 5; i++) {
            System.out.print(colum[i]+": ");
            for (int j=0; j<5; j++) {
                if(table[i][j] == Integer.MAX_VALUE){
                    System.out.print("{-} ");
                }else{
                    System.out.print("{"+table[i][j]+"} ");
                }
            }
            System.out.println();
        }
    }	
}
