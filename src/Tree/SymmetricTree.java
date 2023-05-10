package Tree;

/**
 * 101.对称二叉树
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 * */
public class SymmetricTree {
    //后序遍历
    public boolean isSymmetric(TreeNode root) {
        return compare(root.left, root.right);
    }

    /**
     * 判断左右子树是否可以翻转
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
    }

    public static void main(String[] args) {

    }
}
