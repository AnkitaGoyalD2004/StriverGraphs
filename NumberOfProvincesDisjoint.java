package StriverGraph;
// in this  parent array of size n+1, we will take it of size n.
public class NumberOfProvincesDisjoint {
    public static int findCircleNum(int [][] isConnected){
        DisjointSet2 ds = new DisjointSet2(isConnected.length);
        for (int i = 0; i < isConnected.length; i++) {
            for (int j = 0; j < isConnected.length; j++) {
                if (isConnected[i][j] == 1) {
                    ds.unionBySize(i, j);
                }
            }
        }
        int arr[] = ds.parent;
        int ans = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == i) {
                ans++;
            }
        }
        return ans;
    }
}

