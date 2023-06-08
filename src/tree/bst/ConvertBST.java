package tree.bst;

import tree.TreeNode;

/**
 * 538. 把二叉搜索树转换为累加树
 *
 * 给出二叉搜索树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），
 * 使每个节点 node的新值等于原树中大于或等于node.val的值之和。
 *
 * 提醒一下，二叉搜索树满足下列约束条件：
 *
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 * */
public class ConvertBST {
    int pre = 0; //pre记录前一个节点的值
    public TreeNode convertBST(TreeNode root) {
        if (root == null)
            return null;
        traversal(root);
        return root;
    }

    void traversal(TreeNode cur) {
        if (cur == null) return;

        // 二叉搜索树通过左中右的遍历结果是一个有序数组
        // 本题反过来处理，即右中左的形式来处理，从最大元素开始
        traversal(cur.right);
        cur.val += pre;
        pre = cur.val;
        traversal(cur.left);
    }
}
