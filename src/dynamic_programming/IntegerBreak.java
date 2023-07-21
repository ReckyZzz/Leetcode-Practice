package dynamic_programming;

/**
 * 343. 整数拆分
 * 给定一个正整数 n ，将其拆分为 k 个 正整数 的和（ k >= 2 ），并使这些整数的乘积最大化。
 *
 * 返回 你可以获得的最大乘积 。
 * */
public class IntegerBreak {
    public int integerBreak(int n) {
        int[] dp = new int[n + 1];
        // dp的含义：对i进行拆分，得到最大乘积为dp[i]
        // 递推：dp[i] = max(j * (i - j),  j * dp[i-j])，两个数的情况、大于等于三个数的情况
        // 初始化：dp[0] = 0，dp[1] = 0，dp[2] = 1
        dp[0] = 0;
        dp[1] = 0;
        dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            for (int j = 1; j <= i/2; j++) {
                // j从1开始，拆分i。j的范围至多到i/2，再大也没有意义了
                // 只有拆成m个近似相同的数才能得到最大值
                dp[i] = max(j * (i-j), j * dp[i-j], dp[i]);
            }
        }
        return dp[n];
    }

    private int max(int a, int b, int c) {
        if (a > b)
            return Integer.max(a, c);
        else
            return Integer.max(b ,c);
    }
}
