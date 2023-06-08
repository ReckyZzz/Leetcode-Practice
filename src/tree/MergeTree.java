package tree;

/**
 * 617. 合并二叉树
 * 给你两棵二叉树： root1 和 root2 。
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。
 * 你需要将这两棵树合并成一棵新二叉树。
 *
 * 合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；
 * 否则，不为 null 的节点将直接作为新二叉树的节点。
 *
 * 返回合并后的二叉树。
 * 注意: 合并过程必须从两个树的根节点开始。
 * */
public class MergeTree {
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        //若树1为空，则返回树2的元素，反之同理
        //若都为空，则返回null
        if (root1 == null)
            return root2;
        if (root2 == null)
            return root1;

        //改树1的结构，不去定义新的树
        //树1树2都不为空，值相加
        root1.val += root2.val;//中
        //同时移动树1和树2，同一个方向移动
        root1.left = mergeTrees(root1.left, root2.left);//左
        root1.right = mergeTrees(root1.right, root2.right);//右
        return root1;
    }
}
