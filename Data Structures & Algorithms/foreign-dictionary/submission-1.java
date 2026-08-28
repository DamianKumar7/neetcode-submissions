class Solution {

    public String foreignDictionary(String[] words) {

        Map<Character, Set<Character>> graph = new HashMap<>();

        // Add every character
        for (String word : words) {
            for (char c : word.toCharArray()) {
                graph.putIfAbsent(c, new HashSet<>());
            }
        }

        // Build dependencies
        for (int i = 0; i < words.length - 1; i++) {

            String first = words[i];
            String second = words[i + 1];

            int len = Math.min(first.length(), second.length());

            boolean foundDifference = false;

            for (int j = 0; j < len; j++) {

                char c1 = first.charAt(j);
                char c2 = second.charAt(j);

                if (c1 != c2) {

                    graph.get(c1).add(c2);

                    foundDifference = true;
                    break;
                }
            }

            // Invalid prefix case
            if (!foundDifference && first.length() > second.length()) {
                return "";
            }
        }

        // Calculate indegree
        Map<Character, Integer> indegree = new HashMap<>();

        for (char c : graph.keySet()) {
            indegree.put(c, 0);
        }

        for (char c : graph.keySet()) {
            for (char neighbour : graph.get(c)) {
                indegree.put(
                    neighbour,
                    indegree.get(neighbour) + 1
                );
            }
        }

        // Kahn's algorithm
        Queue<Character> queue = new LinkedList<>();

        for (char c : indegree.keySet()) {
            if (indegree.get(c) == 0) {
                queue.offer(c);
            }
        }

        StringBuilder result = new StringBuilder();

        while (!queue.isEmpty()) {

            char current = queue.poll();

            result.append(current);

            for (char neighbour : graph.get(current)) {

                indegree.put(
                    neighbour,
                    indegree.get(neighbour) - 1
                );

                if (indegree.get(neighbour) == 0) {
                    queue.offer(neighbour);
                }
            }
        }

        // Cycle detected
        if (result.length() != graph.size()) {
            return "";
        }

        return result.toString();
    }
}