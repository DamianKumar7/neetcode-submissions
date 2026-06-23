class Solution {
    public int[] findOrder(int n, int[][] prerequisites) {
        int[] inDegree = new int[n];
        int[] res = new int[n];
        int idx =0;
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        Queue<Integer>queue = new LinkedList<>();
        for(int[]i: prerequisites){
            adj.get(i[1]).add(i[0]);
            inDegree[i[0]]++;
        }

        for(int i =0; i<n;i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int node = queue.poll();
            res[idx++] = node;
            for(int i:adj.get(node)){
                inDegree[i]--;
                if(inDegree[i]==0){
                    queue.add(i);
                }
            }
        }

        for(int i =0; i<n;i++){
            if(inDegree[i] != 0){
                return new int[]{};
            }
        }
        return res;
    }
}
