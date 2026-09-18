class Solution {
    public int compress(char[] chars) {
        int idx = 0;
        int n = chars.length;
        for (int i = 0; i < n; i++) {
            char ch = chars[i];
            int count = 0;
            while (i < n && ch == chars[i]) {
                count++;
                i++;
            }
            i--; 

            chars[idx] = ch;
            idx++;
            if (count > 1) {
                for (char digit : String.valueOf(count).toCharArray()) {
                    chars[idx] = digit;
                    idx++;
                }
            }
        }
        return idx;
    }
}