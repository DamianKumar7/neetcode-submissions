class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        List<List<String>> ans = new ArrayList<>();
        for (String s : strs) {
            char[] c = s.toCharArray();
            Arrays.sort(c);
            String key = new String(c);

            if (map.containsKey(key)) {
                List<String> list = map.get(key);
                list.add(s);
                map.put(key, list);
            } else {
                map.put(key, new ArrayList<String>(List.of(s)));
            }
        }

        for (String key : map.keySet()) {
            ans.add(map.get(key));
        }
        return ans;
    }
}
