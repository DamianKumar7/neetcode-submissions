class Solution {
    public int maxArea(int[] arr) {
        int maxWater = 0;
        int i =0;
        int j = arr.length-1;
        while(i < j ){
            int waterStored = Math.min(arr[i],arr[j])*(j-i);
            if(waterStored > maxWater){
                maxWater = waterStored;
            }
            if(arr[i]<arr[j]){
                i++;
            }else{
                j--;
            }
            
        }
        return maxWater;
        
    }
}
