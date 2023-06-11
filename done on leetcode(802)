package StriverGraph;

import java.util.List;

import java.util.ArrayList;

public class EventualSafeStates {
    public static void main(String[] args) {

    }

    static boolean isSafe[];
    static boolean visit[];
    static boolean visitpath[];

    public static List<Integer> eventualSafe(int[][] graphs) {
        visit = new boolean[graphs.length];
        visitpath = new boolean[graphs.length];
        isSafe = new boolean[graphs.length];
        for (int i = 0; i < graphs.length; i++) {
            if (visit[i] == false) {
                dfs(graphs, i);
            }
        }
        List<Integer> ans = new ArrayList<Integer>();
        for (int i = 0; i < isSafe.length; i++) {
            if (isSafe[i] == true) {
                ans.add(i);
            }
        }
        return ans;
    }

    public static boolean dfs(int graph[][], int current) {
        visit[current] = true;
        visitpath[current] = true;
        int currConnect[] = graph[current];
        for (int i : currConnect) {
            if (visit[i] == false) {
                boolean smallAns = dfs(graph, i);
                if (smallAns) {
                    return true;
                }
            } else if (visit[i] == true && visitpath[i] == true) {
                return true;
            }
        }
        isSafe[current] = true;
        visitpath[current] = false;
        return false;
    }
}
