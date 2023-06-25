package backtrack;

import java.util.*;

/**
 * 491. 递增子序列
 * 给你一个整数数组 nums ，找出并返回所有该数组中*不同*的递增子序列，
 * 递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
 *
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 * 与子集II不同的地方：*不能对数组进行排序*
 * */
public class IncreaseSequence {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> findSubsequences(int[] nums) {
        backtracking(nums, 0);
        return result;
    }

    void backtracking(int[] nums, int startIndex) {
        if (path.size() > 1) {
            // path有起码两个元素，收获结果
            result.add(new ArrayList<>(path));
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = startIndex; i < nums.length; i++) {
            if (!path.isEmpty() && path.getLast() > nums[i] || set.contains(nums[i])) {
                // path里有元素，且大于当前遍历元素 或者 当前元素已经遍历过，则跳过本次循环
                continue;
            }
            set.add(nums[i]);
            path.add(nums[i]);
            backtracking(nums, i + 1);
            // 回溯，但不用removeSet中的元素
            // set只记录本层遍历过的元素，下一层会创建新的set
            path.removeLast();
        }
    }
}
