class Solution {
    public int[] dailyTemperatures(int[] arr) {
        Stack<Integer>stack = new Stack<>();
        int n = arr.length;
        int[]res = new int[n];
        for(int i =n-1; i >=0; i--){
            while(!stack.isEmpty() && arr[i]>= arr[stack.peek()]){
                stack.pop();
            }
            if(stack.isEmpty()){
                res[i] = 0;
                stack.push(i);
            }
            else{
                res[i] = stack.peek()-i;
                stack.push(i);
            }
        }
        return res;
    }
}
