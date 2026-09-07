class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int[]left = new int[n];
        int[]right = new int[n];

        for(int i =n-1; i>=0; i --){
            if( i == n-1)left[i] = height[i];
            else{
                left[i] = Math.max(left[i+1],height[i]);
            }
        }

        for(int i =0; i <n; i++){
            if (i ==0 )right[i] = height[i];
            else{
                right[i] = Math.max(height[i], right[i-1]);
            }
        }
        int sum = 0;

        for(int i =0; i <n; i++){
            sum += Math.abs(Math.min(left[i],right[i]) - height[i]);
        }

        return sum;
    }
}