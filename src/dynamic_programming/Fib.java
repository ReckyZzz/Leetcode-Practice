package dynamic_programming;

/**
 * 509. 斐波那契数
 * 斐波那契数 （通常用 F(n) 表示）形成的序列称为 斐波那契数列 。
 * 该数列由 0 和 1 开始，后面的每一项数字都是前面两项数字的和。也就是：
 *
 * F(0) = 0，F(1) = 1
 * F(n) = F(n - 1) + F(n - 2)，其中 n > 1
 * 给定 n ，请计算 F(n) 。
 * */
public class Fib {
    public int fibRecursive(int n) {
        if (n == 0)
            return 0;
        else if (n == 1)
            return 1;
        else
            return fibRecursive(n - 1) + fibRecursive(n - 2);
    }

    /**
     * 动态规划法
     * */
    public int fib(int n) {
        // 1. 确定dp数组和下标的含义：dp[i]为第i个斐波那契数值
        // 2. 确定递推公式：dp[i] = dp[i-1] + dp[i-2]
        // 3. dp数组的初始化：dp[0]=0, dp[1]=1
        // 4. 遍历顺序：从前向后
        // 5. 打印dp数组(debug)
        if (n == 0 || n == 1) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        for (int i = 2;i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
        // 或是sum = dp[0] + dp[1]
        // dp[0] = dp[1]
        // dp[1] = sum
    }
}
