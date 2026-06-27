class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer>maxHeap  = new PriorityQueue<>(Collections.reverseOrder());
        for(int i =0; i <stones.length; i++){
            maxHeap.add(stones[i]);
        }
        while(maxHeap.size()>1){
            int a = maxHeap.poll();
            int b = maxHeap.poll();
            int c = a-b;
            if(c>0){
                maxHeap.add(c);
            }
        }
        if(maxHeap.size()!=0){
            return maxHeap.poll();
        }
        return 0;
        
    }
}
