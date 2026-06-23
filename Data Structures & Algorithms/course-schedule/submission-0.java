class Solution {
    public boolean canFinish(int n, int[][] prerequisites) {
        int[] inDegree = new int[n];
        List<List<Integer>> adj = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            adj.add(new ArrayList<>());
        }
        Queue<Integer>queue = new LinkedList<>();
        for(int[]i: prerequisites){
            adj.get(i[0]).add(i[1]);
            inDegree[i[1]]++;
        }

        for(int i =0; i<n;i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }

        while(!queue.isEmpty()){
            int node = queue.poll();
            for(int i:adj.get(node)){
                inDegree[i]--;
                if(inDegree[i]==0){
                    queue.add(i);
                }
            }
        }

        for(int i =0; i<n;i++){
            if(inDegree[i] != 0){
                return false;
            }
        }
        return true;
    }
}
