class Solution {
    public int trap(int[] height) {
        int[]leftMax = new int[height.length];
        int[]rightMax = new int[height.length];
        int total = 0;
        for(int i =0; i<height.length; i++){
            if(i > 0 && height[i]<leftMax[i-1]){
                leftMax[i] = leftMax[i-1];
            }else if( i ==0 ){
                leftMax[i] = height[i];
            }else{
                leftMax[i] = height[i];
            }
        }

        for(int i =height.length-1; i>=0; i--){
            if(i == height.length-1){
                rightMax[i] = height[i];
            }else if(height[i]<rightMax[i+1]){
                rightMax[i] = rightMax[i+1];
            }else{
                rightMax[i] = height[i];
            }
        }

        for(int i =0; i< height.length-1; i++){
            total += Math.min(rightMax[i],leftMax[i])-height[i];
        }

        return total;
    }
}
