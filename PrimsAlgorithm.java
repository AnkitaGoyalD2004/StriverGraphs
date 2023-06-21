package StriverGraph;
import java.util.*;
class xy{
    int node;
    int distance;
    public xy(int distance , int node){
        this.node = node;
        this.distance = distance;

    }
}
public class PrimsAlgorithm {
    	public static int spanningTree(int V, int E, int edges[][]){
	    ArrayList<ArrayList<int[]>> adj = getAdj(edges , V ,E);
          boolean visited[] = new boolean[V];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int ans = 0;
        pq.add(new int[] { 0, 0 });
        while (pq.isEmpty() == false) {
            int currWt = pq.peek()[0];
            int currNode = pq.poll()[1];
            if (visited[currNode]) {
                continue;
            }
            ans += currWt;
            visited[currNode] = true;
            ArrayList<int[]> currList = adj.get(currNode);
            for (int[] a : currList) {
                int node = a[0];
                int weight = a[1];
                if (visited[node] == false) {
                    pq.add(new int[] { weight, node });
                }
            }
        }
        return ans;
    }

    public static ArrayList<ArrayList<int[]>> getAdj(int[][] edges, int V, int E) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<ArrayList<int[]>>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < edges.length; i++) {
            int node1 = edges[i][0];
            int node2 = edges[i][1];
            int weight = edges[i][2];
            adj.get(node1).add(new int[] { node2, weight });
            adj.get(node2).add(new int[] { node1, weight });
        }
        return adj;
    }

	    
	    
	}
