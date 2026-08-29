class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int[] indegree = new int[numCourses];
        List<List<Integer>> adj = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int i =0; i <numCourses; i++){
            adj.add(new ArrayList<>());
        }

        for(int[]prerequisite: prerequisites){
            adj.get(prerequisite[1]).add(prerequisite[0]);
        }

        for(List<Integer>it: adj){
            for(int i =0; i <it.size(); i++){
                indegree[it.get(i)]++;
            }
        }

        for(int i =0; i< numCourses; i++){
            if(indegree[i] == 0)queue.add(i);
        }

        int count = 0;

        while(!queue.isEmpty()){
            int node = queue.poll();
            count++;
            List<Integer> neighbours = adj.get(node);
            for(int i: neighbours){
                indegree[i]--;
                if(indegree[i] == 0){
                    queue.add(i);
                }
            }
        }

        if(count == numCourses){
            return true;
        }
        return false;
    }
}
