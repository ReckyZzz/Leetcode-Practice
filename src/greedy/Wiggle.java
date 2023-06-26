package greedy;

/**
 * 376. 摆动序列
 * 如果连续数字之间的差严格地在正数和负数之间交替，则数字序列称为 摆动序列 。
 * 第一个差（如果存在的话）可能是正数或负数。仅有一个元素或者含两个不等元素的序列也视作摆动序列。
 *
 * 例如，[1, 7, 4, 9, 2, 5] 是一个 摆动序列 ，因为差值 (6, -3, 5, -7, 3)是正负交替出现的。
 * 相反，[1, 4, 7, 2, 5]和[1, 7, 4, 5, 5] 不是摆动序列，
 * 第一个序列是因为它的前两个差值都是正数，第二个序列是因为它的最后一个差值为零。
 *
 * 子序列 可以通过从原始序列中删除一些（也可以不删除）元素来获得，剩下的元素保持其原始顺序。
 * 给你一个整数数组 nums ，返回 nums 中作为 摆动序列 的 最长子序列的长度 。
 * */
public class Wiggle {
    public int wiggleMaxLength(int[] nums) {
        if (nums.length == 1) // 长度为1，则只有1一个摆动
            return 1;
        if (nums.length == 2) {
            if (nums[0] != nums[1]) // 若长度为2且值不相等，则有2个摆动
                return 2;
            else
                return 1;
        }
        int result = 1; // 默认最后一个元素有摆动
        int prediff = 0;
        int curdiff = 0;
        for (int i = 0; i < nums.length - 1; i++) {
            curdiff = nums[i + 1] - nums[i];
            if (prediff >= 0 && curdiff < 0 || prediff <= 0 && curdiff > 0) {
                // cur和pre符号不同，则找到一个摆动
                // >=0或<=0表明有平坡
                result++;
                prediff = curdiff; // 在遇到摆动的时候才记录prediff，处理单调平坡的情况
            }
        }
        return result;
    }
}
