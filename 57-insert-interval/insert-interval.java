
class Solution {

    public int[][] insert(int[][] intervals, int[] newInterval) {

        List<int[]> list = new ArrayList<>();

        int start = newInterval[0];
        int end = newInterval[1];

        for (int i = 0; i < intervals.length; i++) {

            if (intervals[i][1] < start) {
                list.add(intervals[i]);
            }

            else if (intervals[i][0] > end) {
                list.add(new int[]{start, end});

                for (int j = i; j < intervals.length; j++) {
                    list.add(intervals[j]);
                }

                return list.toArray(new int[list.size()][]);
            }

            else {
                start = Math.min(start, intervals[i][0]);
                end = Math.max(end, intervals[i][1]);
            }
        }

        list.add(new int[]{start, end});

        return list.toArray(new int[list.size()][]);
    }
}

