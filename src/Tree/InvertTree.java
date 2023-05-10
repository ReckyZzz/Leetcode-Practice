package Tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 226.翻转二叉树
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * */
public class InvertTree {
    //前序遍历，中、左、右
    //后序遍历也可以，但中序不行
    public TreeNode invertTree(TreeNode root) {
        if (root == null)
            return null;
        swapChild(root);//中
        invertTree(root.left);//左
        invertTree(root.right);//右
        return root;
    }

    private void swapChild(TreeNode node) {
        TreeNode temp = node.left;
        node.left = node.right;
        node.right = temp;
    }

    //层序遍历
    public TreeNode BFSInvert(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                swapChild(node);
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
            }
        }
        return root;
    }

    public static void main(String[] args) {
        InvertTree invert = new InvertTree();
        TreeNode bottom1 = new TreeNode(1);
        TreeNode bottom2 = new TreeNode(3);
        TreeNode leftChild = new TreeNode(4, bottom1, bottom2);
        TreeNode bottom3 = new TreeNode(5);
        TreeNode bottom4 = new TreeNode(8);
        TreeNode rightChild = new TreeNode(7, bottom3, bottom4);
        TreeNode root = new TreeNode(6, leftChild, rightChild);

//        TreeNode newRoot = invert.invertTree(root);
//        List<List<Integer>> lists = LevelTraversal.levelOrder(newRoot);
//        for (List<Integer> list : lists){
//            for (Integer i : list) {
//                System.out.print(i + "\t");
//            }
//            System.out.println();
//        }
//        System.out.println();

        TreeNode newRoot1 = invert.BFSInvert(root);
        List<List<Integer>> lists1 = LevelTraversal.levelOrder(newRoot1);
        for (List<Integer> list : lists1){
            for (Integer i : list) {
                System.out.print(i + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
