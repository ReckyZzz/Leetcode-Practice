package String;

import java.util.Scanner;

public class RepeatSubstring459 {
    /**
     * 给定一个非空的字符串 s ，检查是否可以通过由它的一个子串重复多次构成。
     * */
    public boolean repeatedSubstringPattern(String s) {
        //kmp思路，若是重复字符串，则最长相等前后缀不包含的部分就是重复的子串
        int[] next = getNext(s.toCharArray());
        //unit就是重复子串的长度，即最长相等前后缀不包含的部分
        int len = s.length();
        int unit = len - next[len - 1];
        //若s长度是单位子串长度的倍数，那么就是重复字符串，否则就不是
        if (next[len - 1] != 0 && len % unit == 0) {
            return true;
        }
        return false;
    }

    int[] getNext(char[] s) {
        int[] next = new int[s.length];
        int j = 0;

        for (int i = 1; i < s.length; i++) {
            //前后缀不相同的情况
            //j连续回退，所以是while
            while (j > 0 && s[i] != s[j]) {
                j = next[j - 1];
            }
            //前后缀相同的情况
            if (s[i] == s[j]) {
                j++;
            }
            //next赋值
            next[i] = j;
        }

        return next;
    }

    /**
     * 移动匹配思路：将s+s合并为ss，若是重复字串，则可以在ss的中间找到原字符串s
     * */
    public boolean repeatedSubstringPattern2(String s) {
        //得到ss之后去掉头和尾
        char[] ss = (s+s).toCharArray();
        char[] res = new char[2 * s.length() - 2];
        System.arraycopy(ss, 1, res, 0, res.length);
        String combined = String.valueOf(res);
        return combined.contains(s);
    }

    public static void main(String[] args) {
        RepeatSubstring459 substring459 = new RepeatSubstring459();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符串：");
        String s = scanner.nextLine();
        boolean res = substring459.repeatedSubstringPattern(s);
        if (res) {
            System.out.printf("%s是重复字符串\n", s);
        } else {
            System.out.printf("%s不是重复字符串\n", s);
        }
    }
}
