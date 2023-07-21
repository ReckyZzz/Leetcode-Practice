package greedy;

import java.util.Arrays;

/**
 * 435. 无重叠区间
 * 给定一个区间的集合intervals，其中 intervals[i] = [starti, endi]。
 * 返回 需要移除区间的最小数量，使剩余区间互不重叠。
 * */
public class OverlapIntervals {
    public int eraseOverlapIntervals(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        int result = 0;
        // 区间按照左端点升序排序
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < intervals[i - 1][1]) {
                // i的左端点小于i-1的右端点，说明有重叠
                // 更新i的右区间为i和i-1的最小右区间，以便下次比较是否重叠
                result++;
                intervals[i][1] = Integer.min(intervals[i][1], intervals[i - 1][1]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        OverlapIntervals over = new OverlapIntervals();
        int[][] array = new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}};
        over.eraseOverlapIntervals(array);
    }
}
