class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> set = new HashMap<>();
        for(int i =0; i <nums.length; i++){
            int x = target-nums[i];
            if(set.containsKey(x)){
                return new int[]{set.get(x),i};
            }
            else{
                set.put(nums[i],i);
            }
        }

        return new int[]{};

    }
}