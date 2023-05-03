package StriverGraph;

import java.util.*;

public class TopologicalSort {

    public static void main(String args[]) {
       
    }

    static boolean visited[];
    static Stack<Integer> s = new Stack<>();

    public static int[] util1(int V, ArrayList<ArrayList<Integer>> adj) {
        visited = new boolean[V];
        for(int i = 0;i<V;i++){
            if(visited[i] == false){
                dfs(V,adj,i);
            }
        }
        int k = 0;
        int ans[] = new int[V];
        while (s.isEmpty() == false) {
            ans[k++] = s.pop();
        }
        return ans;
    }

    private static void dfs(int V, ArrayList<ArrayList<Integer>> adj, int vertex) {
        if (visited[vertex] == true) {
            return;
        }
        visited[vertex] = true;
        ArrayList<Integer> currentList = adj.get(vertex);
        for (int i : currentList) {
            dfs(V, adj, i);
        }
        s.push(vertex);
    }
}
