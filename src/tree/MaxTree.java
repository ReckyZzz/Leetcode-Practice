package tree;

/**
 * 654. 最大二叉树
 * 给定一个不重复的整数数组nums。最大二叉树可以用下面的算法从nums递归地构建:
 *
 * 创建一个根节点，其值为nums中的最大值。
 * 递归地在最大值 左边的 子数组前缀上 构建左子树。
 * 递归地在最大值 右边的 子数组后缀上 构建右子树。
 * 返回nums构建的 最大二叉树。
 * */
public class MaxTree {
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return buildTree(nums, 0, nums.length);
    }

    //前序遍历，中左右
    public TreeNode buildTree(int[] nums, int begin, int end) {
        //若区间不符合左闭右开条件，则返回空
        if (begin >= end) return null;

        //若只有一个元素，即叶节点，直接返回
        if (end - begin == 1) {
            return new TreeNode(nums[begin]);
        }

        int maxValue = nums[begin];
        int maxIndex = begin;
        //寻找数组中的最大值与对应的下标
        for (int i = begin + 1; i < end; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                maxIndex = i;
            }
        }
        TreeNode root = new TreeNode(maxValue);//中

        root.left = buildTree(nums, begin, maxIndex);//左
        root.right = buildTree(nums, maxIndex + 1, end);//右
        return root;
    }
}
