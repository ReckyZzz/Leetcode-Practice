package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 90. 子集 II
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 * */
public class Subsets2 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        backtracking(nums, 0);
        return result;
    }

    void backtracking(int[] nums, int startIndex) {
        result.add(new ArrayList<>(path)); // 每进入一次递归就收获一次结果
        if (startIndex >= nums.length) return;
        for (int i = startIndex; i < nums.length; i++) {
            // 在同一个树层中，若当前元素与前一个元素相同时，跳过(不包含重复子集)
            if (i > startIndex && nums[i] == nums[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
        }
    }
}

/**
 * 使用used数组来去重
 * */
class Subsets2Used {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used;
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        used = new boolean[nums.length];
        Arrays.sort(nums);
        backtracking(nums, 0);
        return result;
    }

    void backtracking(int[] nums, int startIndex) {
        result.add(new ArrayList<>(path)); // 每进入一次递归就收获一次结果
        if (startIndex >= nums.length)
            return;
        for (int i = startIndex; i < nums.length; i++) {
            // 在同一个树层中，若当前元素与前一个元素相同时，跳过(不包含重复子集)
            if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }
            path.add(nums[i]);
            used[i] = true;
            backtracking(nums, i + 1);
            path.remove(path.size() - 1);
            used[i] = false;
        }
    }
}
