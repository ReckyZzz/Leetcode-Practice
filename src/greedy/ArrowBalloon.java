package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.ToIntFunction;

/**
 * 452. 用最少数量的箭引爆气球
 *
 * 有一些球形气球贴在一堵用 XY 平面表示的墙面上。墙面上的气球记录在整数数组points，其中points[i] = [xstart, xend]
 * 表示水平直径在xstart和xend之间的气球。你不知道气球的确切 y 坐标。
 * 一支弓箭可以沿着 x 轴从不同点 完全垂直 地射出。在坐标 x 处射出一支箭，若有一个气球的直径的开始和结束坐标为 xstart，xend，
 * 且满足 xstart≤ x ≤ xend，则该气球会被 引爆。可以射出的弓箭的数量 没有限制 。 弓箭一旦被射出之后，可以无限地前进。
 *
 * 给你一个数组 points ，返回引爆所有气球所必须射出的 最小 弓箭数。
 * */
public class ArrowBalloon {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0)
            return 0;
        int result = 1;
        // 贪心：重叠的气球数尽可能多，只用一支弓箭射爆所有重叠气球
        // 按气球的左边界进行升序排序
        Arrays.sort(points, (o1, o2) -> Integer.compare(o1[0], o2[0]));
        for (int i = 1; i < points.length; i++) {
            // i和i-1比较，从1开始
            if (points[i][0] > points[i - 1][1]) {
                // i的左边界大于i-1的右边界，说明i和i-1不重合
                result++;
            } else {
                // i和i-1有重合，则更新i的右边界为min(i右，i-1右)
                // 更新之后第i+1个气球就可以继续判断是否重合
                points[i][1] = Math.min(points[i][1], points[i - 1][1]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        ArrowBalloon a = new ArrowBalloon();
        int[][] array = new int[][]{{-2147483646,-2147483645},{2147483646,2147483647}};
        a.findMinArrowShots(array);
    }
}
