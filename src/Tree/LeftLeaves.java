package Tree;

/**
 * 404.左叶子之和
 * 给定二叉树的根节点 root ，返回所有左叶子之和。
 * */
public class LeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null)//空节点
            return 0;
        int leftNum = sumOfLeftLeaves(root.left);//左
        int rightNum = sumOfLeftLeaves(root.right);//右

        int midNum = 0;
        //当前节点的左节点是叶节点
        if (root.left != null && root.left.left == null && root.left.right == null) {
            midNum = root.left.val;
        }
        int sum = leftNum + rightNum + midNum;//中
        return sum;
    }

    //后序遍历求左叶子之和
    public int traversal(TreeNode node) {
        if (node == null)//空节点
            return 0;
        if (node.left == null && node.right == null)//叶节点
            return 0;
        int leftNum = traversal(node.left);
        //当前节点的左节点是叶节点
        if (node.left != null && node.left.left == null && node.left.right == null){
            leftNum = node.left.val;
        }

        int rightNum = traversal(node.right);
        int sum = leftNum + rightNum;
        return sum;
    }
}
