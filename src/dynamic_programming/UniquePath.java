package dynamic_programming;

/**
 * 62. 不同路径
 *
 * 一个机器人位于一个 m x n网格(m行，n列)的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * 问总共有多少条不同的路径？
 * */
public class UniquePath {
    public int uniquePaths(int m, int n) {
        // dp[i][j]的含义：从(0,0)到(i,j)的不同路径数，*而不是步数*
        int[][] dp = new int[m][n];
        // 递推公式：dp[i][j]=dp[i-1][j] + dp[i][j-1]
        // 初始化：最上方一行dp[0][j]，以及最左边一列dp[i][0]。
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        // 遍历顺序：从左往后，从上到下
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
