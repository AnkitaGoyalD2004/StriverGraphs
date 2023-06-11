package StriverGraph;
import java.util.*;
public class NumberOfWaysToArrive {
    public static void main(String[] args){
       
    }
    public static ArrayList<ArrayList<int[]>> getAdj(int roads[][], int n) {
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        for (int i = 0; i < roads.length; i++) {
            adj.get(roads[i][0]).add(new int[] { roads[i][1], roads[i][2] });
            adj.get(roads[i][1]).add(new int[] { roads[i][0], roads[i][2] });
        }
        return adj;
    }

    static int mod = (int) (1e9 + 7);

    public static int countPaths(int n, int[][] roads) {
        ArrayList<ArrayList<int[]>> adj = getAdj(roads, n);
        int distance[] = new int[n];
        int ways[] = new int[n];
        for (int i = 0; i < distance.length; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.add(new int[] { 0, 0 });
        distance[0] = 0;
        ways[0] = 1;
        while (pq.isEmpty() == false) {
            int currWt = pq.peek()[1];
            int currNode = pq.poll()[0];
            ArrayList<int[]> currList = adj.get(currNode);
            for (int[] a : currList) {
                int node = a[0];
                int wt = a[1];

                if (distance[node] > currWt + wt) {
                    distance[node] = currWt + wt;
                    ways[node] = ways[currNode];
                    pq.add(new int[] { node, currWt + wt });
                } else if (distance[node] == currWt + wt) {
                    ways[node] = (ways[node] + ways[currNode])%mod;
                }

            }
        }
        return ways[n - 1] % mod;
    }
}
