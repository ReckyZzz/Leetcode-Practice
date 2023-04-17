package String;

import java.util.Scanner;

/**
 * 字符串部分第4题，KMP算法
 * 给定一个子串，判断在另一个字符串中是否出现该子串，若出现则返回出现的下标
 * 给你两个字符串haystack 和 needle ，请你在 haystack 字符串中找出 needle 字符串的第一个匹配项的下标（下标从 0 开始）。
 * 如果needle 不是 haystack 的一部分，则返回-1 。
 * */
public class KMP28 {
    public int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        int[] next = getNext(needle.toCharArray());
        //i遍历主串，j遍历子串
        int j = 0;
        for (int i = 0; i < haystack.length(); i++) {
            while (j > 0 && haystack.charAt(i) != needle.charAt(j)) {
                j = next[j - 1];
            }
            if (haystack.charAt(i) == needle.charAt(j)) {
                j++;
            }
            //若j等于needle的长度，即找到了这样一个字串
            // 则返回i减去字串长度+1的位置，即子串在主串种的起始位置
            if (j == needle.length()) {
                return (i - needle.length() + 1);
            }
        }
        return -1;
    }

    /**
     * 获取next数组，其中j是前缀末尾(也是i及i之前的字串的最长相等前后缀的长度)
     * i是后缀末尾
     * next数组为最长相等前后缀的长度
     * */
    int[] getNext(char[] s) {
        int[] next = new int[s.length];
        int j = 0;
        //从1开始，next[0]为0
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
            //next赋值，j是最长相等前后缀的长度
            next[i] = j;
        }

        return next;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("请输入字符串：");
        String father = in.nextLine();
        System.out.println("请输入要匹配的字符串：");
        String son = in.nextLine();
        KMP28 kmp28 = new KMP28();
        int res = kmp28.strStr(father, son);
        if (res > 0) {
            System.out.printf("%s在%s中出现的位置为:%d\n", son, father, res);
        } else {
            System.out.printf("%s在%s中并未出现\n", son, father);
        }
    }
}
