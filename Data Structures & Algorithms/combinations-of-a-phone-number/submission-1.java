class Solution {
    public List<String> letterCombinations(String digits) {
        String[]mappings = new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        List<String> res = new ArrayList<>();
        if (digits.isEmpty()) return res;
        backTrack(digits, 0, res, new StringBuilder(), mappings);
        return res;
    }

    public void backTrack(String digits,int idx, List<String> res, StringBuilder sb, String[]mappings){
        if(idx >= digits.length()){
            res.add(sb.toString());
            return;
        }
            

        int number = digits.charAt(idx)-'0';
        for(int i =0; i < mappings[number].length(); i++){
            sb.append(mappings[number].charAt(i));
            backTrack(digits, idx+1, res, sb, mappings);
            sb.deleteCharAt(sb.length() - 1);
        }

    }
}