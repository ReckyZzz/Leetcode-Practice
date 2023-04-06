package String;

import java.util.Scanner;

public class ReverseWords151 {
    /**
     * 给你一个字符串 s ，请你反转字符串中 单词 的顺序。
     * 单词 是由非空格字符组成的字符串。s 中使用至少一个空格将字符串中的 单词 分隔开。
     * 返回 单词 顺序颠倒且 单词 之间用单个空格连接的结果字符串。
     *
     * 注意：输入字符串 s中可能会存在前导空格、尾随空格或者单词间的多个空格。
     * 返回的结果字符串中，单词间应当仅用单个空格分隔，且不包含任何额外的空格。
     * */
    public static String reverseWords(String s) {
        char[] chars = s.toCharArray();
        chars = removeSpaces(chars);
        reverse(chars, 0, chars.length - 1);
        reverseEachWord(chars);
        return new String(chars);
    }

    public static char[] removeSpaces(char[] chars) {
        //快慢指针, 快指针找非空元素，慢指针记录位置
        int slow = 0;
        for (int fast = 0; fast < chars.length; fast++) {
            if (chars[fast] != ' ') {
                //若slow不在初始位置，则在两个单词之间加上空格
                //若slow在初始位置，则直接赋值
                if (slow != 0) {
                    chars[slow] = ' ';
                    slow++;
                }
                //当快指针找到(连续)非空元素时，赋值给慢指针
                while (fast < chars.length && chars[fast] != ' ') {
                    chars[slow] = chars[fast];
                    slow++;
                    fast++;
                }
            }
        }
        char[] newChars = new char[slow];
        System.arraycopy(chars, 0, newChars, 0, slow);
        return newChars;
    }

    public static void reverseEachWord(char[] chars) {
        int start = 0;
        for (int end = 0; end < chars.length; end++) {
            //若遇到空格，则反转空格之前的单词
            if (chars[end] == ' ') {
                reverse(chars, start, end - 1);
                start = end + 1;
            }
            //若到结尾，则直接反转
            if (end == chars.length - 1) {
                reverse(chars, start, end);
            }
        }
    }

    public static void reverse(char[] chars, int start, int end){
        int left = start;
        int right = end;
        while (left < right){
            //swap left和right
            char temp = chars[left];
            chars[left] = chars[right];
            chars[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入字符串：");
        String input = scanner.nextLine();
        String res = reverseWords(input);
        System.out.println("结果：" + res);
    }
}
