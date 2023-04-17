package Stack;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * 栈部分第5题，逆波兰表达式（其实就是二叉树的后序遍历表达）
 *
 * 给你一个字符串数组 tokens ，表示一个根据逆波兰表示法 表示的算术表达式。
 * 请你计算该表达式。返回一个表示表达式值的整数。
 * 注意：
 *
 * 有效的算符为 '+'、'-'、'*' 和 '/' 。
 * 每个操作数（运算对象）都可以是一个整数或者另一个表达式。
 * 两个整数之间的除法总是 向零截断 。
 * 表达式中不含除零运算。
 * 输入是一个根据逆波兰表示法表示的算术表达式。
 * 答案及所有中间计算结果可以用 32 位 整数表示。
 * */
public class RPN150 {
    public int evalRPN(String[] tokens) {
        Stack<Integer> stack = new Stack<>();
        for (String token : tokens) {
            int num1, num2;
            if (token.equals("+") || token.equals("-") || token.equals("*") || token.equals("/")) {
                num1 = stack.pop();
                num2 = stack.pop();
                //顺序为num2 operate num1，因为栈中的元素是反过来的
                if (token.equals("+"))
                    stack.push(num2 + num1);
                if (token.equals("-"))
                    stack.push(num2 - num1);
                if (token.equals("*"))
                    stack.push(num2 * num1);
                if (token.equals("/"))
                    stack.push(num2 / num1);
            } else {
                stack.push(Integer.valueOf(token));
            }
        }
        return stack.pop();
    }

    public static void main(String[] args) {
//        List<String> parameters = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        RPN150 rpn150 = new RPN150();

        System.out.println("请输入逆波兰表达式的长度：");
        int length = Integer.parseInt(scanner.nextLine());
        String[] parameters = new String[length];
        System.out.println("请输入逆波兰表达式，每行一个");
        for (int i = 0; i < length; i++) {
            parameters[i] = scanner.nextLine();
        }
        System.out.println("该逆波兰表达式的结果为:" + rpn150.evalRPN(parameters));
    }
}
