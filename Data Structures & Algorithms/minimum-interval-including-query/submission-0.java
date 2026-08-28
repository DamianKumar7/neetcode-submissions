class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));

        int[][] sortedQueries = new int[queries.length][2];

        for (int i = 0; i < queries.length; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));

        int[] ans = new int[queries.length];


        PriorityQueue<int[]> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a[0], b[0])
        );

        int intervalIndex = 0;

        for (int[] query : sortedQueries) {

            int q = query[0];

            while (intervalIndex < intervals.length &&
                   intervals[intervalIndex][0] <= q) {

                int left = intervals[intervalIndex][0];
                int right = intervals[intervalIndex][1];

                int length = right - left + 1;

                pq.offer(new int[]{length, right});

                intervalIndex++;
            }

            while (!pq.isEmpty() && pq.peek()[1] < q) {
                pq.poll();
            }

            if (!pq.isEmpty()) {
                ans[query[1]] = pq.peek()[0];
            } else {
                ans[query[1]] = -1;
            }
        }

        return ans;
    }
}