class Solution {

    int[] parent;
    int[] rank;

    int find(int x) {
        if (parent[x] != x) {
            parent[x] = find(parent[x]); // path compression
        }
        return parent[x];
    }

    void union(int x, int y) {
        int rootX = find(x);
        int rootY = find(y);
        if (rootX == rootY) return;
        if (rank[rootX] < rank[rootY]) {
            parent[rootX] = rootY;
        } else if (rank[rootX] > rank[rootY]) {
            parent[rootY] = rootX;
        } else {
            parent[rootY] = rootX;
            rank[rootX]++;
        }
    }

    public List<List<String>> accountsMerge(List<List<String>> accounts) {

        // Step 1: assign each unique email an integer index
        Map<String, Integer> emailToIndex = new HashMap<>();
        Map<String, String> emailToName = new HashMap<>();
        int idx = 0;

        for (List<String> account : accounts) {
            String name = account.get(0);
            for (int i = 1; i < account.size(); i++) {
                String email = account.get(i);
                if (!emailToIndex.containsKey(email)) {
                    emailToIndex.put(email, idx++);
                    emailToName.put(email, name);
                }
            }
        }

        // Step 2: initialize DSU
        parent = new int[idx];
        rank = new int[idx];
        for (int i = 0; i < idx; i++) parent[i] = i;

        // Step 3: union all emails within the same account
        for (List<String> account : accounts) {
            int firstIndex = emailToIndex.get(account.get(1)); // first email as representative
            for (int i = 2; i < account.size(); i++) {
                union(firstIndex, emailToIndex.get(account.get(i)));
            }
        }

        // Step 4: group emails by their root parent
        Map<Integer, List<String>> rootToEmails = new HashMap<>();
        for (String email : emailToIndex.keySet()) {
            int root = find(emailToIndex.get(email));
            rootToEmails.putIfAbsent(root, new ArrayList<>());
            rootToEmails.get(root).add(email);
        }

        // Step 5: build result — sort emails, prepend name
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : rootToEmails.entrySet()) {
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            String name = emailToName.get(emails.get(0));
            emails.add(0, name); // prepend name
            result.add(emails);
        }

        return result;
    }
}