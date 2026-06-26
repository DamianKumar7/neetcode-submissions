class Solution {
    class DisjoinSet {
        List<Integer> rank;
        List<Integer> parent;

        public DisjoinSet(int n) {
            this.rank = new ArrayList<Integer>();
            this.parent = new ArrayList<Integer>();
            for (int i = 0; i < n; i++) {
                parent.add(i);
                rank.add(0);
            }
        }

        public int findParent(int u) {
            if (u == parent.get(u))
                return u;
            else {
                int ulp = findParent(parent.get(u));
                parent.set(u, ulp);
                return parent.get(u);
            }
        }

        public void unionFind(int u, int v) {
            int parentU = findParent(u);
            int parentV = findParent(v);
            if (parentU == parentV) {
                return;
            }
            if (rank.get(parentU) > rank.get(parentV)) {
                parent.set(parentV, parentU);
            } else if (rank.get(parentV) > rank.get(parentU)) {
                parent.set(parentU, parentV);
            } else {
                parent.set(parentV, parentU);
                int rankU = rank.get(parentU);
                rank.set(parentU, rankU++);
            }
        }
    }
    public int[] findRedundantConnection(int[][] edges) {
        DisjoinSet ds = new DisjoinSet(edges.length + 1);
        for (int[] edge : edges) {
            int parentA = ds.findParent(edge[0]);
            int parentB = ds.findParent(edge[1]);
            if (parentA == parentB) {
                return edge; 
            }
            ds.unionFind(edge[0], edge[1]);
        }

        return new int[] {};
    }
}
