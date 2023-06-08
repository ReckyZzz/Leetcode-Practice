package tree;

/**
 * 236. 二叉树的最近公共祖先
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大
 * （一个节点也可以是它自己的祖先）。”
 * */
public class CommonAncestor {
    //后序遍历
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        //若当前节点等于p或q，就返回当前节点，提示上层递归找到了元素
        if (root == p || root == q) return root;

        TreeNode left = lowestCommonAncestor(root.left, p, q);//左
        TreeNode right = lowestCommonAncestor(root.right, p, q);//右
        //中
        if (left != null && right != null) {
            //左、右都找到了结果，root就是公共祖先
            return root;
        } else if (left == null && right != null) {
            //左为空，右不为空，返回右
            return right;
        } else if (left != null && right == null) {
            //右为空，左不为空，返回左
            return left;
        } else {
            return null;
        }
    }
}
