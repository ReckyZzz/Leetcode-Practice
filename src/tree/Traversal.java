package tree;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Traversal {
    /**
     * 递归写法
     * 1.确定递归函数的参数和返回值
     * 2.确定终止条件
     * 3.确定单层递归的逻辑
     *
     * 给你二叉树的根节点 root ，返回它节点值的 前序 遍历。
     * 其实就是中、左、右的顺序
     * */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        preTraversal(root, res);
        return res;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        inTraversal(root, res);
        return res;
    }

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        postTraversal(root, res);
        return res;
    }

    /**
     * 144.前序遍历
     * 递归写法
     * */
    void preTraversal(TreeNode cur, List<Integer> res) {
        //若节点为空，则返回
        if (cur == null)
            return;
        //中、左、右的顺序
        res.add(cur.val);
        preTraversal(cur.left, res);
        preTraversal(cur.right, res);
    }

    /**
     * 94.中序遍历
     * 递归写法
     * */
    void inTraversal(TreeNode cur, List<Integer> res) {
        if (cur == null)
            return;
        //左、中、右
        inTraversal(cur.left, res);
        res.add(cur.val);
        inTraversal(cur.right, res);
    }

    /**
     * 145.后序遍历
     * 递归写法
     * */
    void postTraversal(TreeNode cur, List<Integer> res) {
        if (cur == null)
            return;
        //左、右、中
        postTraversal(cur.left, res);
        postTraversal(cur.right, res);
        res.add(cur.val);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Traversal traversal = new Traversal();
        TreeNode bottom1 = new TreeNode(4);
        TreeNode bottom2 = new TreeNode(5);
        TreeNode leftChild = new TreeNode(2, bottom1, bottom2);
        TreeNode bottom3 = new TreeNode(6);
        TreeNode bottom4 = new TreeNode(7);
        TreeNode rightChild = new TreeNode(3, bottom3, bottom4);
        TreeNode root = new TreeNode(1, leftChild, rightChild);
        List<Integer> res = traversal.preorderTraversal(root);
        System.out.println("前序遍历结果：");
        for (Integer item : res) {
            System.out.print(item + " ");
        }
        System.out.println();

        res = traversal.inorderTraversal(root);
        System.out.println("中序遍历结果：");
        for (Integer item : res) {
            System.out.print(item + " ");
        }
        System.out.println();

        res = traversal.postorderTraversal(root);
        System.out.println("后序遍历结果：");
        for (Integer item : res) {
            System.out.print(item + " ");
        }
    }
}
