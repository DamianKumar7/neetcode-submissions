class Solution {
    public boolean checkValidString(String s) {
        int minCount=0;
        int maxCount=0;
        for(int i =0; i < s.length(); i++){
            if(s.charAt(i) == '('){
                maxCount++;
                minCount++;
            }
            if(s.charAt(i) == ')'){
                maxCount--;
                minCount--;
            }
            if(s.charAt(i) == '*'){
                maxCount++;
                minCount--;
            }
            if(minCount < 0){
                minCount = 0;
            }
            if(maxCount < 0){
                return false;
            }
        }

        return minCount==0;
    }
}
