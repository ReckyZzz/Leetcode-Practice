package Stack;

import java.util.Stack;

/**
 * 栈部分第1题
 * leetcode 232. 用栈实现队列
 * 请你仅使用两个栈实现先入先出队列。队列应当支持一般队列支持的所有操作（push、pop、peek、empty）：
 *
 * 实现 MyQueue 类：
 *
 * void push(int x) 将元素 x 推到队列的末尾
 * int pop() 从队列的开头移除并返回元素
 * int peek() 返回队列开头的元素
 * boolean empty() 如果队列为空，返回 true ；否则，返回 false
 * 说明：
 *
 * 你 只能 使用标准的栈操作 —— 也就是只有push to top,peek/pop from top,size, 和is empty操作是合法的。
 * 你所使用的语言也许不支持栈。你可以使用 list 或者 deque（双端队列）来模拟一个栈，只要是标准的栈操作即可。
 *
 * */
public class MyQueue {
    /**入栈存放push元素*/
    Stack<Integer> stackIn;
    /**出栈在弹出元素时使用，负责变换元素顺序*/
    Stack<Integer> stackOut;

    public MyQueue() {
        stackIn = new Stack<>();
        stackOut = new Stack<>();
    }

    public void push(int x) {
        stackIn.push(x);
    }

    public int pop() {
        //先把栈的顺序变换之后，再弹出
        dumpStackIn();
        return stackOut.pop();
    }

    public int peek() {
        //先把栈的顺序变换之后，再查询栈顶元素
        dumpStackIn();
        return stackOut.peek();
    }

    public boolean empty() {
        return stackIn.empty() && stackOut.empty();
    }

    //将入栈的元素导入出栈
    public void dumpStackIn() {
        //若出栈不为空，则返回，出栈不为空时不需要压入元素
        if (!stackOut.empty()) return;
        //若出栈为空，则把入栈的所有元素压入出栈
        while (!stackIn.empty()) {
            stackOut.push(stackIn.pop());
        }
    }
}
