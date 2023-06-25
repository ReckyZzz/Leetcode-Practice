package backtrack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * 39. 组合总和
 * 给你一个 无重复元素 的整数数组candidates 和一个目标整数target，找出candidates中可以使数字和为目标数target
 * 的所有不同组合，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 *
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 *
 * 对于给定的输入，保证和为target 的不同组合数少于 150 个。
 * */
public class CombineSum {
    List<List<Integer>> result = new ArrayList<>();
    List<Integer> path = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates); // 将candidates排序为升序
        backtracking(candidates, target, 0, 0);
        return result;
    }

    void backtracking(int[] candidates, int target, int sum, int startIndex) {
        if (sum == target) {
            // path的和等于目标和，收集结果
            result.add(new ArrayList<>(path));
            //注意要new一个新list放到result中。不new的话：result.add(path)，后续对path的修改会影响result的结果
            return;
        }

        for (int i = startIndex; i < candidates.length; i++) {
            if (sum + candidates[i] > target) // 剪枝：如果sum+当前元素>target，就没有必要继续遍历下去了
                return;
            path.add(candidates[i]);
            sum += candidates[i];
            backtracking(candidates, target, sum, i); // 下层递归从i开始，可以重复选取元素
            // 回溯
            path.remove(path.size() - 1);
            sum -= candidates[i];
        }
    }

    public static void main(String[] args) {
        CombineSum combineSum = new CombineSum();
        List<List<Integer>> lists = combineSum.combinationSum(new int[]{2, 3, 5}, 8);
        System.out.println(lists);
    }
}
