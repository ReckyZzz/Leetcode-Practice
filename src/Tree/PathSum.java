package Tree;

/**
 * 112.路径总和
 * 给你二叉树的根节点root 和一个表示目标和的整数targetSum 。
 * 判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和targetSum 。如果存在，返回 true ；否则，返回 false 。
 * 叶子节点 是指没有子节点的节点。
 * */
public class PathSum {
    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) {
            return false;
        }
        targetSum -= root.val;
        //终止条件：遇到叶节点
        //遇到叶节点且值刚好为0，就找到满足条件的路径
        //遇到叶接单但值不为0，路径不满足条件
        if (root.left == null && root.right == null) {
            return targetSum == 0;
        }
        if (root.left != null) {//左
            //接收返回结果，若存在路径，就返回true
            if (hasPathSum(root.left, targetSum)){
                return true;
            }
        }
        if (root.right != null) {//右
            if (hasPathSum(root.right, targetSum)) {
                return true;
            }
        }
        return false;
    }


    public boolean hasPathSum2(TreeNode root, int targetSum) {
        if (root == null){
            return false;
        }
        return traversal(root, targetSum - root.val);
    }
    boolean traversal(TreeNode node, int count) {
        //终止条件：遇到叶节点
        //遇到叶节点且值刚好为0，就找到满足条件的路径
        //遇到叶接单但值不为0，则路径不满足条件
        if (node.left == null && node.right == null) {
            return count == 0;
        }
        if (node.left != null) {//左
            count -= node.left.val;//递归
            //接收返回结果，若存在路径，就返回true
            if (traversal(node.left, count)){
                return true;
            }
            count += node.left.val;//回溯
        }
        if (node.right != null) {//右
            count -= node.right.val;//递归
            if (traversal(node.right, count)) {
                return true;
            }
            count += node.right.val;//回溯
        }
        return false;
    }
}
