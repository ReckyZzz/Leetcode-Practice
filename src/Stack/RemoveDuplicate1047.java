package Stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * 栈部分第4题
 * 给出由小写字母组成的字符串S，重复项删除操作会选择两个相邻且相同的字母，并删除它们。
 *
 * 在 S 上反复执行重复项删除操作，直到无法继续删除。
 *
 * 在完成所有重复项删除操作后返回最终的字符串。答案保证唯一。
 * */
public class RemoveDuplicate1047 {
    public String removeDuplicates(String s) {
        //用字符串模拟栈
//        Stack<Character> stack = new Stack<>();
        StringBuilder res = new StringBuilder();
        //top为res的长度
        int top = -1;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            //若字符串非空，且栈顶字符等于当前字符，则pop（删除顶部元素）
            if (top >= 0 && res.charAt(top) == ch) {
                res.deleteCharAt(top);
                top--;
            } else {
                res.append(ch);
                top++;
            }
        }
        return res.toString();
    }

    public String removeDuplicatesStack(String s) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (!stack.empty() && stack.peek() == ch) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }
        //将栈的元素取出，重新排序
        String res = "";
        while (!stack.empty()) {
            //注意不是res + pop
            res = stack.pop() + res;
        }
        return res;
    }

    public static void main(String[] args) {
        RemoveDuplicate1047 removeDuplicate = new RemoveDuplicate1047();
        System.out.println("请输入字符串");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
//        System.out.println("remove的结果为：" + removeDuplicate.removeDuplicates(s));
        System.out.println("remove的结果为：" + removeDuplicate.removeDuplicatesStack(s));
    }
}
