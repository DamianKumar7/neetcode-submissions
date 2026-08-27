class Solution {
    public boolean canJump(int[] arr) {
        int n = arr.length;
        int maxIndex = 0;
        for(int i =0; i <n; i++){
            if(i > maxIndex){
                return false;
            }
            int maxReachable = i+arr[i];
            maxIndex = Math.max(maxIndex, maxReachable);
            if(maxIndex>=n-1){
                return true;
            }
        }
        return false;
    }
}
