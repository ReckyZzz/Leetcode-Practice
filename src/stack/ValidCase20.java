package stack;

import java.util.Scanner;
import java.util.Stack;

/**
 * 栈部分第3题
 * 给定一个只包括 '('，')'，'{'，'}'，'['，']'的字符串 s ，判断字符串是否有效。
 *
 * 有效字符串需满足：
 *
 * 左括号必须用相同类型的右括号闭合。
 * 左括号必须以正确的顺序闭合。
 * 每个右括号都有一个对应的相同类型的左括号。
 * */
public class ValidCase20 {
    public boolean isValid(String s) {
        //共有三种情况：1. 左括号多了，2. 左右括号不匹配，3. 右括号多了
        Stack<Character> stack = new Stack<>();
        if (s.length() % 2 == 1)
            return false;
        for (int i = 0; i < s.length(); i++) {
            char cur = s.charAt(i);
            if (cur == '{') {
                stack.push('}');
            } else if (cur == '(') {
                stack.push(')');
            } else if (cur == '[') {
                stack.push(']');
            } else if (stack.empty() || stack.peek() != cur) {
                //若栈为空，则是第3种情况，栈的左右括号都匹配完了，但是还有新元素
                //若栈顶元素不等于当前元素，则是第2种情况
                return false;
            } else {
                stack.pop();
            }
        }
        //若栈为空则满足要求，若栈不为空则是第1种情况，左括号没有找到匹配的右括号
        return stack.empty();
    }

    public static void main(String[] args) {
        ValidCase20 validCase = new ValidCase20();
        System.out.println("请输入括号字符串");
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();
        if (validCase.isValid(s)) {
            System.out.printf("%s是有效字符串\n", s);
        } else {
            System.out.printf("%s不是有效字符串\n", s);
        }
    }
}
