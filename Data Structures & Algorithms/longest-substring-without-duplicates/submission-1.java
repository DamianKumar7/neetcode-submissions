class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s.length() == 1)
            return 1;
        Set<Character> set = new HashSet<>();
        int maxLength = 0;
        int i = 0;
        int j = 0;
        while (j < s.length()) {
            if (set.contains(s.charAt(j))) {
                set.remove(s.charAt(i));

                i++;
            } else {
                set.add(s.charAt(j));
                if (set.size() > maxLength) {
                    maxLength = set.size();
                }
                j++;
            }
        }

        return maxLength;
    }
}
