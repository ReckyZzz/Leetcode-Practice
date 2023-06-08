package tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 513.找二叉树左下角的值
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * 假设二叉树中至少有一个节点。
 * */
public class BottomLeft {
    int maxDepth = Integer.MIN_VALUE;
    int res;
    public int findBottomLeftValue(TreeNode root) {
        res = root.val;
        traversal(root, 0);
        return res;
    }

    //递归法
    void traversal(TreeNode node, int depth) {
        //遇到叶节点时，判断深度是否最大，若是则进行更新
        if (node.left == null && node.right == null){
            if (depth > maxDepth) {
                maxDepth = depth;
                res = node.val;
            }
        }
        if (node.left != null) {//左
            depth++;
            traversal(node.left, depth);
            depth--;//回溯
        }
        if (node.right != null) {//右
            depth++;
            traversal(node.right, depth);
            depth--;//回溯
        }
    }

    //层序遍历
    public int findBottomLeftValue2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        int res = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                //只记录最左边的节点，即i=0
                if (i == 0) {
                    res = node.val;
                }
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
        }
        return res;
    }
}
