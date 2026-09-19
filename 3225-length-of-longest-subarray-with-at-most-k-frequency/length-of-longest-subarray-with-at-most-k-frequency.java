class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        int maxLen = 0;
        int i = 0;
        int n = nums.length;
        for (int j = 0; j < n; j++) {
            map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);

            while (map.get(nums[j]) > k) {
                map.put(nums[i], map.get(nums[i]) - 1);
                i++;
            }

            maxLen = Math.max(maxLen, j - i + 1);
        }
        return maxLen;
    }
}