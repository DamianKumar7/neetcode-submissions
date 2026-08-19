class Solution {
    public String minWindow(String s, String t) {

        if (s.length() < t.length()) {
            return "";
        }

        Map<Character, Integer> map = new HashMap<>();

        for (int i = 0; i < t.length(); i++) {
            map.put(
                t.charAt(i),
                map.getOrDefault(t.charAt(i), 0) + 1
            );
        }

        int i = 0;

        int ans = Integer.MAX_VALUE;
        int ansI = 0;
        int ansJ = 0;

        for (int j = 0; j < s.length(); j++) {

            if (map.containsKey(s.charAt(j))) {
                map.put(
                    s.charAt(j),
                    map.get(s.charAt(j)) - 1
                );
            }

            while (!calculateNonZeroHashMap(map)) {

                int temp = j - i + 1;

                if (temp < ans) {
                    ans = temp;
                    ansI = i;
                    ansJ = j;
                }

                if (map.containsKey(s.charAt(i))) {
                    map.put(
                        s.charAt(i),
                        map.get(s.charAt(i)) + 1
                    );
                }

                i++;
            }
        }

        if (ans == Integer.MAX_VALUE) {
            return "";
        }

        return s.substring(ansI, ansJ + 1);
    }

    private boolean calculateNonZeroHashMap(
            Map<Character, Integer> map) {

        for (int value : map.values()) {
            if (value > 0) {
                return true;
            }
        }

        return false;
    }
}