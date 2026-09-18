class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[]nge = new int[n];
        Stack<Integer> stk = new Stack<>();
        for(int i = n-1; i >=0; i--){
            if(stk.isEmpty()){
                nge[i] = 0;
                stk.add(i);
            }else{
                while(!stk.isEmpty() && temperatures[i]>=temperatures[stk.peek()]){
                    stk.pop();
                }
                if(stk.isEmpty())nge[i] = 0;
                else{
                    nge[i] = stk.peek()-i;
                }
                stk.add(i);
            }
        }

        return nge;
    }
}