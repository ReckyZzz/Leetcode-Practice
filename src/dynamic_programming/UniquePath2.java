package dynamic_programming;

/**
 * 63. 不同路径 II
 *
 * 一个机器人位于一个m x n网格的左上角 （起始点在下图中标记为 “Start” ）。
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 * */
public class UniquePath2 {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m-1][n-1] == 1)
            return 0; // 起始/终止位置有障碍，直接返回0(不可达)
        // dp[i][j]的含义：从(0,0)到(i,j)的不同路径数，不是步数
        int[][] dp = new int[m][n];
        // 初始化：第0行和第0列设为1。遇到障碍时，障碍及之后的都为0
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 1) {
                // 遇到障碍时，将路径数设为0，后续的路径也为0
                break;
            }
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 1) {
                break;
            }
            dp[0][j] = 1;
        }
        // 遍历顺序：从左到右，从上到下
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (obstacleGrid[i][j] == 1)
                    continue; // 遇到障碍时设为0
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[m-1][n-1];
    }
}
