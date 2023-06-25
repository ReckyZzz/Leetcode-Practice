package backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * 93. 复原 IP 地址
 * 有效 IP 地址 正好由四个整数（每个整数位于 0 到 255 之间组成，且不能含有前导 0），整数之间用 '.' 分隔。
 *
 * 例如："0.1.2.201" 和 "192.168.1.1" 是 有效 IP 地址，
 * 但是 "0.011.255.245"、"192.168.1.312" 和 "192.168@1.1" 是 无效 IP 地址。
 *
 * 给定一个只包含数字的字符串 s ，用以表示一个 IP 地址，返回所有可能的有效 IP 地址，
 * 这些地址可以通过在 s 中插入'.' 来形成。你 不能重新排序或删除 s 中的任何数字。你可以按 任何 顺序返回答案
 * */
public class RestoreIP {
    List<String> result = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        StringBuilder sb = new StringBuilder(s);
        backtracking(sb, 0, 0);
        return result;
    }

    /**
     * @param pointSum 打了逗点.的数量
     * */
    void backtracking(StringBuilder s, int startIndex, int pointSum) {
        if (pointSum == 3) {
            // 若打了.的数量为3，判断剩下的部分是否符合ip地址的要求
            if (isValid(s, startIndex, s.length() - 1)) {
                result.add(s.toString());
            }
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            // 切割子串[startIndex, i]
            if (isValid(s, startIndex, i)) {
                // 若子串是合法ip，在i的位置插入.符号
                s.insert(i + 1, '.'); // 加入逗点.
                pointSum++;
                backtracking(s, i + 2, pointSum); // 加了一个.因此是加2
                // 回溯
                pointSum--;
                s.deleteCharAt(i + 1); //回溯删除逗点.
            } else {
                return;
            }
        }
    }

    /**
     * 判断区间[start, end]构成的数字是否合法(0<=s<=255)
     * */
    boolean isValid(StringBuilder s, int start, int end) {
        if (start > end) // 区间不合法
            return false;
        if (s.charAt(start) == '0' && start != end) // 以0开头，但不只一位，不合法
            return false;
        int num = 0;
        for (int i = start; i <= end; i++) {
            int digit = s.charAt(i) - '0';
            num = num * 10 + digit;
            if (num > 255)
                return false;
        }
        return true;
    }
}

class testIP {
    List<String> result = new ArrayList<>();
    public List<String> restoreIpAddresses(String s) {
        backtracking(new StringBuilder(s), 0, 0);
        return result;
    }

    void backtracking(StringBuilder s, int startIndex, int points) {
        if (points == 3) {
            // 若打了.的数量为3，判断剩下的部分是否符合ip地址的要求
            if (isValid(s, startIndex, s.length() - 1)) {
                result.add(s.toString());
            }
            return;
        }
        for (int i = startIndex; i < s.length(); i++) {
            // [startIndex, i]
            if (isValid(s, startIndex, i)) {
                s.insert(i + 1, ".");
                points++;
                backtracking(s, i + 2, points);
                points--;
                s.deleteCharAt(i + 1);
            } else {
                return;
            }
        }
    }

    // [start, end]
    boolean isValid(StringBuilder s, int start, int end) {
        if (start > end) return false;
        if (s.charAt(start) == '0' && end > start) // 以0开头，但不只一位
            return false;
        int sum = 0;
        for (int i = start; i <= end; i++) {
             int digit = s.charAt(i) - '0';
             sum = sum * 10 + digit;
             if (sum > 255)
                 return false;
        }
        return true;
    }
}
