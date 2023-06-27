package StriverGraph;
// in this  parent array of size n+1, we will take it of size n.
public class NetworkConnected {
    public static int makeConnected(int n, int[][] connections) {
        DisjointSet2 ds = new DisjointSet2(n);
        int extraEdges = 0;
        for (int i = 0; i < connections.length; i++) {
            int nodeA = connections[i][0];
            int nodeB = connections[i][1];
            if (ds.ultimateParent(nodeB) != ds.ultimateParent(nodeA)) {
                ds.unionBySize(nodeA, nodeB);
            } else {
                extraEdges++;
            }
        }
        int numberComp = 0;
        int arr[] = ds.parent;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == i) {
                numberComp++;
            }
        }
        if (extraEdges >= (numberComp - 1)) {
            return numberComp - 1;
        }
        return -1;
    }
}
