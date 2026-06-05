package LC;
/*
Pattern : 
   1. Two Pointer
   2. Sorting (Sweep Line)
*/
public class MeetingAllocator 
{
    public static int minMeetingRooms(int[][] intervals) {
        int n = intervals.length;
        int[] start = new int[n];
        int[] end = new int[n];
        for (int i = 0; i < n; i++) {
            start[i] = intervals[i][0];
            end[i] = intervals[i][1];
        }
        java.util.Arrays.sort(start);
        java.util.Arrays.sort(end);
        int roomsRequired = 0, endPointer = 0;
        for (int i = 0; i < n; i++) {
            if (start[i] < end[endPointer]) {
                roomsRequired++;
            } else {
                endPointer++;
            }
        }
        return roomsRequired;
    }
    

    public static void main(String[] args) 
 {
    int[][] meetings = {{0,30},{5,10},{15,20}};
    System.out.println(minMeetingRooms(meetings));

 }
}
