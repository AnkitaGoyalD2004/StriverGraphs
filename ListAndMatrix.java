package StriverGraph;
import java.util.Scanner;
public class ListAndMatrix {
    // adjacency matrix(not good-it takes alot of space)
    static Scanner s = new Scanner(System.in);
    public static void util(){
        System.out.print("enter the number of vertices:");
        int a = s.nextInt();
        System.out.print("enter the number of edges");
        int b = s.nextInt();
        int adjMatrix[][] = new int[a+1][b+1];
        for (int i = 0; i < a; i++) {
            int ver1 = s.nextInt();
            int ver2 = s.nextInt();
            adjMatrix[ver1][ver2] = 1;
        }
        for(int[] c : adjMatrix){
             for(int i:c){
                System.out.print(i+" ");
             }
             System.out.println();
        }
}

}
