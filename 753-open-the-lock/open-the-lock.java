class Solution {
    public int openLock(String[] deadends, String target) {
        Set<String> dead = new HashSet<>();
        for (String s : deadends) dead.add(s);
        Set<String> visited = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        if (dead.contains("0000")) return -1; 

        queue.add("0000");
        visited.add("0000");
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String ele = queue.poll();
                if (ele.equals(target)) return level;
                List<String> l = nextOptions(ele);
                for (String j : l) {
                    if (!visited.contains(j) && !dead.contains(j)) {
                        queue.add(j);
                        visited.add(j);
                    }
                }
            }
            level++;
        }
        return -1;
    }

    public char turnRight(int i, char[] c) {
        return c[i] == '9' ? '0' : (char) (c[i] + 1);
    }

    public char turnLeft(int i, char[] c) {
        return c[i] == '0' ? '9' : (char) (c[i] - 1);
    }

    public List<String> nextOptions(String s) {
        List<String> ans = new ArrayList<>();
        char[] str = s.toCharArray();
        char[] copy = str.clone();
        for (int i = 0; i < 4; i++) {
            copy[i] = turnLeft(i, copy);
            ans.add(new String(copy));
            copy[i] = str[i];
            copy[i] = turnRight(i, copy);
            ans.add(new String(copy));
            copy[i] = str[i];
        }
        return ans;
    }
}