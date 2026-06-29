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
        if (intervals.size() == 0 || intervals.size() == 1) {
            return intervals.size();
        }
        
        // sort with end
        Collections.sort(intervals, (a, b) -> a.end - b.end);
        
        int lastEnd = intervals.get(0).end;
        int rooms = 1;
        for (int i = 1; i < intervals.size(); i++) {
            Interval now = intervals.get(i);
            if (now.start < lastEnd) {
                rooms++;
            }

            lastEnd = now.end;
        }
        return rooms;
    }
}
