class Solution {
    public int maxFrequency(int[] nums, int k) {
        Arrays.sort(nums); 
        int i = 0;
        long total = 0; 
        int maxLen = 0;

        for (int j = 0; j < nums.length; j++) {
            total += nums[j];

            while ((long) nums[j] * (j - i + 1) - total > k) {
                total -= nums[i];
                i++;
            }

            maxLen = Math.max(maxLen, j - i + 1);
        }
        return maxLen;
    }
}