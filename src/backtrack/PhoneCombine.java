package backtrack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 17. 电话号码的字母组合
 * 给定一个仅包含数字2-9的字符串，返回所有它能表示的字母组合。答案可以按 任意顺序 返回。
 *
 * 给出数字到字母的映射如下（与电话按键相同）。注意 1 不对应任何字母。
 * 2-abc 3-def 4-ghi 5-jkl
 * 6-mno 7-pqrs 8-tuv 9-wxyz
 * */
public class PhoneCombine {
    // 使用String数组做映射
    String[] letterMap = {"", "", "abc", "def", "ghi", "jkl",
        "mno", "pqrs", "tuv", "wxyz"};
    List<String> result = new ArrayList<>();
    StringBuilder path = new StringBuilder();
    public List<String> letterCombinations(String digits) {
        if (digits == null || digits.length() == 0)
            return result;
        backtracking(digits, 0);
        return result;
    }

    /**
     * 与组合问题不同的地方：不需要startIndex
     * 因为本题是在两个集合中选择字符串，而不是在一个集合中
     * @param index 表示当前递归到的数字的下标
     * */
    void backtracking(String digits, int index) {
        if (index == digits.length()) {
            // index下标等于\0的下标时，即遍历到digits最后时：终止，收获结果
            result.add(path.toString());
            return;
        }
        int digit = digits.charAt(index) - '0'; // digits的数字转为int
        String letters = letterMap[digit]; // 数字对应的字符串
        for (int i = 0; i < letters.length(); i++) {
            path.append(letters.charAt(i));
            // 向下层递归
            backtracking(digits, index + 1);
            // 回溯
            path.deleteCharAt(path.length() - 1);
        }
    }
}
