package LC;

import java.util.Arrays;
import java.util.PriorityQueue;

/*
Pattern:
1. Priority Queue (Min Heap)
2. Greedy
*/

public class MA_PQ 
{

    public static int minMeetingRooms(int[][] intervals) {

        if (intervals == null || intervals.length == 0) {
            return 0;
        }

        // Sort meetings based on start time
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        // Min Heap stores end times of ongoing meetings
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        // Allocate room for first meeting
        pq.offer(intervals[0][1]);

        // Process remaining meetings
        for (int i = 1; i < intervals.length; i++) {

            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];

            // If earliest ending meeting is finished,
            // reuse that room
            if (currentStart >= pq.peek()) {
                pq.poll();
            }

            // Allocate current meeting
            pq.offer(currentEnd);
        }

        // Number of rooms required
        return pq.size();
    }

    public static void main(String[] args) {

        int[][] meetings = {
                {0, 30},
                {5, 10},
                {15, 20}
        };

        System.out.println("Minimum Rooms Required: "
                + minMeetingRooms(meetings));
    }
}