package tree.bst;

import tree.TreeNode;

/**
 * 669. 修剪二叉搜索树
 * 给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。
 * 通过修剪二叉搜索树，使得所有节点的值在[low, high]中。修剪树不应该改变保留在树中的元素的相对结构
 * (即，如果没有被移除，原有的父代子代关系都应当保留)。 可以证明存在唯一的答案。
 *
 * 所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。
 * */
public class TrimBST {
    //递归
    public TreeNode trimBST(TreeNode root, int low, int high) {
        //root为空，返回空给上层递归，就是在做修剪
        if (root == null) return null;
        //root的值不符合区间的条件，需要删除
        if (root.val < low) {
            // root<low，继续向root的右子树遍历
            // root需要删除，但右子树中可能有符合条件的节点，返回右子树修剪后的结果
            return trimBST(root.right, low, high);
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        //root在[low,high]的范围之内，用左右孩子接住返回值，即修剪后的子树
        root.left = trimBST(root.left, low, high);
        root.right = trimBST(root.right, low, high);
        return root;
    }
}
