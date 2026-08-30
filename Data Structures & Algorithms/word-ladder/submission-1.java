class Solution {

    public int ladderLength(
            String beginWord,
            String endWord,
            List<String> wordList) {

        Set<String> words = new HashSet<>();

        for (String word : wordList) {
            words.add(word);
        }

        Queue<Map<String, Integer>> queue =
                new LinkedList<>();

        queue.add(Map.of(beginWord, 1));

        while (!queue.isEmpty()) {

            Map<String, Integer> map = queue.poll();

            // Since every map contains only one key-value pair
            String word = map.keySet().iterator().next();

            int level = map.get(word);

            // String comparison
            if (word.equals(endWord)) {
                return level;
            }

            char[] charArray = word.toCharArray();

            for (int i = 0; i < charArray.length; i++) {

                char original = charArray[i];

                for (char c = 'a'; c <= 'z'; c++) {

                    if (c == original) {
                        continue;
                    }

                    charArray[i] = c;

                    String newWord =
                            new String(charArray);

                    if (words.contains(newWord)) {

                        queue.add(
                                Map.of(
                                        newWord,
                                        level + 1
                                )
                        );

                        words.remove(newWord);
                    }
                }

                // Restore original character
                charArray[i] = original;
            }
        }

        return 0;
    }
}