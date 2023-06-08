package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 101.对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * */
public class SymmetricTree {
    public boolean isSymmetric(TreeNode root) {
        return compare(root.left, root.right);
    }

    /**
     * 判断左右子树是否可以翻转
     * 后序遍历顺序，左右中
     * */
    boolean compare(TreeNode left, TreeNode right) {
        if (left == null && right != null)
            return false;
        else if (left != null && right == null) {
            return false;
        } else if (left == null && right == null) {
            return true;
        } else if (left.val != right.val) {
            return false;
        }
        //左右节点不为空，且数值相等，处理核心逻辑
        //外侧节点
        boolean outside = compare(left.left, right.right); //左，右
        //内侧节点
        boolean inside = compare(left.right, right.left); //右，左
        return outside && inside; //中，中
        //总体的顺序其实是左，右，中，即后序遍历
    }

    /**
     * 迭代法判断树是否可以翻转
     * */
    public boolean isSymmetric2(TreeNode root) {
        if (root == null)
            return false;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root.left);
        queue.offer(root.right);
        while (!queue.isEmpty()) {
            //依次取出左，右节点
            TreeNode leftNode = queue.poll();
            TreeNode rightNode = queue.poll();
            if (leftNode == null && rightNode == null)
                continue;
            //若1.左为空，右不为空，2.左不为空，右为空，3.左右节点值不等，则返回错误
            if (leftNode == null || rightNode == null || leftNode.val != rightNode.val)
                return false;
            //剩下的情况就是左右节点相等，则将其左右节点加入队列
            //外侧节点
            queue.offer(leftNode.left);
            queue.offer(rightNode.right);
            //内侧节点
            queue.offer(leftNode.right);
            queue.offer(rightNode.left);
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
