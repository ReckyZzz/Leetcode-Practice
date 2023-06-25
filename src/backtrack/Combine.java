package backtrack;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * 77. 组合
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * 你可以按 任何顺序 返回答案。
 * */
public class Combine {
    List<List<Integer>> result = new ArrayList<>();
    LinkedList<Integer> path = new LinkedList<>();
    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return result;
    }

    /**
     * 从集合中选取元素，可选择的范围随着选择的进行而搜索，调整可选择的范围
     * startIndex记录集合开始遍历的位置
     * */
    private void backtracking(int n, int k, int startIndex) {
        if (path.size() == k) {
            // 找到一个大小为k的组合，收集结果，返回
            result.add(new ArrayList<>(path));
            return;
        }
        int remain = k - path.size(); // 还需要多少个元素
        int searchSize = n - remain + 1; // 剪枝边界：i最多循环到这个下标，才能找齐k个元素
        // 单层搜索过程[i, n]
        for (int i = startIndex; i <= searchSize; i++) {
            path.add(i);
            // 下一层递归从i+1开始
            backtracking(n, k, i + 1);
            // 回溯
            path.removeLast();
        }
    }
}
