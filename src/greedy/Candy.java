package greedy;

import java.util.Arrays;

/**
 * 135. 分发糖果
 *
 * n 个孩子站成一排。给你一个整数数组 ratings 表示每个孩子的评分。
 * 你需要按照以下要求，给这些孩子分发糖果：
 *
 * 每个孩子至少分配到 1 个糖果。
 * 相邻两个孩子评分更高的孩子会获得更多的糖果。
 * 请你给每个孩子分发糖果，计算并返回需要准备的 最少糖果数目 。
 * */
public class Candy {
    public int candy(int[] ratings) {
        int[] candies = new int[ratings.length];
        Arrays.fill(candies, 1);
        // 既要和左边比较，又要和右边比较，因此一次只比较一边
        // 1.从数组开头向右比较：右孩子比左孩子大
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i] > ratings[i - 1]) {
                // 若右边的评分大于左边
                candies[i] = candies[i - 1] + 1;
            }
        }

        // 2.从数组结尾向左比较：左孩子比右孩子大
        for (int i = ratings.length - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                // 若左孩子的评分大于右孩子
                // 当前孩子拿到的糖果数应为左孩子和右孩子的最大值
                candies[i] = Integer.max(candies[i + 1] + 1, candies[i]);
            }
        }
        return Arrays.stream(candies).sum();
    }
}
