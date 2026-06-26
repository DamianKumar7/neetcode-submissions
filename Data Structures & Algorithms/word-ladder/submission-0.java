class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> set = new HashSet<>();
        for (String word : wordList) {
            set.add(word);
        }
        Map<String, Integer> map = new HashMap<>();
        Queue<Map<String, Integer>> queue = new LinkedList<>();
        int seq = 1;
        queue.add(new HashMap<String, Integer>(Map.of(beginWord, seq)));
        if (set.contains(beginWord)) {
            set.remove(beginWord);
        }
        while (!queue.isEmpty()) {
            Map<String, Integer> combo = queue.poll();
            String word = combo.keySet().iterator().next();
            seq = combo.get(word);
            for (int i = 0; i < word.length(); i++) {
                char[] chars = word.toCharArray();
                char original = chars[i];
                for (char c = 'a'; c <= 'z'; c++) {
                    if (c == original)
                        continue; 
                    chars[i] = c;
                    String transformed = new String(chars);
                    if (set.contains(transformed)) {
                        if (transformed.equals(endWord)) {
                            return seq + 1;
                        }
                        set.remove(transformed);
                        queue.add(new HashMap<String, Integer>(Map.of(transformed, seq + 1)));
                    }
                }
                chars[i] = original;
            }
        }
        return 0;
    }
}
