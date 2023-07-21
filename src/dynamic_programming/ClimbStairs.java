package dynamic_programming;

/**
 * 70. 爬楼梯
 *
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 * */
public class ClimbStairs {
    public int climbStairs(int n) {
        // dp[i]的含义:达到第i阶有dp[i]种方式
        int[] dp = new int[n + 1];
        // 递推：dp[i] = dp[i - 1] + dp[i - 2]。在i-1阶走1阶到i，在i-2阶走2阶到i
        // dp[0]无意义，不初始化
        if (n == 1 || n == 2) {
            return n;
        }
        dp[1] = 1;
        dp[2] = 2;
        // 遍历顺序：从前到后
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}
