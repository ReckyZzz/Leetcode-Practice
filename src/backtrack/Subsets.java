package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 78. 子集
 *
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 * 子集：都是组合
 * */
public class Subsets {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtracking(nums, 0);
        return result;
    }

    void backtracking(int[] nums, int startIndex) {
        result.add(new ArrayList<>(path)); // 每进入一次递归，就要收集结果
        if (startIndex >= nums.length) {
            // 递归到叶节点，结束
            return;
        }
        for (int i = startIndex; i < nums.length; i++) {
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
