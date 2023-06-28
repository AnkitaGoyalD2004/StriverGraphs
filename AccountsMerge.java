package StriverGraph;

import java.util.*;


public class AccountsMerge {
   public class DisjointSet2 {
    int size[];
    int parent[];

    public DisjointSet2(int n) {
        size = new int[n + 1];
        parent = new int[n + 1];
        for (int i = 0; i < parent.length; i++) {
            size[i] = 0;
            parent[i] = i;
        }
    }

    public int ultimateParent(int node) {
        if (parent[node] == node) {
            return parent[node];
        }
        int up = ultimateParent(parent[node]);
        parent[node] = up;
        return up;
    }

    public void unionBySize(int u, int v) {
        int ultimateParentu = ultimateParent(u);
        int ultimateParentv = ultimateParent(v);
        if (size[ultimateParentu] > size[ultimateParentv]) {
            parent[ultimateParentv] = ultimateParentu;
            size[ultimateParentu]++;
        } else if (size[ultimateParentu] < size[ultimateParentv]) {
            parent[ultimateParentu] = ultimateParentv;
            size[ultimateParentv]++;
        } else {
            parent[ultimateParentu] = ultimateParentv;
            size[ultimateParentv]++;
        }
    }
}

    public static List<List<String>> accountsMerge(List<List<String>> accounts) {
        AccountsMerge ac = new AccountsMerge();
        // firstly creating the disjoint set
        HashMap<String, Integer> hm = new HashMap<>();
        DisjointSet2 ds = ac.new DisjointSet2(accounts.size());

        for (int i = 0; i < accounts.size(); i++) {
            List<String> current = accounts.get(i);
            for (int j = 1; j < current.size(); j++) {
                if (hm.containsKey(current.get(j)) == true) {
                    ds.unionBySize(i, hm.get(current.get(j)));
                } else {
                    hm.put(current.get(j), i);
                }
            }
        }
        
        ArrayList<String>[] mergedMail = new ArrayList[accounts.size()];
        for (int i = 0; i < mergedMail.length; i++) {
            mergedMail[i] = new ArrayList<>();
        }
        for (Map.Entry<String, Integer> entry : hm.entrySet()) {
            String mail = entry.getKey();
            int mailParent = ds.ultimateParent(entry.getValue());
            mergedMail[mailParent].add(mail);
        }

        List<List<String>> ans = new ArrayList<>();
        for (int i = 0; i < mergedMail.length; i++) {
            if (mergedMail[i].size() == 0) {
                continue;
            }
            Collections.sort(mergedMail[i]);
            List<String> toAdd = new ArrayList<>();
            toAdd.add(accounts.get(i).get(0));
            for (String str : mergedMail[i]) {
                toAdd.add(str);
            }
            ans.add(toAdd);
        }
        return ans;
    }
}
