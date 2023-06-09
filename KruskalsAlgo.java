package StriverGraph;
import java.util.*;
public class KruskalsAlgo {
    public static int algorithm(int V,int E , int edges[][]){
     Arrays.sort(edges , (a,b)-> a[2]-b[2] );
     DisjointSet2 ds = new DisjointSet2(V);
     int ans = 0 ; 
     for(int i  = 0 ; i<edges.length; i++){
        int node1 = edges[i][0];
        int node2 = edges[i][1];
        int weight = edges[i][2];
        if(ds.ultimateParent(node1) != ds.ultimateParent(node2)){
            ans += weight;
            ds.unionBySize(node1,node2);
        }
     }
     return ans;
    }
}
