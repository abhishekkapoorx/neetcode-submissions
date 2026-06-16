class Solution {
    private boolean dfs(List<List<Integer>> adj, boolean[] vis, int i, int parent) {
    vis[i] = true;
    for (int n : adj.get(i)) {
        if (n == parent) continue;  // Skip the parent edge
        if (vis[n]) return false;    // If visited and not parent → cycle
        if (!dfs(adj, vis, n, i)) return false;
    }
    return true;
}
    public boolean validTree(int n, int[][] edges) {
        // 1. create empty adj list
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++){
            adj.add(new ArrayList<Integer>());
        }
        // 2. create edges bw nodes
        for (int[] edge: edges) {
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        boolean[] vis = new boolean[n];
        for (int i = 0; i < n; i++) {
            if (!vis[i] && !dfs(adj, vis, i, -1)) return false;
        }
        return true;
    }
}
