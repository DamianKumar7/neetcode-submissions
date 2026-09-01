class Solution {
    public String longestPalindrome(String s) {
        int maxLength = Integer.MIN_VALUE;
        String res = "";

        for (int i = 0; i < s.length(); i++) {
            Object[] odd = expand(s, i, i);
            Object[] even = expand(s, i, i + 1);

            int length1 = (Integer) odd[0];
            int length2 = (Integer) even[0];

            if (length1 > maxLength) {
                maxLength = length1;
                res = (String) odd[1];
            }

            if (length2 > maxLength) {
                maxLength = length2;
                res = (String) even[1];
            }
        }

        return res;
    }

    public Object[] expand(String s, int start, int end) {
        int len = 0;
        String res = "";

        while (start >= 0 &&
               end < s.length() &&
               s.charAt(start) == s.charAt(end)) {

            len=end-start+1;
            res = s.substring(start, end + 1); 

            start--;
            end++;
        }

        return new Object[]{len, res};
    }
}