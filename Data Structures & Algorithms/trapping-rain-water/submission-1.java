class Solution {
    public int trap(int[] height) {
        int leftMax = 0;
        int rightMax = 0;
        int total = 0;
        int i =0;
        int j = height.length-1;
        while(i<=j){
            if(height[i]<= height[j]){
                if(height[i]<=leftMax){
                    total += leftMax -height[i];
                }else{
                    leftMax = height[i];
                }
                i++;
            }
            else{
                if(height[j]<=rightMax){
                    total+= rightMax-height[j];
                }
                else{
                    rightMax = height[j];
                }
                j--;
            }
        }
        return total;
    }
}
