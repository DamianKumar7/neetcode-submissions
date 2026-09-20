class Solution {
    public String decodeString(String s) {
        Deque<Integer> countStack = new ArrayDeque<>();
        Deque<StringBuilder> stringStack = new ArrayDeque<>();
        StringBuilder current = new StringBuilder();
        int num = 0;

        for (char c : s.toCharArray()) {
            if (Character.isDigit(c)) {
                num = num * 10 + (c - '0');
            } else if (c == '[') {
                countStack.push(num);
                stringStack.push(current);
                num = 0;
                current = new StringBuilder();
            } else if (c == ']') {
                int repeat = countStack.pop();
                StringBuilder decoded = stringStack.pop();
                for (int i = 0; i < repeat; i++) {
                    decoded.append(current);
                }
                current = decoded;
            } else {
                current.append(c);
            }
        }
        return current.toString();
    }
}