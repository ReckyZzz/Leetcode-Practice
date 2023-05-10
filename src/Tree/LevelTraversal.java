package Tree;

import java.util.*;

/**
 * 102.二叉树的层序遍历
 * 给你二叉树的根节点 root ，返回其节点值的 层序遍历 。 （即逐层地，从左到右访问所有节点）。
 * 107.二叉树的层序遍历II：只需将结果反转
 * 199.二叉树的右视图：层序遍历时，判断是否遍历到单层的最后一个元素，若是则加入result中
 * 637.二叉树的层平均值：遍历时用一个变量求和，最后将平均值加入result
 * 429.N叉树的层序遍历：遍历时将节点的所有子节点加入队列中
 * 515.在每个树行中找最大值：设置max=MIN_VALUE，然后比较节点与max的值，最后记录max
 * 104.二叉树的最大深度：每遍历一层就对深度+1
 * 111.二叉树的最小深度：遍历到叶节点（左右节点均为空）时返回深度
 * */
public class LevelTraversal {
    public static List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root != null) queue.add(root);
        //当队列不为空时，进入循环
        while (!queue.isEmpty()) {
            //记录当前队列长度，即本层的节点数
            int size = queue.size();
            List<Integer> levelItem = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                //将本层的节点（size个）全部取出
                TreeNode node = queue.poll();
                //分别加入左右节点（非空）
                if (node.left != null) queue.add(node.left);
                if (node.right != null) queue.add(node.right);
                //当前节点加入结果中
                levelItem.add(node.val);
            }
            res.add(levelItem);
        }
        return res;
    }

    /**
     * 116.填充每个节点的下一个右侧节点指针
     * 填充它的每个next指针，让这个指针指向其下一个右侧节点。如果找不到下一个右侧节点，则将 next 指针设置为 NULL。
     * 初始状态下，所有next指针都被设置为 NULL。
     * */
    public Node connect(Node root) {
        Queue<Node> queue = new LinkedList<>();
        if (root != null)
            queue.add(root);
        //当队列不为空时，进入循环
        while (!queue.isEmpty()) {
            int size = queue.size();
            //记录每层的第一个节点为cur
            Node cur = queue.poll();
            if (cur.left != null) queue.add(cur.left);
            if (cur.right != null) queue.add(cur.right);
            //记录当前队列长度，即本层的节点数
            for (int i = 1; i < size; i++) {
                //将剩下的size-1个节点取出
                Node next = queue.poll();
                //分别加入左右节点（非空）
                if (next.left != null) queue.add(next.left);
                if (next.right != null) queue.add(next.right);
                //当前节点指向下一个节点，然后移动当前节点
                cur.next = next;
                cur = next;
            }
        }
        return root;
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
