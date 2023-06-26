package greedy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.ToIntFunction;

/**
 * 1005. K 次取反后最大化的数组和
 *
 * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
 *
 * 选择某个下标 i并将 nums[i] 替换为 -nums[i] 。
 * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
 *
 * 以这种方式修改数组后，返回数组 可能的最大和
 * */
public class KNegative {
    public int largestSumAfterKNegations(int[] nums, int k) {
        // 贪心：1 找绝对值最大的负数取反。2 全部取完之后再对最小的正数取反。
        // 数组按绝对值从大到小排序
        nums = Arrays.stream(nums)
                .boxed()
                .sorted((o1, o2) -> Math.abs(o2) - Math.abs(o1))
                .mapToInt(Integer::intValue)
                .toArray();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < 0 && k > 0) { // 碰到了最大的负数，取反
                nums[i] *= -1;
                k--;
            }
        }
        if (k % 2 == 1) { // k是奇数，则对最小的元素取反。k是偶数则总和不变。
            nums[nums.length - 1] *= -1;
        }
        return Arrays.stream(nums).sum();
    }

    public static void main(String[] args) {
        KNegative kNegative = new KNegative();
        int[] array = {0,2,-1,-3};
        System.out.println(kNegative.largestSumAfterKNegations(array, 3));
    }
}
