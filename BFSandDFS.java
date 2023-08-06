package StriverGraph;
import java.util.*;
public class BFSandDFS {


    public static void main(String args[]){

    }

    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> bfs = new ArrayList<>();
        boolean vis[] = new boolean[V];
        Queue<Integer> q = new LinkedList<>();
        
        q.add(0);
        vis[0] = true;

        while(!q.isEmpty()){
            Integer node = q.poll();
            bfs.add(node);

            for(int i : adj.get(node)){
                if(vis[i] == false){
                    vis[i] = true;
                    q.add(i);
                }
            }
        }
        return bfs;
    }

    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        
        boolean vis[] = new boolean[V];
        ArrayList<Integer> d = new ArrayList<>();
        vis[0] = true;
        dfs(0,vis,adj,d);
        return d;
    }
    public static void dfs(int node, boolean vis[],ArrayList<ArrayList<Integer>> adj , ArrayList<Integer>d){
        vis[node] = true;
        d.add(node);
         
        for(int i : adj.get(node)){
            if(vis[i] == false){
               dfs(i,vis,adj,d);
            }
        }
    }
}
