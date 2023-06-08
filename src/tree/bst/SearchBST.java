package tree.bst;

import tree.TreeNode;

/**
 * 700. 二叉搜索树中的搜索
 * 给定二叉搜索树（BST）的根节点root和一个整数值  val。
 * 你需要在 BST 中找到节点值等于val的节点。 返回以该节点为根的子树。 如果节点不存在，则返回null。
 * 二叉搜索树：根节点比左子树所有数值大，比右子树小
 * */
public class SearchBST {
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null || root.val == val) return root;
        TreeNode result = null;
        //若找的值小于root，向左寻找，否则向右
        if (val < root.val) {
            result = searchBST(root.left ,val);
        }
        if (val > root.val) {
            result = searchBST(root.right, val);
        }
        return result;
    }

    public TreeNode search(TreeNode root, int val) {
        while (root != null) {
            if (val < root.val) {
                root = root.left;
            }
            else if (val > root.val) {
                root = root.right;
            }
            else {
                return root;
            }
        }
        return null;
    }
}
