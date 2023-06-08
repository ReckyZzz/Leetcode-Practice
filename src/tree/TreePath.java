package tree;

import java.util.ArrayList;
import java.util.List;

/**
 * 257.二叉树的所有路径
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * 叶子节点 是指没有子节点的节点。
 * */
public class TreePath {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if (root == null)
            return res;
        List<Integer> path = new ArrayList<>();
        traversal(root, path, res);
        return res;
    }

    //前序遍历
    void traversal(TreeNode node, List<Integer> path, List<String> result) {
        path.add(node.val);//中
        //若node是叶节点，收获结果，将路径放入result里
        if (node.left == null && node.right == null) {
            StringBuilder string = new StringBuilder();
            for (int i = 0; i < path.size() - 1; i++) {
                string.append(path.get(i)).append("->");
            }
            //构造路径字符串，形如1->3->5
            string.append(path.get(path.size() - 1));
            result.add(string.toString());
            return;
        }

        if (node.left != null) {//左
            traversal(node.left, path, result);
            path.remove(path.size() - 1);//回溯
        }
        if (node.right != null) {//右
            traversal(node.right, path, result);
            path.remove(path.size() - 1);//回溯
        }
    }
}
