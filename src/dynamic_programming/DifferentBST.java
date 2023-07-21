package dynamic_programming;

/**
 * 96. 不同的二叉搜索树
 *
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n
 * 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 * */
public class DifferentBST {
    public int numTrees(int n) {
        // dp的含义：dp[i]为由1到i的节点组成的不同二叉搜索树的种类数
        int[] dp = new int[n + 1];
        // 递推公式：dp[i] = sum(以j为头结点的树的种类数)，j从1到i
        // 比如dp[3] = dp[0]*dp[2] + dp[1]*dp[1] + dp[2][0]
        // 初始化：dp[0]=1, dp[1]=1, dp[2]=2
        dp[0] = 1;
        dp[1] = 1;
        // 遍历顺序：从小到大，dp[i]依赖于小于i的值
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                // j为头结点，左子树有dp[j-1]种，右子树有dp[i-j]种
                dp[i] += dp[j-1] * dp[i-j];
            }
        }
        return dp[n];
    }
}
