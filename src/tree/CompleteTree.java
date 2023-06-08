package tree;

/**
 * 222. 完全二叉树的节点个数
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * 完全二叉树的定义如下：在完全二叉树中，除了最底层节点可能没填满外，
 * 其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干位置。
 * 若最底层为第 h 层，则该层包含 1~2^h个节点。
 * */
public class CompleteTree {
    public int countNodes(TreeNode root) {
        return getNum(root);
    }

    //普通二叉树的后序遍历
    int getNum(TreeNode node) {
        if (node == null)
            return 0;
        //左右中
        int leftNum = getNum(node.left);
        int rightNum = getNum(node.right);
        int result = 1 + leftNum + rightNum;
        return result;
    }

    //利用完全二叉树的特性，遍历的节点更少
    int getNum2(TreeNode node) {
        if (node == null)
            return 0;
        TreeNode leftNode = node.left;
        TreeNode rightNode = node.right;
        int leftDepth = 0;
        int rightDepth = 0;

        while (leftNode != null) {
            leftNode = leftNode.left;
            leftDepth++;
        }
        while (rightNode != null) {
            rightNode = rightNode.right;
            rightDepth++;
        }
        //终止条件：找到完全二叉树，返回2^depth - 1（注意2<<1 = 2^2）
        if (leftDepth == rightDepth)
            return (2 << leftDepth) - 1;

        //递归核心逻辑：后序遍历，左右中
        int leftNum = getNum2(node.left);
        int rightNum = getNum2(node.right);
        int result = leftNum + rightNum + 1;
        return result;
    }
}
