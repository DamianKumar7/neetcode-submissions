class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int[]ans = new int[asteroids.length];
        for(int asteroid: asteroids){
            boolean isAlive = true;
            while(isAlive && asteroid< 0 && !stack.isEmpty() && stack.peek()>0){
                if(stack.peek()>-asteroid){
                    isAlive = false;
                }else if(stack.peek() == -asteroid){
                    isAlive = false;
                    stack.pop();
                }else if(stack.peek()<-asteroid){
                    stack.pop();
                }
                
            }
            if(isAlive)stack.push(asteroid);
        }

        int[] result = new int[stack.size()];
        for (int i = result.length - 1; i >= 0; i--) {
            result[i] = stack.pop(); 
        }
        return result;
    }
}