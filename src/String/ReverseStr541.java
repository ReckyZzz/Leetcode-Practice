package String;

import java.util.Arrays;

/**
 * 字符串部分第2题
 * 给定一个字符串 s 和一个整数 k，从字符串开头算起，每计数至 2k 个字符，就反转这 2k 字符中的前 k 个字符。
 *
 * 如果剩余字符少于 k 个，则将剩余字符全部反转。
 * 如果剩余字符小于 2k 但大于或等于 k 个，则反转前 k 个字符，其余字符保持原样。
 * */
public class ReverseStr541 {
    public String reverseStr(String s, int k){
        //每2k个进行一次处理
        char[] charStr = s.toCharArray();
        for (int i = 0; i < s.length(); i += 2 * k){
            //若剩下的字符串够k个字符，进行反转
            if (i + k <= s.length()){
                reverse(charStr, i, i + k - 1);
                continue;
            }
            //对尾部不足k个字符的字符串进行翻转
            reverse(charStr, i, s.length() - 1);
        }
        return String.valueOf(charStr);
    }

    /**
     * 反转start到end之间的字符串
     * @param charStr char数组
     * @param start 起始位置下标
     * @param end 终止位置下标
     * */
    public void reverse(char[] charStr, int start, int end){
        int left = start;
        int right = end;
        while (left < right){
            //swap left和right
            char temp = charStr[left];
            charStr[left] = charStr[right];
            charStr[right] = temp;

            left++;
            right--;
        }
    }

    public static void main(String[] args) {
        String s = "abcdefg";
        int k = 2;
        ReverseStr541 reverseStr = new ReverseStr541();
        String res = reverseStr.reverseStr(s, k);
        System.out.println(res);
    }
}
