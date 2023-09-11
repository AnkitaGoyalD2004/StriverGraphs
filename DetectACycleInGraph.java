package StriverGraph;
import java.util.*;

class myPair {
    int x;
    int y;

    myPair(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class DetectACycleInGraph {

    public static void main(String[] args) {

    }

    public boolean checkForCycle(int V, ArrayList<ArrayList<Integer>> adj, int src, boolean vis[]) {
        vis[src] = true;
        Queue<myPair> q = new LinkedList<>();
        q.add(new myPair(src, -1));
        while (!q.isEmpty()) {
            int currentNode = q.peek().x;
            int parentNode = q.poll().y;
            ArrayList<Integer> currentList = adj.get(currentNode);
            for(int i:currentList){
                if(vis[i] == false){
                    q.add(new myPair(i,currentNode));
                    vis[i] = true;
                }else if(parentNode != i){
                    return true;
                }
            }
        }
        return false;
    }

    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        boolean[] vis = new boolean[V];
        for (int i = 0; i < V; i++) {
            if (vis[i] == false) {
                boolean smallAns = checkForCycle(V, adj, i, vis);
                if (smallAns) {
                    return true;
                }
            }
        }
        return false;
    }
    static boolean visited[];
    public boolean dfs( int node , int parent , int vis[], ArrayList<ArrayList<Integer>> adj ){
        vis[node] = 1;
        for(int i : adj.get(node)){
            if(vis[i] == 0){
                if(dfs(i , node,vis,adj) == true){return true;}
            }
        }
        return false;
    }
    // for detecting a cycle
    public boolean Cycle(int V , ArrayList<ArrayList<Integer>> adj){
        int vis[] = new int[V];
        for(int i = 0 ; i< V;i++){
            if(vis[i] == 0){
                // if(dfs(i,-1,vis,adj) == true){return true;}
                boolean ans = dfs(i,-1,vis.adj);
            }
        }
        return false;
    }
    
}
