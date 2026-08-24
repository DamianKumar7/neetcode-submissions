class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        int i = s1.length();
        int j = s2.length();
        int k = s3.length();
        if(i == 0 && j ==0 && k ==0){
            return true;
        }
        else{
            if(i > 0 && k>0 && s3.charAt(k-1) == s1.charAt(i-1)){
                return isInterleave(s1.substring(0,i-1),s2,s3.substring(0,k-1));
            }
            else if(j > 0 && k>0 && s3.charAt(k-1) == s2.charAt(j-1)){
                return isInterleave(s1,s2.substring(0,j-1),s3.substring(0,k-1));
            }
        }
        return false;
    }
}
