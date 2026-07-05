class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> set = new HashSet<>();
        int i =0;
        int j =0;
        int length=0;
        while(j< s.length()){
            if(!set.contains(s.charAt(j))){
                set.add(s.charAt(j));
                if(set.size()>length){
                    length = set.size();
                }
                j++;
            }
            else {
                set.remove(s.charAt(i));
                i++;
                
            }
        } 

        return length;
    }
}
