package greedy;

/**
 * 45. 跳跃游戏 II
 *
 * 给定一个长度为 n 的 0 索引整数数组 nums。初始位置为 nums[0]。
 * 每个元素 nums[i] 表示从索引 i 向前跳转的最大长度。
 * 换句话说，如果你在 nums[i] 处，你可以跳转到任意 nums[i + j] 处:
 * 0 <= j <= nums[i]
 * i + j < n
 *
 * 返回到达nums[n - 1] 的最小跳跃次数。生成的测试用例可以到达 nums[n - 1]。
 * */
public class Jump2 {
    public int jump(int[] nums) {
        if (nums.length == 1)
            return 0;
        // 贪心：每一步尽可能往远处跳
        int result = 0;
        int cur = 0; // 当前覆盖范围
        int max = 0; // 遍历过的最大的覆盖范围
        for (int i = 0; i < nums.length; i++) {
            max = Integer.max(i + nums[i], max); // 最远距离(当前距离和最远距离做比较)
            if (i == cur) {
                // 走到了当前覆盖范围的终点
                result++; // 再走一步
                cur = max; // 更新覆盖范围
                if (cur >= nums.length - 1) // 若新覆盖范围能走到终点，则跳出循环
                    break;
            }
        }
        return result;
    }
}
