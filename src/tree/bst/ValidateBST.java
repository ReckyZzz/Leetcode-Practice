package tree.bst;

import tree.TreeNode;

/**
 * 98. 验证二叉搜索树
 * 给你一个二叉树的根节点 root ，判断其是否是一个有效的二叉搜索树。
 *
 * 有效 二叉搜索树定义如下：
 *
 * 节点的左子树只包含 小于 当前节点的数。
 * 节点的右子树只包含 大于 当前节点的数。
 * 所有左子树和右子树自身必须也是二叉搜索树。
 * */
public class ValidateBST {
    long maxVal = Long.MIN_VALUE;
    public boolean isValidBST(TreeNode root) {
        if (root == null) return true;

        boolean left = isValidBST(root.left);//左
        //root值比左子树最大值小
        if (root.val > maxVal) {
            maxVal = root.val;
        }
        else {
            return false;
        }
        boolean right = isValidBST(root.right);//右
        return left && right;
    }

    TreeNode pre = null;
    public boolean isValid(TreeNode root) {
        if (root == null) return true;

        boolean left = isValid(root.left);//左
        //pre不为空，则判断值
        //pre大于当前节点，则返回false
        if (pre != null && pre.val >= root.val) {
            return false;
        }
        //记录pre，即前一个节点
        pre = root;
        boolean right = isValid(root.right);//右
        return left && right;
    }
}
