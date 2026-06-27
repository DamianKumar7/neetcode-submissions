class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer>arr = new PriorityQueue<>();
        for(int i =0; i<nums.length;i++){
            arr.add(nums[i]);
            if(arr.size()>k){
                arr.poll();
            }
        }

        return arr.peek();
    }
}
