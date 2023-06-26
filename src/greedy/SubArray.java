package greedy;

/**
 * 53. 最大子数组和
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组
 * （子数组最少包含一个元素），返回其最大和。
 *
 * 子数组 是数组中的一个连续部分。
 * */
public class SubArray {
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE; // 求最大值
        int sum = 0;
        // 贪心：连续和是负数时直接抛弃，因为它只会让和变小
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > result)
                result = sum;
            if (sum < 0) // 若连续和为0，则起始位置设为下一位，同时和归零
                sum = 0;
        }
        return result;
    }
}
