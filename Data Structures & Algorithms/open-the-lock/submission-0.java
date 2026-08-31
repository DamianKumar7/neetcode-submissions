class Solution {
    public int openLock(String[] deadends, String target) {

        Set<String> dead = new HashSet<>(Arrays.asList(deadends));
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        String start = "0000";

        // If starting position itself is blocked
        if (dead.contains(start)) {
            return -1;
        }

        queue.offer(start);
        visited.add(start);

        int turns = 0;

        while (!queue.isEmpty()) {

            int size = queue.size();

            // Process all combinations reachable in 'turns' moves
            for (int j = 0; j < size; j++) {

                String current = queue.poll();

                if (current.equals(target)) {
                    return turns;
                }

                // Try rotating each of the 4 wheels
                for (int i = 0; i < 4; i++) {

                    char[] chars = current.toCharArray();
                    char original = chars[i];

                    // Rotate forward
                    chars[i] = original == '9'
                            ? '0'
                            : (char) (original + 1);

                    String forward = new String(chars);

                    if (!dead.contains(forward)
                            && !visited.contains(forward)) {

                        visited.add(forward);
                        queue.offer(forward);
                    }

                    // Restore and rotate backward
                    chars[i] = original == '0'
                            ? '9'
                            : (char) (original - 1);

                    String backward = new String(chars);

                    if (!dead.contains(backward)
                            && !visited.contains(backward)) {

                        visited.add(backward);
                        queue.offer(backward);
                    }
                }
            }

            // Finished all states at the current distance
            turns++;
        }

        return -1;
    }
}