package StriverGraph;
import java.util.*;
public class MatrixO1 {
class Node{
    int first;
    int second;
    int third;
    Node(int first , int second,int third){
        this.first = first;
        this.second = second;
        this.third = third;
    }
}
    public static void main(String[] args){
      int matrix[][] = {
        {0,0,1},{0,1,0},{1,1,1}
      };
      int ans[][] = updateMatrix(matrix);
        for(int i = 0;i<ans.length;i++){
            for(int j =0 ;j<ans[0].length;j++){
                System.out.print(ans[i][j] +" ");
            }
            System.out.print(" ");
        }
    }

    public static int[][] updateMatrix(int[][] mat) {
        int n = mat.length;
        int m = mat[0].length;
        int [][] vis = new int[n][m];
        int [][] dis = new int[n][m];
        Queue<Node> q = new LinkedList<Node>();
        for(int i = 0 ; i< n;i++){
            for(int j =0 ; j<m;j++){
                if(mat[i][j] == 0){
                    q.add(new Node(i,j,1));  
                    vis[i][j] = 0;
                }
                else{
                    vis[i][j] = 1;
                }
            }
        }

    int delrow[] = {+1,0,-1,0};
    int delcol[] = {0,+1,0,-1};

        while(!q.isEmpty()){
            int row = q.peek().first;
            int col = q.peek().second;
            int step = q.peek().third;
            q.remove();
            dis[row][col] = step-1;
            for(int i =0;i<4;i++){
                int nrow=row + delrow[i];
                int ncol=col + delcol[i]; 
                if(nrow>=0 && nrow<n && ncol>=0 && ncol<m && vis[nrow][ncol]==1)
                {
                    vis[nrow][ncol]=0;
                      q.add(new Node(nrow,ncol,step+1)); 

                }
            }
        }
        return dis;
            

     }
}
