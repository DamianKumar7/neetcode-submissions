class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        int max = Integer.MIN_VALUE;
        int min = 1;
        for(int i =0; i < piles.length; i++){
            if(piles[i]>max){
                max = piles[i];

            }
        }
        int minimumRate = 0;
        while(min<= max){
            int mid = (max+min)/2;
            int time = timeTaken(mid, piles);
            if(time<=h){
                minimumRate = mid;
                max = mid-1;
            }
            else{
                min = mid+1;
            }
        }
        return minimumRate;
    }
    public int timeTaken(int mid, int[]piles){
        int count = 0;
        for(int i =0; i <piles.length;i++){
            count+= Math.ceil((double)piles[i]/(double)mid);
        }
        return count;
    }
}
