class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)-> a[0]-b[0]);
        int numberOfMerges = 0;
        int start = intervals[0][0];
        int end = intervals[0][1];
        for(int i =1; i <intervals.length; i++){
            if(end > intervals[i][0]){
                end = Math.min(end, intervals[i][1]);
                numberOfMerges ++;
            }else{
                start = intervals[i][0];
                end = intervals[i][1];
            }
        }
        
        return numberOfMerges;
    }
}
