package StriverGraph;

public class DisjointSet {
    int rank[];
    int parent[];

    public DisjointSet(int n){
        rank = new int[n+1];
        parent = new int[n+1];
        for(int i = 0; i <= n ; i++){
            rank[i] = 0;
            parent[i] = i;   
        }
    }
    public int findUP(int node){
        if(parent[node] == node){return node;}
        int ultimateParent = findUP(parent[node]);
        parent[node] = ultimateParent;
        return parent[node];
    }
    public void unionRank(int u , int v){
        int UPu = findUP(u);
        int UPv = findUP(v);
        if(rank[UPu] > rank[UPv] ){
            parent[UPv] = UPu;
        }else if(rank[UPv]>rank[UPu]){
            parent[UPu] = UPv;
        }else{
            parent[UPu] = UPv;
            int a = rank[UPv];
            rank[UPv] = a+1;
        }
    }
}
