package Tree;

import java.util.*;

/**
 * 二叉树的非递归遍历
 * */
public class NonRecursiveTraversal {
    /**
     * 非递归前序遍历
     * 中、左、右
     * */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        //入栈的顺序为中、右、左
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            //节点非空时，加入到结果中
            if (node != null) {
                res.add(node.val);
            } else {
                continue;
            }
            //顺序为右，左
            stack.push(node.right);
            stack.push(node.left);
        }
        return res;
    }

    /**
     * 非递归后序遍历
     * 左、右、中
     * */
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();

        //前序遍历为中左右，将顺序改为中右左
        //最后将得到的数组反转，就是后序遍历左右中
        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            //节点非空时，加入到结果中
            if (node != null) {
                res.add(node.val);
            } else {
                continue;
            }
            //顺序为左，右
            stack.push(node.left);
            stack.push(node.right);
        }
        Collections.reverse(res);
        return res;
    }

    /**
     * 非递归中序遍历
     * 左、中、右
     * */
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        //stack记录指针访问过的元素
        Stack<TreeNode> stack = new Stack<>();
        TreeNode cur = root;
        while (cur != null || !stack.empty()) {
            if (cur != null) {
                //当前元素不为空时，栈压入元素，指针向左走，“左”
                stack.push(cur);
                cur = cur.left;
            } else {
                //当前元素为空时（左节点为空），栈弹出元素，弹出的元素为“中”
                cur = stack.pop();
                //当前节点加入结果
                res.add(cur.val);
                //遍历右孩子，“右”
                cur = cur.right;
            }
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode bottom1 = new TreeNode(2);
        TreeNode bottom2 = new TreeNode(1);
        TreeNode leftChild = new TreeNode(4, bottom1, bottom2);
        TreeNode rightChild = new TreeNode(6);
        TreeNode root = new TreeNode(5, leftChild, rightChild);
        NonRecursiveTraversal nonRecursiveTraversal = new NonRecursiveTraversal();
        Traversal traversal = new Traversal();

        List<Integer> res = nonRecursiveTraversal.preorderTraversal(root);
        System.out.println("迭代前序遍历结果：");
        for (Integer item : res) {
            System.out.print(item + " ");
        }
        System.out.println();
        res = traversal.preorderTraversal(root);
        System.out.println("递归前序遍历结果：");
        for (Integer item : res) {
            System.out.print(item + " ");
        }
        System.out.println();

        res = nonRecursiveTraversal.postorderTraversal(root);
        System.out.println("迭代后序遍历结果：");
        for (Integer item : res) {
            System.out.print(item + " ");
        }
        System.out.println();
        res = traversal.postorderTraversal(root);
        System.out.println("递归后序遍历结果：");
        for (Integer item : res) {
            System.out.print(item + " ");
        }
        System.out.println();

        res = nonRecursiveTraversal.inorderTraversal(root);
        System.out.println("迭代中序遍历结果：");
        for (Integer item : res) {
            System.out.print(item + " ");
        }
        System.out.println();
        res = traversal.inorderTraversal(root);
        System.out.println("递归中序遍历结果：");
        for (Integer item : res) {
            System.out.print(item + " ");
        }
        System.out.println();
    }
}
