package interviewbit;

import java.util.*;

public class MeetingRooms {

    public static void main(String[] args) {

        Interval[] intervals = new Interval[6];
        intervals[0] = new Interval(1, 18);
        intervals[1] = new Interval(18, 23);
        intervals[2] = new Interval(15, 29);
        intervals[3] = new Interval(4, 15);
        intervals[4] = new Interval(2, 11);
        intervals[5] = new Interval(5, 13);

        System.out.println("Min no of meeting rooms required is " + findMinNoOfMeetingRooms(intervals));

    }

    public static int findMinNoOfMeetingRooms(Interval[] intervals) {
        if (intervals == null || intervals.length == 0)
            return 0;
        Arrays.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i1, Interval i2) {
                return i1.start - i2.start;
            }
        });
        PriorityQueue<Integer> queue = new PriorityQueue<>();
        int count = 1;
        queue.offer(intervals[0].end);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i].start < queue.peek()) {
                count++;
            } else {
                queue.poll();
            }
            queue.offer(intervals[i].end);
        }

        return count;
    }

    static class Interval {
        int start;
        int end;

        public Interval(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}
