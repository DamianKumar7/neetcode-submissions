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
    public boolean canAttendMeetings(List<Interval> intervals) {
        Collections.sort(intervals,(a,b)-> a.start-b.start);
        if(intervals.size() <= 1)return true;
        int start = intervals.get(0).start;
        int end = intervals.get(0).end;
        List<Interval>res = new ArrayList<>();

        for(int i =1; i <intervals.size(); i++){
            Interval k = intervals.get(i);
            if(end > k.start){
                end = Math.max(end, k.end);
            }else{
                res.add(new Interval(start,end));
                start = k.start;
                end = k.end;
            }
        }
        res.add(new Interval(start,end));
        return (res.size()==intervals.size());

    }
}
