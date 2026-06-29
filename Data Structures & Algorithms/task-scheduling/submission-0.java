class Solution {
    public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer>map = new HashMap<>();
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for(int i =0; i < tasks.length; i++){
            map.merge(tasks[i],1,Integer::sum);
        }
        for(char c: map.keySet()){
            maxHeap.add(map.get(c));
        }
        int maxFreq = maxHeap.peek();

        int countMaxFreq = 0;
        for (int freq : map.values()) {
            if (freq == maxFreq) {
                countMaxFreq++;
            }
        }

        return Math.max(tasks.length, (maxFreq-1)*(n+1)+countMaxFreq);
    }
}
