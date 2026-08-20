class Solution {
    public int[] maxSlidingWindow(int[] arr, int k) {
        PriorityQueue<Integer> maxPq = new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i <k; i++){
            maxPq.add(arr[i]);
        }
        List<Integer>ans = new ArrayList<>();
        ans.add(maxPq.peek());
        int i =0;
        int j = k;
        while(j < arr.length){
            maxPq.remove(arr[i]);  
            maxPq.add(arr[j]);     

            ans.add(maxPq.peek());

            i++;
            j++;
        }

        return ans.stream().mapToInt(Integer::intValue).toArray();
    }
}
