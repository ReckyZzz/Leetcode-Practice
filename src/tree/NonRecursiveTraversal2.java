package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * 二叉树的非递归遍历（统一写法）
 * 具体思路就是将要处理的节点放入栈之后，放入一个空指针作为标记
 * */
public class NonRecursiveTraversal2 {
    List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null)
            stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.peek();
            if (node != null) {
                //栈顶的元素不为空，说明没有标记，需要入栈
                stack.pop(); //将该节点弹出，避免重复处理
                //中左右，但入栈顺序为右左中
                if (node.right != null) stack.push(node.right); //添加右节点，空节点不入栈
                if (node.left != null) stack.push(node.left); //添加左节点，空节点不入栈

                stack.push(node); //中
                stack.push(null); //中节点访问过，但是未被处理，添加null作为标记
            } else {
                //栈顶的元素为空，则说明要进行处理
                stack.pop(); //将空元素弹出
                node = stack.pop();
                res.add(node.val);
            }
        }
        return res;
    }

    List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null)
            stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.peek();
            if (node != null) {
                //栈顶的元素不为空，说明没有标记，需要入栈
                stack.pop(); //将该节点弹出，避免重复处理
                //左中右，但入栈顺序为右中左
                if (node.right != null) stack.push(node.right); //添加右节点，空节点不入栈

                stack.push(node); //中
                stack.push(null); //中节点访问过，但是未被处理，添加null作为标记

                if (node.left != null) stack.push(node.left); //添加左节点，空节点不入栈
            } else {
                //栈顶的元素为空，则说明要进行处理
                stack.pop(); //将空元素弹出
                node = stack.pop();
                res.add(node.val);
            }
        }
        return res;
    }

    List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null)
            stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.peek();
            if (node != null) {
                //栈顶的元素不为空，说明没有标记，需要入栈
                stack.pop(); //将该节点弹出，避免重复处理
                //左右中，但入栈顺序为中右左

                stack.push(node); //中
                stack.push(null); //中节点访问过，但是未被处理，添加null作为标记

                if (node.right != null) stack.push(node.right); //添加右节点，空节点不入栈
                if (node.left != null) stack.push(node.left); //添加左节点，空节点不入栈
            } else {
                //栈顶的元素为空，则说明要进行处理
                stack.pop(); //将空元素弹出
                node = stack.pop();
                res.add(node.val);
            }
        }
        return res;
    }
}
