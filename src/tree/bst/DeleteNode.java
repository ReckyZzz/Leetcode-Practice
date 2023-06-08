package tree.bst;

import tree.TreeNode;

/**
 * 450. 删除二叉搜索树中的节点
 * 给定一个二叉搜索树的根节点 root 和一个值 key，删除二叉搜索树中的key对应的节点，
 * 并保证二叉搜索树的性质不变。返回二叉搜索树（有可能被更新）的根节点的引用。
 *
 * 一般来说，删除节点可分为两个步骤：
 * 首先找到需要删除的节点；
 * 如果找到了，删除它。
 * */
public class DeleteNode {
    /**
     * 共5种情况：
     * 1. 要删除的节点不在树中
     * 2. 要删除的节点是叶节点，即左右孩子都为空，那么就直接删除
     * 3. 要删除的节点左孩子不为空，右孩子为空
     * 4. 要删除的节点左孩子为空，右孩子不为空
     * 5. 要删除的节点左右孩子都不为空
     * */
    public TreeNode deleteNode(TreeNode root, int key) {
        if (root == null) // 1.没有找到要删除的节点
            return null;
        if (root.val == key) { // 找到了要删除的节点
            if (root.left == null && root.right == null)
                // 2.要删除的节点为叶节点，直接返回空给上层递归（相当于删除了）
                return null;
            else if (root.left != null && root.right == null)
                // 3.左不为空，右为空，返回左子树给上层（相当于把当前节点给删除了）
                return root.left;
            else if (root.left == null && root.right != null)
                // 4.左为空，右不为空
                return root.right;
            else {
                // 5.剩下的情况：左右都不为空
                TreeNode cur = root.right; //cur设为删除节点的右孩子
                while (cur.left != null)
                    // cur一直向左，直到叶节点
                    // 该叶节点就是比删除节点略大的节点，可以放删除节点的左子树
                    cur = cur.left;
                cur.left = root.left;
                // 最后直接返回删除节点的右子树，让删除节点的父节点直接指向该右子树（相当于删除）
                return root.right;
            }
        }
        if (key < root.val) // 向左搜索
            // 用root.left接住函数的返回值，设为左子树
            root.left = deleteNode(root.left, key);
        if (key > root.val) // 向右搜索
            root.right = deleteNode(root.right, key);
        return root;
    }
}
