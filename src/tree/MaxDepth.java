package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 104.二叉树的最大深度
 * 给定一个二叉树，找出其最大深度。
 * 二叉树的深度为根节点到最远叶子节点的最长路径上的节点数。
 * 说明: 叶子节点是指没有子节点的节点。
 * */
public class MaxDepth {
    public int maxDepth(TreeNode root) {
        return getHeight(root);
    }

    //递归法求高度，因为根节点的高度=最大深度
    public int getHeight(TreeNode node) {
        //叶节点的下面一层节点为空，其高度为0
        if (node == null)
            return 0;
        //后序遍历，左右中
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        int height = 1 + Math.max(leftHeight, rightHeight);
        return height;
    }

    //层序遍历
    public int maxDepth2(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return depth;
    }
}
