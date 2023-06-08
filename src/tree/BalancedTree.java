package tree;

/**
 * 110.平衡二叉树
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * 本题中，一棵高度平衡二叉树定义为：
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 * */
public class BalancedTree {
    public boolean isBalanced(TreeNode root) {
        return getHeight(root) != -1;
    }

    //后序遍历，左右中
    public int getHeight(TreeNode node) {
        if (node == null)
            return 0;
        //当左右子树的高度差超过1时，返回-1
        //左子树不平衡
        int leftHeight = getHeight(node.left);
        if (leftHeight == -1)
            return -1;
        int rightHeight = getHeight(node.right);
        if (rightHeight == -1)
            return -1;

        //得到左右子树的高度，若高度差大于-1，则已经不平衡了
        if (Math.abs(leftHeight - rightHeight) > 1)
            return -1;
        //平衡则返回当前的高度
        return 1 + Math.max(leftHeight, rightHeight);
    }
}
