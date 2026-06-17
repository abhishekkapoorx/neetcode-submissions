class Solution {
    public int countComponents(int n, int[][] edges) {
        DS disjoint = new DS(n);
        int res = 0;
        for (int[] edge: edges) {
            if (disjoint.union(edge[0], edge[1])) {
                res++;
            }
        }
        return n - res;
    }
}

class DS {
    int[] parent;
    int[] rank;

    public DS (int n) {
        parent = new int[n];
        rank = new int[n];

        for (int i = 0; i < n; i++) parent[i] = i;
    }

    public int parent(int node) {
        if (node == parent[node]) return node;
        return parent[node] = parent(parent[node]);
    } 

    public boolean union(int u, int v) {
        int parentu = parent(u);
        int parentv = parent(v);

        if (parentu == parentv) return false;

        if (rank[parentu] > rank[parentv]) {
            parent[parentv] = parentu;
        } else {
            parent[parentu] = parentv;
        }
        return true;
    }
}
