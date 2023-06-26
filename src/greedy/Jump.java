package greedy;

/**
 * 55. 跳跃游戏
 *
 * 给定一个非负整数数组nums ，你最初位于数组的 第一个下标 。
 * 数组中的每个元素代表你在该位置可以跳跃的最大长度。
 * 判断你是否能够到达最后一个下标。
 * */
public class Jump {
    public boolean canJump(int[] nums) {
        if (nums.length == 1) return true;
        int cover = 0;
        // 局部最优：每遍历一个元素，就得到一个新的大覆盖范围。能够推出全局最优
        for (int i = 0; i <= cover; i++) {
            cover = Integer.max(i + nums[i], cover); // 取最大的覆盖范围
            if (cover >= nums.length - 1) // 覆盖范围覆盖到了最后一个元素
                return true;
        }
        return false;
    }
}
