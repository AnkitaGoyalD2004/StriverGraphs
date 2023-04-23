package StriverGraph;
import java.util.*;
public class isBipartite {
    public boolean isBipartite(int[][] graph) {
        return check(graph);
    }
    int colorArray [];
    public boolean check(int grid[][]){
        colorArray = new int[grid.length];
        for(int i = 0 ; i<grid.length;i++){
            if(colorArray[i] == 0){
                boolean ans = bfs(grid,i);
            if(ans == false){
                return false;
            }
        }
    }
    return true;
    }
    public boolean bfs(int [][]grid , int a){
        colorArray[a] = 1;
        Queue<Integer> q = new LinkedList<>();
        q.add(a);
        while(!q.isEmpty()){
            int currNode = q.poll();
             int currArray[] = grid[currNode];
            for(int j : currArray){
              if(colorArray[j] == 0){
                if(colorArray[currNode] == 1){
                    colorArray[j] = 2;
                }else{
                    colorArray[j] =1;
                }
                q.add(j);
              }else if (colorArray[currNode] == colorArray[j]) {
                return false;}
            }
        }
        return true;
    }
}
