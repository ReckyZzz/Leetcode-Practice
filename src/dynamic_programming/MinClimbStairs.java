package dynamic_programming;

/**
 * 746. 使用最小花费爬楼梯
 *
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。
 * 一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 *
 * 请你计算并返回达到楼梯顶部的最低花费。
 * */
public class MinClimbStairs {
    public int minCostClimbingStairs(int[] cost) {
        // dp的定义：dp[i]是达到第i阶所需的最小花费。因此dp[n]就是所求的值
        int n = cost.length;
        int[] dp = new int[n + 1];
        // 递推公式：dp[i] = min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2])
        // 初始化：dp[0]=0, dp[1]=0
        dp[0] = 0;
        dp[1] = 0;
        // 遍历顺序：从前往后
        for (int i = 2; i <= n; i++) {
            dp[i] = Integer.min(dp[i-1] + cost[i-1], dp[i-2] + cost[i-2]);
        }
        return dp[n];
    }
}
