import java.util.*;

class Solution {
    public int intersectionSizeTwo(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if (a[1] != b[1]) {
                return a[1] - b[1];       // sort by end ascending
            }
            return b[0] - a[0];           // if same end, start descending
        });

        int ans = 0;
        int first = -1, second = -1;

        for (int[] interval : intervals) {
            int start = interval[0];
            int end = interval[1];

            if (start > second) {
                // No selected numbers in this interval
                ans += 2;
                first = end - 1;
                second = end;
            } else if (start > first) {
                // Only one selected number in this interval
                ans += 1;
                first = second;
                second = end;
            }
        }

        return ans;
    }
}