class Solution {
    public int rob(int[] nums) {
        int[]max = new int[nums.length];
        for(int i =0; i < nums.length; i++){
            if(i == 0){
                max[i] = nums[0];
            }else if (i == 1){
                max[i] = Math.max(nums[i], nums[i-1]);
            }else{
                max[i] = Math.max(max[i-1], nums[i]+max[i-2]);
            }
        }

        return max[nums.length-1];
    }
}
