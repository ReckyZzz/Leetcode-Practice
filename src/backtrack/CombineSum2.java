package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 40. 组合总和 II
 * 给定一个候选人编号的集合candidates和一个目标数target，
 * 找出candidates中所有可以使数字和为target的组合。
 *
 * candidates中的每个数字在每个组合中只能使用一次。
 *
 * 注意：解集不能包含重复的组合。
 * candidates中有重复元素
 * */
public class CombineSum2 {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    boolean[] used; // used 标记使用过的元素的下标
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        used = new boolean[candidates.length];
        Arrays.sort(candidates); // candidates升序排序
        backtracking(candidates, target, 0, 0);
        return result;
    }

    void backtracking(int[] candidates, int target, int sum, int startIndex) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        // 去重的关键：树层去重，所以在for循环里做
        for (int i = startIndex; i < candidates.length; i++) {
            if (sum + candidates[i] > target) return; // 剪枝
            if (i > 0 && candidates[i] == candidates[i - 1] && !used[i - 1]) {
                // 去重：i和i-1相同，并且i-1在当前分支里未被使用(确保是树层的状态，而不是树枝)
                continue;
            }
            path.add(candidates[i]);
            sum += candidates[i];
            used[i] = true;
            backtracking(candidates, target, sum, i + 1);
            // 回溯
            path.remove(path.size() - 1);
            sum -= candidates[i];
            used[i] = false;
        }
    }
}

/**
 * 不用used的写法，只使用startIndex/
 * */
class CombineSum2Simple {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates); // candidates升序排序
        backtracking(candidates, target, 0, 0);
        return result;
    }

    void backtracking(int[] candidates, int target, int sum, int startIndex) {
        if (sum == target) {
            result.add(new ArrayList<>(path));
            return;
        }
        // 去重的关键：树层去重，所以在for循环里做
        for (int i = startIndex; i < candidates.length; i++) {
            if (sum + candidates[i] > target) return; // 剪枝
            if (i > startIndex && candidates[i] == candidates[i - 1]) {
                // 去重：i和i-1相同，则跳过同一树层使用过的元素
                continue;
            }
            path.add(candidates[i]);
            sum += candidates[i];
            backtracking(candidates, target, sum, i + 1);
            // 回溯
            path.remove(path.size() - 1);
            sum -= candidates[i];
        }
    }
}
