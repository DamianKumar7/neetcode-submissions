class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        Set<String> operators = new HashSet<>(Arrays.asList("+", "-", "*", "/"));

        for (String s : tokens) {
            if (operators.contains(s)) {
                int b = stack.pop();
                int a = stack.pop();
                int result;
                switch (s) {
                    case "+": result = a + b; break;
                    case "-": result = a - b; break;
                    case "*": result = a * b; break;
                    default:  result = a / b; break;
                }
                stack.push(result);
            } else {
                stack.push(Integer.parseInt(s));
            }
        }

        return stack.pop();
    }
}