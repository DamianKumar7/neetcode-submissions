class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>>adj = new ArrayList<>();
        int n = numCourses;

        for(int i =0; i <n; i++){
            adj.add(new ArrayList<>());
        }
        int[]indegree = new int[n];
        for(int []prereq:prerequisites){
            int u = prereq[1];
            int v = prereq[0];
            adj.get(u).add(v);
            indegree[v]++;
        }
        Queue<Integer>queue = new LinkedList<>();
        List<Integer> res = new ArrayList<>();
        for(int i=0; i <n; i++){
            if(indegree[i] == 0)queue.add(i);
        }


        while(!queue.isEmpty()){
            int ele = queue.poll();
            res.add(ele);
            List<Integer> neighbours = adj.get(ele);
            for(int neighbour: neighbours){
                indegree[neighbour]--;
                if(indegree[neighbour] == 0)queue.add(neighbour);
            }
        }

         if (res.size() == numCourses) {
            return res.stream().mapToInt(Integer::intValue).toArray();
        } else {
            return new int[0]; 
        } 
    }
}