package StriverGraph;
import java.util.*;
public class DetectACycle {

    static int indegree[];
    static int count = 0;

    public static boolean detectCycle(int V, ArrayList<ArrayList<Integer>> adj){
           countIndegree(V,adj);
           

    }

    public static void countIndegree(int V , ArrayList<ArrayList<Integer>> adj){
        indegree = new int[V];
        for(int i = 0 ;i< V;i++){
           for(int j : adj.get(i)){
             indegree[j]++ ;
           }
        }
    }
    public static void bfs(int V , ArrayList<ArrayList<Integer>> adj){
       Queue<Integer> q = new LinkedList<>();
       for(int i = 0;i<V;i++){
         if(indegree[i] == 0){
            q.add(i);
         }
       }
       int cnt = 0;
       while(!q.isEmpty()){
        int currentNode = q.peek();
        q.remove();
        cnt++;
        for (int j : adj.get(currentNode)) {
                    indegree[j]--;
                    if (indegree[j] == 0) {
                        q.add(j);
                    }
                }
       }
    }
    }

