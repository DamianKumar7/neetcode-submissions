class Solution {
    public int[] twoSum(int[] arr, int target) {
        int i =0;
        int j= arr.length-1;
        int[] ans;

        while(i<j){
            if(arr[i]+arr[j] == target){
                ans = new int[]{i+1,j+1};
                return ans;
            }
            else if(arr[i]+arr[j]>target){
                j--;
            }
            else if(arr[i]+arr[j]<target){
                i++;
            }
        }
        return new int[]{};
    }
}
