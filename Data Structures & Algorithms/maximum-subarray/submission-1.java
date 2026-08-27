class Solution {
    public int maxSubArray(int[] arr) {
        int maxSum = arr[0];
        int currSum = arr[0];
        for(int i =1; i<arr.length; i++){
            currSum = Math.max(arr[i], arr[i]+currSum);
            if(currSum>maxSum)maxSum=currSum;
        }
        return maxSum;
    }
}
