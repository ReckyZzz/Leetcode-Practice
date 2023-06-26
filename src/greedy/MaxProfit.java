package greedy;

/**
 * 122. 买卖股票的最佳时机 II
 *
 * 给你一个整数数组 prices ，其中prices[i] 表示某支股票第 i 天的价格。
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候最多只能持有 一股 股票。
 * 你也可以先购买，然后在 同一天 出售。
 *
 * 返回 你能获得的 最大 利润。
 * */
public class MaxProfit {
    public int maxProfit(int[] prices) {
        int result = 0;
        // 贪心：只收获正数利润，局部利润相加后全局利润也是最大的
        for (int i = 1; i < prices.length; i++) {
            // 只求每天的正数利润，若是负数则结果+0
            result += Integer.max(prices[i] - prices[i - 1], 0);
        }
        return result;
    }
}
