package dynamic_programming;

/**
 * 1049. 最后一块石头的重量 II
 *
 * 有一堆石头，用整数数组stones 表示。其中stones[i] 表示第 i 块石头的重量。
 * 每一回合，从中选出任意两块石头，然后将它们一起粉碎。假设石头的重量分别为x 和y，
 * 且x <= y。那么粉碎的可能结果如下：
 *
 * 如果x == y，那么两块石头都会被完全粉碎；
 * 如果x != y，那么重量为x的石头将会完全粉碎，而重量为y的石头新重量为y-x。
 * 最后，最多只会剩下一块 石头。返回此石头 最小的可能重量 。如果没有石头剩下，就返回 0。
 * */
public class LastRock {
    public int lastStoneWeightII(int[] stones) {
        /*
        * 思路：把石头分为重量之和尽可能相似的两堆，两堆相减就是所求的答案
        * 转化为0-1背包问题，容量为sum / 2
        * */
        int sum = 0;
        for (int e : stones) {
            sum += e;
        }
        int target = sum / 2;
        // dp[j]：容量为j时，背包的最大重量
        // 递推公式：dp[j]=max(dp[j], dp[j-weight[i]] + value[i])
        // 初始化：dp[0]=0, 其他非0的也初始化为0，因为要求max
        int[] dp = new int[target + 1];
        for (int i = 0; i < stones.length; i++) { // 先遍历物品
            for (int j = target; j >= stones[i]; j--) { // 后从大到小遍历背包
                dp[j] = Integer.max(dp[j], dp[j-stones[i]] + stones[i]);
            }
        }
        // 一堆石头：dp[target]，另一堆：sum-dp[target]
        return sum - 2 * dp[target];
    }
}
