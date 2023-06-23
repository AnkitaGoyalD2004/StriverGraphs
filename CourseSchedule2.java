package StriverGraph;

import java.util.*;
public class CourseSchedule2 {
    public static void main(String[]args){

    }
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        ArrayList<ArrayList<Integer>> adj = construct(numCourses , prerequisites);
        inDegree(numCourses , adj);
        int[] ans = bfs(numCourses,adj);
        return ans;
    }

    static int[]  indegree;
    private static ArrayList<ArrayList<Integer>> construct(int V, int graph[][]) {
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < V; i++) {
            adj.add(new ArrayList<Integer>());
        }
        for (int i = 0; i < graph.length; i++) {
            adj.get(graph[i][0]).add(graph[i][1]);
        }
        return adj;
    }

    public  static void inDegree(int V , ArrayList<ArrayList<Integer>>adj){
        indegree = new int[V];
        for(int i =0 ; i<V ;i++){
            for (int a : adj.get(i)) {
                indegree[a]++;
            }
        }
         }
    public static int[] bfs(int V , ArrayList<ArrayList<Integer>> adj){
      Queue<Integer> q = new LinkedList<>();
      for(int i =0 ;i< V ;i++){
        if(indegree[i] == 0){
           q.add(i);
        }
      }
      int ans[] = new int[V];
        int k = ans.length - 1;
        while (q.isEmpty() == false) {
            int currentNode = q.poll();
            ans[k--] = currentNode;
            ArrayList<Integer> currentList = adj.get(currentNode);
            for (int i : currentList) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    q.add(i);
                }
            }
        }
        if (k == -1) {
            return ans;
        } else {
            return new int[0];
    }
}
}
