package dynamic_programming;

import java.nio.file.Paths;

/**
 * 0-1背包问题
 * 背包容量为m，有n个物品，各有对应的重量与价值，每个物品仅能取一次
 * 求背包能装的最大价值？
 * */
public class ZeroBag {
    public static void bag(int[] weight, int[] value, int capacity) {
        int itemNumber = weight.length;
        int[][] dp = new int[itemNumber][capacity + 1];
        // dp[i][j]的含义：下标在[0,i]之间的物品，任取放进容量为j的背包的最大价值
        // 递推公式：1. 不放物品i，dp[i-1][j]；2. 放物品i，dp[i-1][j-wight[i]] + value[i]
        // 取1和2的最大值

        // dp的初始化:第0列和第0行，因为dp[i][j]是由上或左上角推出来的。非0下标不用初始化
        for (int j = 0; j <= capacity; j++) {
            // 初始化第0行，若物品0能放入背包，就放入背包，价值为value[0]
            if (capacity >= weight[0]) {
                dp[0][j] = value[0];
            }
        }
//        for (int i = 0; i < itemNumber; i++) {
//            // 初始化第0列，背包容量为0，无法放东西价值为0
//            dp[i][0] = 0;
//        }

        // 遍历：两层for循环分别遍历背包和物品，顺序可以颠倒
        for (int i = 1; i < itemNumber; i++) { // 物品
            for (int j = 1; j <= capacity; j++) { // 背包
                if (j < weight[i]) {
                    // 容量j放不下第i个物品
                    dp[i][j] = dp[i-1][j];
                } else {
                    // 放得下，取放入和不放入的最大值
                    dp[i][j] = Integer.max(dp[i - 1][j], dp[i - 1][j - weight[i]] + value[i]);
                }
            }
        }
        for (int i = 0; i < itemNumber; i++) {
            for (int j = 0; j <= capacity; j++) {
                System.out.print(dp[i][j] + " ");
            }
            System.out.println();
        }
    }

    /**
     * 一维dp数组
     * */
    public static void bagOneArray(int[] weight, int[] value, int capacity) {
        // 二维降为一维：不断更新一维数组的数据，就像在滚动，因此是滚动数组
        // dp[j]的含义：容量为j的背包，所能装的最大价值为dp[j]
        // 递推公式：dp[j] = max(dp[j], dp[j-weight[i]] + value[i])，不放和放
        int[] dp = new int[capacity + 1];
        int itemNumber = weight.length;
        // 初始化：dp[0]=0，非0的dp初始化为大于等于0的最小值即可
        // 因为需要求max，不能取大值，所以取0即可

        // 遍历顺序：倒序遍历，为了每个物品只被添加一次。正序遍历会导致一个物品拿了两次
        for (int i = 0; i < itemNumber; i++) { // 先遍历物品
            for (int j = capacity; j >= weight[i]; j--) { // 再遍历背包
                dp[j] = Integer.max(dp[j], dp[j-weight[i]] + value[i]);
            }
        }
        for (int e : dp) {
            System.out.print(e + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] weight =  {1,3,4};
        int[] value = {15,20,30};
        int capacity = 4;
        bag(weight, value, capacity);
        bagOneArray(weight, value, capacity);
    }
}
