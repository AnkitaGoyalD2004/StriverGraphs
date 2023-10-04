package StriverGraph;

import java.util.*;
public class CourseSchedule {
    public static void main(String[] args) {
    }

    // static int inDegree[];
    // static int count = 0;

    // public boolean canFinish(int numCourses, int[][] prerequisites) {
    //     ArrayList<ArrayList<Integer>> adj = construct(numCourses, prerequisites);
    //     countIndegree(numCourses,adj);
    //     bfs(numCourses, adj);
    //     if(count.size()!=numCourses){
    //         return false;
    //     }
    //     return true;
    // }
    // }

    // public static ArrayList<ArrayList<Integer>> construct(int V, int graph[][]) {
    //     ArrayList<ArrayList<Integer>> adj = new ArrayList<ArrayList<Integer>>();
    //     for (int i = 0; i < V; i++) {
    //         adj.add(new ArrayList<Integer>());
    //     }
    //     int m = graph.length;
    //     for (int i = 0; i < m; i++) {
    //         adj.get(graph[i][0]).add(graph[i][1]);
    //     }
    //     return adj;
    // }

    // public static void countIndegree(int V, ArrayList<ArrayList<Integer>> adj) {
    //     inDegree = new int[V];
    //     for (int i = 0; i < V; i++) {
    //         for (int j : adj.get(i)) {
    //             inDegree[j]++;
    //         }
    //     }
    // }

    // public static void bfs(int V, ArrayList<ArrayList<Integer>> adj) {
    //     Queue<Integer> q = new LinkedList<>();
    //     for (int i = 0; i < V; i++) {
    //         if (inDegree[i] == 0) {
    //             q.add(i);
    //         }
    //     }
    //     int count =0;
    //     while (!q.isEmpty()) {
    //         int currentNode = q.poll();
    //         count++;
    //         for (int j : adj.get(currentNode)) {
    //             inDegree[j]--;
    //             if (inDegree[j] == 0) {
    //                 q.add(j);
    //             }
    //         }
    //     }
    // }

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] adj = new ArrayList[numCourses];
     for(int i=0;i<numCourses;i++){
         adj[i] = new ArrayList();
     }
     int[] indegree = new int[numCourses];
     for(int[] i: prerequisites){
         adj[i[0]].add(i[1]);
         indegree[i[1]]++;
     }
     Queue<Integer> queue= new LinkedList<>();
     for(int i=0;i<numCourses;i++){
         if(indegree[i]==0){
             queue.add(i);
         }
     }
         while(!queue.isEmpty()){
             int current=queue.poll();
             for(int c:adj[current]){
                 indegree[c]--;
                 if(indegree[c]==0)
                     queue.add(c);
             }
                 numCourses--;
         }
     return numCourses==0;
        }

}
