class Solution {
    public int characterReplacement(String s, int k) {
        int[]freq = new int[26];
        int length =0;
        int maxFreq = 0;
        int i =0;
        for(int j =0; j <s.length();j++){
            freq[s.charAt(j)-'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(j)-'A']);
            if((j-i+1)-maxFreq>k){
                freq[s.charAt(i)-'A']--;
                i++;
                maxFreq = 0;
                for(int f: freq)maxFreq=Math.max(maxFreq,f);
            }
            length = Math.max(j-i+1,length);
        }

        return length;
    }
}
