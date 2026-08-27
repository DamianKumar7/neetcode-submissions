class Solution {
    public int jump(int[] arr) {
        int l=0;
        int r=0;
        int jumps = 0;
        while(r<arr.length-1){
            int farthest = 0;
            for(int i =l; i <=r; i++){
                farthest = Math.max(i+arr[i],farthest);
            }
            l = l+1;
            r = farthest;
            jumps= jumps+1;
        }
        return jumps;
    }
}
