package tree.bst;

import tree.TreeNode;

/**
 * 235. 二叉搜索树的最近公共祖先
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 *
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，
 * 满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 * */
public class CommonAncestor {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) return null;

        //不需特别的遍历顺序，有左和右就行
        //root值大于p和q，则根据二叉搜索树的规则需要往左边搜索
        if (root.val > p.val && root.val > q.val) {
            //向左搜索
            TreeNode left = lowestCommonAncestor(root.left, p, q);
            //left不为空，则在左子树中找到了最近公共祖先
            if (left != null)
                return left;
        }
        //root值小于p和q，则根据二叉搜索树的规则需要往左边搜索
        if (root.val < p.val && root.val < q.val) {
            //向右搜索
            TreeNode right = lowestCommonAncestor(root.right, p, q);
            if (right != null)
                return right;
        }
        //剩下的情况：root的值在p和q之间(q>root>p或p>root>q)
        //则root就是p和q的最近公共祖先
        return root;
    }

    //迭代法
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        while (root != null) {
            if (root.val > p.val && root.val > q.val) {
                //向左搜索
                root = root.left;
            } else if (root.val < p.val && root.val < q.val) {
                //向右搜索
                root = root.right;
            } else {
                //剩下的情况：root在p和q之间，root就是最近公共祖先
                return root;
            }
        }
        return null;
    }
}
