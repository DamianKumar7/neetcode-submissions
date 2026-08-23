class Solution {
    public int countSubstrings(String s) {
        int[]substrings = new int[s.length()];
        for(int i =0; i < s.length(); i++){
            int countEven = expand(i,i,s);
            int countOdd = expand(i-1,i, s);
            int finalCount = countOdd+countEven;
            substrings[i] = finalCount;
        }

        int sum = 0; 
        for(int i =0; i < substrings.length; i++){
            sum+= substrings[i];
        }
        return sum;
    }

    public int expand(int left, int right, String s){
        int count = 0;
        while(left >=0 && left < s.length() && right >=0 && right < s.length() && s.charAt(left) == s.charAt(right)){
            count++;
            left--;
            right++;
        }
        return count;
    }
}
