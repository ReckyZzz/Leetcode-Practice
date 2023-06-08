package tree.bst;

import tree.TreeNode;

/**
 * 530. 二叉搜索树的最小绝对差
 * 给你一个二叉搜索树的根节点 root ，返回 树中任意两不同节点值之间的最小差值 。
 *
 * 差值是一个正数，其数值等于两值之差的绝对值。
 * */
public class MinDiff {
    int result = Integer.MAX_VALUE;
    TreeNode pre = null;
    public int getMinimumDifference(TreeNode root) {
        if (root == null) return 0;
        traversal(root);
        return result;
    }

    //cur为当前节点
    void traversal(TreeNode cur) {
        if (cur == null) return;
        traversal(cur.left);//左
        //中
        if (pre != null) {
            result = Integer.min(result, cur.val - pre.val);
        }
        pre = cur;
        traversal(cur.right);//右
    }
}
