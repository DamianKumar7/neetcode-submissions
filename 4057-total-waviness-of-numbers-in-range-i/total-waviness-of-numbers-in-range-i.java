class Solution {
    public int totalWaviness(int num1, int num2) {
        int score = 0;
        for (int i = num1; i <= num2; i++) {
            score += find(i);
        }
        return score;
    }

    public int find(int x) {
        int score = 0;
        String s = String.valueOf(x);
        for (int i = 1; i < s.length() - 1; i++) {
            if ((s.charAt(i) < s.charAt(i-1) && s.charAt(i) < s.charAt(i+1)) ||
                (s.charAt(i) > s.charAt(i-1) && s.charAt(i) > s.charAt(i+1))) {
                score++;
            }
        }
        return score;
    }
}