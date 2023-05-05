package StriverGraph;

import java.util.*;

public class KahnAlgorithm {
    public static void main(String[] args) {

    }

    public static int[] topoSort(int V, ArrayList<ArrayList<Integer>> adj) {
        int indegree[] = new int[V];
        for (int i = 0; i < V; i++) {
            for (int j : adj.get(i)) {
                indegree[j]++;
            }
        }
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        int k[] = new int[V];
        int i = 0;
        while (q.isEmpty() == false) {
            int currNode = q.peek();
            q.remove();
            k[i++] = currNode;
            for (int j : adj.get(currNode)) {
                indegree[j]--;
                if (indegree[j] == 0) {
                    q.add(j);
                }
            }
        }
        return k;
    }
}
