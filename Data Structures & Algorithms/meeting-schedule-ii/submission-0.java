/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        int rooms = 0;
        int count = 0;
        List<Integer> start = new ArrayList<>();
        List<Integer> end = new ArrayList<>();
        for (Interval i : intervals) {
            start.add(i.start);
            end.add(i.end);
        }
        Collections.sort(start);
        Collections.sort(end);
        int i = 0;
        int j = 0;
        while (i < intervals.size() && j < intervals.size()) {
            if(i < intervals.size() && start.get(i) < end.get(j)) {
                count++;
                i++;
                if(count>rooms){
                    rooms = count;
                }
            }else{
                j++;
                count--;
            }
            
        }
        return rooms;
    }
}
