package leetcode;

import java.util.Arrays;
import java.util.Comparator;

public class Hard_2402_MeetingsRoom3 {

    public static void main(String[] args) {
//        System.out.println(mostBooked(4, new int[][]{{18, 19}, {3, 12}, {17, 19}, {2, 13}, {7, 10}}) == 0);
        System.out.println(mostBooked(3, new int[][]{{1, 20}, {2, 10}, {3, 5}, {4, 9}, {6, 8}}) == 1);
//        System.out.println(mostBooked(2, new int[][]{{0, 10}, {1, 5}, {2, 7}, {3, 4}}) == 0);
    }

    public static int mostBooked(int n, int[][] meetings) {
        Arrays.sort(meetings, Comparator.comparingInt(o -> o[0]));
        int[] occupied = new int[n];
        int[] meetingCount = new int[n];
        int popularRoom = 0;
        for (int[] meeting : meetings) {
            int freeRoom = 0;
            for (int j = 0; j < n; j++) {
                if (occupied[j] <= meeting[0]) {
                    freeRoom = j;
                    break;
                } else if (occupied[j] < occupied[freeRoom]) {
                    freeRoom = j;
                }
            }
            occupied[freeRoom] = Math.max(meeting[1], occupied[freeRoom] + meeting[1] - meeting[0]);
            meetingCount[freeRoom]++;

            if (meetingCount[freeRoom] > meetingCount[popularRoom]
                    || meetingCount[freeRoom] == meetingCount[popularRoom] && freeRoom < popularRoom) {
                popularRoom = freeRoom;
            }
        }
        System.out.println(popularRoom);
        return popularRoom;
    }
}
