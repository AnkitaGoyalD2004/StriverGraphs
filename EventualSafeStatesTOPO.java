package StriverGraph;
import java.util.*;
public class EventualSafeStatesTOPO {
    public static void main(String[] args){

    }
    static int inDegree[];
    // static ArrayList<ArrayList<Integer>> ans;

    public static List<Integer> eventualSafeNodes(int [][] graph){
     ArrayList<ArrayList<Integer>> adj = construct(graph);
     inDegree(graph.length,adj);
     ArrayList<Integer> a = bfs(graph.length,adj);
     return a;

    } 
    
    public static ArrayList<ArrayList<Integer>> construct(int graph[][]){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < graph.length; i++) {
            adj.add(new ArrayList<>());
        }

        for (int i = 0; i < graph.length; i++) {
            for (int j = 0; j < graph[i].length; j++) {
                adj.get(graph[i][j]).add(i);
            }
        }
        return adj;
    }

    public static void inDegree(int V  , ArrayList<ArrayList<Integer>>adj){
      inDegree = new int[V];
      for(int i = 0; i<V ; i++){
        for(int it:adj.get(i)){
            inDegree[it]++;
        }
      }
    }

    public static ArrayList<Integer> bfs(int V ,ArrayList<ArrayList<Integer>> adj ){
        Queue<Integer> q = new LinkedList<>();
        ArrayList<Integer> safeNodes = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            if (inDegree[i] == 0) {
                q.add(i);
            }
        }

        while (!q.isEmpty()) {
            int node = q.peek();
            q.remove();
            safeNodes.add(node);
            ArrayList<Integer> ans = adj.get(node);
            for (int it : ans) {
                inDegree[it]--;
                if (inDegree[it] == 0) q.add(it);
            }
        }
        Collections.sort(safeNodes);
        return safeNodes;
    }
}
