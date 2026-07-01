class Solution {
    public int largestRectangleArea(int[] arr) {
        int n = arr.length;
        Stack<Integer>nextSmaller = new Stack<>();
        Stack<Integer>prevSmaller = new Stack<>();
        int[]nextSmall = new int[n];
        int[]prevSmall = new int[n];

        for(int i =0; i<=n-1; i++){
            while(!prevSmaller.isEmpty() && arr[i]<= arr[prevSmaller.peek()]){
                prevSmaller.pop();
            }
            if(prevSmaller.isEmpty()){
                prevSmall[i] = -1;
                prevSmaller.push(i);
            }
            else{
                prevSmall[i] = prevSmaller.peek();
                prevSmaller.push(i);
            }
        }

        for(int i =n-1; i>=0; i--){
            while(!nextSmaller.isEmpty() && arr[i]< arr[nextSmaller.peek()]){
                nextSmaller.pop();
            }
            if(nextSmaller.isEmpty()){
                nextSmall[i] = n;
                nextSmaller.push(i);
            }
            else{
                nextSmall[i] = nextSmaller.peek();
                nextSmaller.push(i);
            }
        }
        int res = Integer.MIN_VALUE;

        for(int i =0; i<=n-1; i++){
            int area = (nextSmall[i]-prevSmall[i]-1)*arr[i];
            if(area>res){
                res = area;
            }
        }
        return res;
    }
}
