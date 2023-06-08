package tree.bst;

import tree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * 501. 二叉搜索树中的众数
 * 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
 *
 * 如果树中有不止一个众数，可以按 任意顺序 返回。
 *
 * 假定 BST 满足如下定义：
 * 结点左子树中所含节点的值 小于等于 当前节点的值
 * 结点右子树中所含节点的值 大于等于 当前节点的值
 * 左子树和右子树都是二叉搜索树
 * */
public class FindMode {
    TreeNode pre = null;
    int count = 0;//单个元素出现的频率
    int maxCount = 0;//整个二叉树出现的最高频率
    List<Integer> resList;//存放结果集
    public int[] findMode(TreeNode root) {
        resList = new ArrayList<>();
        traversal(root);
        int[] res = new int[resList.size()];
        for (int i = 0; i < res.length; i++) {
            res[i] = resList.get(i);
        }
        return res;
    }

    public void traversal(TreeNode cur) {
        if (cur == null) return;
        traversal(cur.left);//左

        //中
        if (pre == null) {
            //pre为空，即第一次遍历元素，元素出现次数为1
            count = 1;
        } else if (pre.val == cur.val) {
            //pre和cur相等，出现次数+1
            count++;
        } else {
            //pre和cur不等，出现次数为1
            count = 1;
        }
        pre = cur;//移动pre指针

        if (count == maxCount) {
            //出现次数等于最大频率
            resList.add(cur.val);
        } else if (count > maxCount) {
            //若当前元素出现次数>最大频率，清空结果集
            maxCount = count;
            resList.clear();
            resList.add(cur.val);
        }

        traversal(cur.right);//右
    }
}
