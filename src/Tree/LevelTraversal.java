package Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 102.二叉树的层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * */
public class LevelTraversal {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null)
            queue.add(root);
        //当队列不为空时，进入循环
        while (!queue.isEmpty()) {
            //记录当前队列长度，即本层的节点数
            int size = queue.size();
            List<Integer> levelItem = new ArrayList<>();
            while (size > 0) {
                //将本层的节点（size个）全部取出
                TreeNode node = queue.poll();
                levelItem.add(node.val);
                //分别加入左右节点（非空）
                if (node.left != null)
                    queue.add(node.left);
                if (node.right != null)
                    queue.add(node.right);
                size--;
            }
            res.add(levelItem);
        }
        return res;
    }

    public static void main(String[] args) {
        TreeNode bottom1 = new TreeNode(1);
        TreeNode bottom2 = new TreeNode(3);
        TreeNode leftChild = new TreeNode(4, bottom1, bottom2);
        TreeNode bottom3 = new TreeNode(5);
        TreeNode bottom4 = new TreeNode(8);
        TreeNode rightChild = new TreeNode(7, bottom3, bottom4);
        TreeNode root = new TreeNode(6, leftChild, rightChild);
        List<List<Integer>> lists = levelOrder(root);
        for (List<Integer> list : lists){
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
