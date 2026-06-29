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
        if (intervals.size() == 0 || intervals.size() == 1) return true;

        // sort the collection first in order of start time
        Collections.sort(intervals, (a, b) -> a.start - b.start);

        // a variable to track last end
        int lastEnd = intervals.get(0).end;
        for (int i = 1; i < intervals.size(); i++) {
            Interval now = intervals.get(i); 
            if (now.start < lastEnd) return false;

            lastEnd = now.end;
        }

        return true;

    }
}
