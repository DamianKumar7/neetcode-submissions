class Solution {
    public boolean checkInclusion(String s1, String s2) {
        int window = s1.length();
        int i = 0;
        int j = window - 1;
        while (j < s2.length()) {
            char[] a = s2.substring(i, j+1).toCharArray();
            char[] b = s1.toCharArray();

            Arrays.sort(a);
            Arrays.sort(b);

            if (Arrays.equals(a, b)) {
                return true;
            }
            i++;
            j++;
        }
        return false;
    }
}
