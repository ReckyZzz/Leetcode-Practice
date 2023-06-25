package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 131. 分割回文串
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 *
 * 回文串 是正着读和反着读都一样的字符串。
 * */
public class Partition {
    List<List<String>> result = new ArrayList<>();
    List<String> path = new ArrayList<>();
    public List<List<String>> partition(String s) {
        backtracking(s, 0);
        return result;
    }

    void backtracking(String s, int startIndex) {
        if (startIndex >= s.length()) {
            // 切割到末尾了，收集结果
            result.add(new ArrayList<>(path));
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            // 子串的范围：[startIndex, i]
            if (isPalindrome(s, startIndex, i)) {
                // 若子串是回文，将子串加入path
                path.add(s.substring(startIndex, i + 1));
            } else {
                continue;
            }
            // 递归
            backtracking(s, i + 1);
            // 回溯
            path.remove(path.size() - 1);
        }
    }

    boolean isPalindrome(String s, int start, int end) {
        while (end >= start) {
            if (s.charAt(start) != s.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
