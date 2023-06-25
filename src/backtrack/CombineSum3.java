package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 216. 组合总和 III
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 *
 * 只使用数字1到9
 * 每个数字最多使用一次（即不同的数字）
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 * */
public class CombineSum3 {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 0, 1);
        return result;
    }

    void backtracking(int k, int targetSum, int currentSum, int startIndex) {
        if (currentSum > targetSum) {
            // 剪枝：若当前和>目标和，则不继续回溯了
            return;
        }
        if (path.size() == k) {
            // 收集结果
            if (targetSum == currentSum) {
                // 若路径的和currentSum=目标和，才收集
                result.add(new ArrayList<>(path));
            }
            return; // 剪枝：若收集到的元素个数为k个，则返回，不继续向下搜索
        }
        int remain = k - path.size(); // 还需要多少个元素
        int searchSize = 9 - remain + 1; // 剪枝：最大的搜索下标
        for (int i = startIndex; i <= searchSize; i++) {
            currentSum += i;
            path.add(i);
            // 在[i+1, 9]中搜索
            backtracking(k, targetSum, currentSum, i + 1);
            // 回溯
            currentSum -= i;
            path.removeLast();
        }
    }

    public static void main(String[] args) {
        CombineSum3 combineSum = new CombineSum3();
        List<List<Integer>> lists = combineSum.combinationSum3(3, 9);

    }
}
