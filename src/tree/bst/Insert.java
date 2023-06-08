package tree.bst;

import tree.TreeNode;

/**
 * 701. 二叉搜索树中的插入操作
 * 给定二叉搜索树（BST）的根节点root和要插入树中的值value，将值插入二叉搜索树。
 * 返回插入后二叉搜索树的根节点。 输入数据保证：新值和原始二叉搜索树中的任意节点值都不同。
 *
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。
 * */
public class Insert {
    //递归法
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            // 找到叶节点位置了，插入元素
            // 向上层递归返回插入的节点，该节点值为val
            return new TreeNode(val);
        }
        if (val < root.val) {
            // val的值小于root，向左搜索，最终val将插入在左子树中
            // 接收返回值：即插入了val之后的子树。把该子树设置为root的左子树
            root.left = insertIntoBST(root.left, val);
        }
        if (val > root.val) {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

    //迭代法
    public TreeNode insertIntoBST2(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        TreeNode cur = root;//记录当前位置
        TreeNode parent = root;//记录父节点位置
        while (cur != null) {
            parent = cur;//父节点移动，之后再移动当前节点
            if (val < cur.val) cur = cur.left;
            else cur = cur.right;
        }
        //遍历完成之后，cur为空，则需要插入新节点
        TreeNode node = new TreeNode(val);
        if (val < parent.val) parent.left = node;
        else parent.right = node;
        return root;
    }
}
