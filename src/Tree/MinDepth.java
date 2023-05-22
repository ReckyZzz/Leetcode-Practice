package Tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 111. 二叉树的最小深度
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 * */
public class MinDepth {
    public int minDepth(TreeNode root) {
        return getHeight(root);
    }

    //后序遍历求最小高度
    int getHeight(TreeNode node) {
        //空节点的高度为0
        if (node == null)
            return 0;
        int leftHeight = getHeight(node.left);
        int rightHeight = getHeight(node.right);
        //不能直接1+min，因为空节点的高度被计算进去了
        if (node.left == null && node.right != null) {
            //左子树为空，且右子树不为空，取右子树的最小高度
            return 1 + rightHeight;
        }
        if (node.left != null && node.right == null) {
            return 1 + leftHeight;
        }
        return 1 + Math.min(leftHeight, rightHeight);
    }

    //层序遍历
    int minDepth2(TreeNode root) {
        if (root == null)
            return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            depth++;//记录最小深度
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                if (node.left == null && node.right == null){
                    //是叶节点，直接返回深度，因为是从上往下遍历，所以就是最小值
                    return depth;
                }
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
        }
        return depth;
    }
}
