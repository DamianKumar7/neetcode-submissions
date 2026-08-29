class Solution {
    public List<Integer> findMinHeightTrees(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        for(int i =0; i <n; i++){
            adj.add(new ArrayList<>());
        }
        int[] degree = new int[n];

        if(n == 1)return new ArrayList<>(List.of(0));

        for(int[]edge: edges){
            adj.get(edge[0]).add(edge[1]);
            adj.get(edge[1]).add(edge[0]);
        }

        for(int i =0; i<n; i++){
            degree[i] = adj.get(i).size();
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i =0; i < n; i++){
            if(degree[i] == 1)queue.add(i);
        }
        int numberOfNodesLeft = n;
        while(numberOfNodesLeft > 2){
            int numberOfLeafNodes = queue.size();
            numberOfNodesLeft-=numberOfLeafNodes;
            for(int i =0; i <numberOfLeafNodes;i++){
                int leafNode = queue.poll();
                List<Integer> neighbours = adj.get(leafNode);
                for(int it: neighbours){
                    degree[it]--;
                    if(degree[it] ==1){
                        queue.add(it);
                    }
                }
            }
        }

        List<Integer> ans = new ArrayList<>();
        while(!queue.isEmpty())ans.add(queue.poll());

        return ans;

    }
}