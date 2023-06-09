package StriverGraph;
import java.util.*;

class helper{
    int weight ;
    int node;
    helper(int weight,int node){
        this.weight = weight;
        this.node = node;
    }
}

class HComparator  implements Comparator<helper>{
   public int compare(helper h1 , helper h2){
    if(h1.weight < h2.weight){
        return 0;
    }else{
        return 1;
    }
   }
}
public class DijkstrasAlgorithm {
    public static void main(String[] args){

    }
    public static int[] util1(int V , ArrayList<ArrayList<ArrayList<Integer>>> adj , int source){
        PriorityQueue<helper> pq = new PriorityQueue<>(new HComparator());
        int distance[] = new int[V];
        for(int i = 0; i<distance.length;i++){
            distance[i] = Integer.MAX_VALUE;
        }
        distance[source] = 0;
        pq.add(new helper(0,source));
        while(!pq.isEmpty()){
            helper h = pq.poll();
            int currentWeight = h.weight;
            int currentNode = h.node;
            ArrayList<ArrayList<Integer>> currentList = adj.get(currentNode);
            for (ArrayList<Integer> al : currentList) {
                int node = al.get(0);
                int nodeWeight = al.get(1);
                if (currentWeight + nodeWeight < distance[node]) {
                    distance[node] = currentWeight + nodeWeight;
                    pq.add(new helper(distance[node], node));
                }
            }
        }
        return distance;
        }
    }
