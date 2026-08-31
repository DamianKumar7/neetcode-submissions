class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int n = edges.length;
        int[] parent = new int[n + 1];
        int[] rank = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            parent[i] = i;
        }
        for (int i = 0; i <= n; i++) {
            rank[i] = 0;
        }

        for (int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            if (!union(x, y, parent, rank))
                return new int[] {x, y};
        }
        return new int[] {};
    }

    public int find(int x, int[] parent) {
        if (parent[x] != x) {
            parent[x] = find(parent[x], parent);
        }
        return parent[x];
    }

    public boolean union(int x, int y, int[] parent, int[] rank) {
        int parentX = find(x, parent);
        int parentY = find(y, parent);
        int rankX = rank[parentX];
        int rankY = rank[parentY];
        if (parentX == parentY)
            return false;
        if (rankX > rankY) {
            parent[parentY] = parentX;
        } else if (rankY > rankX) {
            parent[parentX] = parentY;
        } else {
            parent[parentY] = parentX;
            rank[parentX]++;
        }

        return true;
    }
}
