package tree.bst;

import tree.TreeNode;

/**
 * 108. 将有序数组转换为二叉搜索树
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 *
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 * */
public class Array2BST {
    public TreeNode sortedArrayToBST(int[] nums) {
        return traversal(nums, 0, nums.length - 1);
    }

    /**
     * 左闭右闭区间[left, right]
     * */
    public TreeNode traversal(int[] nums, int left, int right) {
        if (left > right) //非法区间
            return null;
        int mid = (left + right) / 2;
        TreeNode root = new TreeNode(nums[mid]); //构造根节点
        //左边的区间[left, mid - 1]，比mid小，所以放在左子树
        root.left = traversal(nums, left, mid - 1);
        //右边的区间[mid + 1, right]
        root.right = traversal(nums, mid + 1, right);
        return root;
    }
}
