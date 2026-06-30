class Solution {
    public boolean isValid(String s) {
        Set<Character> openBracket = Set.of('[','{','(');
        Set<Character> closeBracket = Set.of(']','}',')');

        Map<Character,Character>map = new HashMap<>();
        map.put(']','[');
        map.put('}','{');
        map.put(')','(');

        Stack<Character>stk = new Stack<>();
        for(int i =0; i<s.length();i++){
            if(openBracket.contains(s.charAt(i))){
                stk.push(s.charAt(i));
            }
            else if(closeBracket.contains(s.charAt(i))){
                if(!stk.isEmpty()){
                    if(stk.peek() == map.get(s.charAt(i))){
                        stk.pop();
                    }else{
                        return false;
                    }
                }else{
                    return false;
                }
            }
        }


        if(!stk.isEmpty()){
            return false;
        }else{
            return true;
        }
    }
}
