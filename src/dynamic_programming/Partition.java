package dynamic_programming;

/**
 * 416. 分割等和子集
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成
 * 两个子集，使得两个子集的元素和相等。思路：抽象为0-1背包问题
 * */
public class Partition {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for (int item : nums) {
            sum += item;
        }
        if (sum % 2 == 1)
            return false; // 若数组和为奇数，则不可能分成两个子集

        // dp[j]：容量为j的背包所能背的最大价值。nums[i]既是重量也是价值
        // 抽象为需要装满容量为target的背包，若dp[target] == target则说明可以
        int target = sum / 2;
        int[] dp = new int[target + 1];
        // 递推公式：dp[j] = max(dp[j], dp[j-nums[i]] + nums[i])
        // 初始化：dp[0]=0, 其他初始化为0，因为需要取max
        // 遍历顺序：先物品，后容量
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) { // 倒序遍历背包
                dp[j] = Integer.max(dp[j], dp[j-nums[i]] + nums[i]);
            }
        }
        return dp[target] == target;
    }
}
