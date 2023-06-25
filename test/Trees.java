import tree.TreeNode;

import java.util.*;

public class Trees {
    /**
     * 非递归前序遍历，中左右
     * 入栈顺序为右左中
     * */
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        Stack<TreeNode> stack = new Stack<>();
        if (root == null) return res;

        stack.push(root);
        while (!stack.empty()) {
            TreeNode node = stack.pop();
            if (node != null) {
                //栈顶节点非空，将节点(非空)入栈
                if (node.right != null) stack.push(node.right); //右
                if (node.left != null) stack.push(node.left); //左

                stack.push(node);
                stack.push(null);//插入空节点作为标记
            } else {
                //栈顶元素为空，收集结果
                node = stack.pop();
                res.add(node.val);
            }
        }
        return res;
    }

    /**
     * 层序遍历
     * */
    public List<List<Integer>> levelTraversal(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        Queue<TreeNode> queue = new LinkedList<>();
        if (root == null) return res;

        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> level = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                level.add(node.val);
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            res.add(level);
        }
        return res;
    }

    /**
     * 对称二叉树
     * */
    public boolean isSymmetric(TreeNode root) {
        return compare(root.left, root.right);
    }
    public boolean compare(TreeNode left, TreeNode right) {
        //终止条件：1.左右有一个为空，2.左右都为空，3.左右数值不等
        if (left == null && right != null) return false;
        else if (left != null && right == null) return false;
        else if (left == null && right == null) return true;
        else if (left.val != right.val) return false;

        //剩下的情况：左右不为空且数值相等
        //向下层递归，判断外侧和内侧是否相等
        boolean outside = compare(left.left, right.right);
        boolean inside = compare(left.right, right.left);
        return inside && outside;
    }

    /**
     * 最大深度
     * */
    public int maxDepth(TreeNode root) {
        return getDepth(root);
    }
    public int getDepth(TreeNode node) {
        if (node == null) return 0; //空节点高度为0

        int left = getDepth(node.left);
        int right = getDepth(node.right);
        return 1 + Math.max(left, right);
    }
    /**
     * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
     * 求最小深度，与最大深度的不同之处在于：叶节点的深度才能算数，空节点不行
     * 即左子树/右子树为空时，不能算深度为0
     * */
    public int minDepth(TreeNode root) {
        return getMinDepth(root);
    }
    public int getMinDepth(TreeNode node) {
        if (node == null) return 0;

        int left = getMinDepth(node.left);
        int right = getMinDepth(node.right);
        //若左子树为空，则最小深度为1+right；若右子树为空，则最小深度为1+left
        if (node.left == null && node.right != null) {
            return 1 + right;
        }
        if (node.left != null && node.right == null) {
            return 1 + left;
        }
        //若左右子树都不为空，则最小深度就是1+min(left,right)
        return 1 + Math.min(left, right);
    }

    /**
     * 完全二叉树的节点个数
     * */
    public int countNodes(TreeNode root) {
        return getNodes(root);
    }
    public int getNodes(TreeNode node) {
        if (node == null) return 0;

        int left = getNodes(node.left);
        int right = getNodes(node.right);
        return 1 + left + right;
    }

    /**
     * 平衡二叉树
     * */
    public boolean isBalanced(TreeNode root) {
        //返回-1时就不平衡，否则就平衡
        return balance(root) != -1;
    }
    public int balance(TreeNode node) {
        //返回-1时表示已经不是平衡二叉树了，否则返回该节点的高度
        if (node == null) return 0;

        int left = balance(node.left);
        if (left == -1) return -1;
        int right = balance(node.right);
        if (right == -1) return -1;

        //剩下的情况：左右都平衡，则判断左右高度差是否大于1
        if (Math.abs(left - right) > 1) {
            return -1;
        } else {
            return 1 + Math.max(left, right);
        }
    }
}
