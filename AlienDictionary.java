package StriverGraph;
import java.util.*;
public class AlienDictionary {
    public static void main(String[] args){

    }
    public  static int indegree[];
    public static ArrayList<ArrayList<Integer>> getAdj(int K , String[] dic){
        ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < K; i++) {
            adj.add(new ArrayList<Integer>());
        }

        for (int i = 0; i < dic.length - 1; i++) {
            String s1 = dic[i];
            String s2 = dic[i + 1];
            int len = Math.min(s1.length(), s2.length());
            for (int j = 0; j < len; j++) {
                if (s1.charAt(j) != s2.charAt(j)) {
                    int toGet1 = ((int) (s1.charAt(j))) - 97;
                    int toPut = ((int) (s2.charAt(j))) - 97;
                    adj.get(toGet1).add(toPut);
                    break;
                }
            }
        }
        return adj;
    }
    

    public static void constIndegree(ArrayList<ArrayList<Integer>> adj, int V) {
        indegree = new int[V];
        for (int i = 0; i < V; i++) {
            for (int a : adj.get(i)) {
                indegree[a]++;
            }
        }
    }

    public static List<Integer> Bfs(ArrayList<ArrayList<Integer>> adj, int K) {
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < indegree.length; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        List<Integer> topo = new ArrayList<Integer>();
        while (q.isEmpty() == false) {
            int currentNode = q.poll();
            topo.add(currentNode);
            ArrayList<Integer> currentList = adj.get(currentNode);
            for (int i : currentList) {
                indegree[i]--;
                if (indegree[i] == 0) {
                    q.add(i);
                }
            }
        }
        return topo;
    }
}
