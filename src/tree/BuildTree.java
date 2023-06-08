package tree;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 106.从中序与后序遍历序列构造二叉树
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历，
 * postorder 是同一棵树的后序遍历，请你构造并返回这颗二叉树。
 * */
public class BuildTree {
    /**
     * 从中序和后序数组来构造二叉树
     * 使用切割数组的方法，效率比较低
     * */
    public TreeNode buildTree1(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0)
            return null;
        return traversal1(inorder, postorder);
    }
    public TreeNode traversal1(int[] inorder, int[] postorder) {
        if (postorder.length == 0)
            return null;
        int rootValue = postorder[postorder.length - 1];
        TreeNode root = new TreeNode(rootValue);

        //若是叶节点，直接返回
        if (postorder.length == 1)
            return root;

        //找到中序遍历的切割点
        int cutIndex;
        for (cutIndex = 0; cutIndex < inorder.length; cutIndex++) {
            if (inorder[cutIndex] == rootValue)
                break;
        }

        //切割中序数组，保持左闭右开原则
        int[] leftInorder = Arrays.copyOfRange(inorder, 0, cutIndex);
        int[] rightInorder = Arrays.copyOfRange(inorder, cutIndex + 1, inorder.length);

        //抛弃postorder末尾元素
        postorder = Arrays.copyOfRange(postorder, 0, postorder.length - 1);

        //切割后序数组，保持左闭右开原则
        //注意用到了左中序数组的长度来确认切割位置
        int[] leftPostorder = Arrays.copyOfRange(postorder, 0, leftInorder.length);
        int[] rightPostorder = Arrays.copyOfRange(postorder, leftInorder.length, postorder.length);

        root.left = traversal1(leftInorder, leftPostorder);
        root.right = traversal1(rightInorder, rightPostorder);

        return root;
    }


    /**
     * 从中序和后序数组来构造二叉树
     * 采用数组下标索引的方式来切割，并不实际切割数组，效率较高
     * */
    Map<Integer, Integer> map;//存储中序数组中的 元素->下标 关系
    public TreeNode buildTree2(int[] inorder, int[] postorder) {
        if (inorder.length == 0 || postorder.length == 0)
            return null;

        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return traversal2(inorder, 0, inorder.length,
                postorder,0, postorder.length);
    }
    //区间为左闭右开[inBegin, inEnd)
    TreeNode traversal2(int[] inorder, int inBegin, int inEnd
            , int[] postorder, int postBegin, int postEnd) {
        //数组不符合左闭右开原则，返回空节点
        if (inBegin >= inEnd || postBegin >= postEnd) return null;

        //构造根节点，即中间的节点，为后序数组的最后一个元素
        int rootValue = postorder[postEnd - 1];
        TreeNode root = new TreeNode(rootValue);
        //要切割的元素在中序数组中的下标
        int cutIndex = map.get(rootValue);
        int leftLength = cutIndex - inBegin;//左中序数组长度

        //左中序和左后序
        root.left = traversal2(inorder, inBegin, cutIndex,
                postorder, postBegin, postBegin + leftLength);
        //右中序和右后序，右后序舍弃最后一个元素
        //因为是右开，所以右后序的begin可以直接为postBegin + leftLength，而不用+1
        root.right = traversal2(inorder, cutIndex + 1, inEnd,
                postorder, postBegin + leftLength, postEnd - 1);
        return root;
    }

    /**
     * 105.从前序与中序遍历序列构造二叉树
     * 给定两个整数数组preorder和inorder，
     * 其中preorder是二叉树的先序遍历，inorder是同一棵树的中序遍历，请构造二叉树并返回其根节点。
     * */
    public TreeNode buildTree3(int[] preorder, int[] inorder) {
        if (preorder.length == 0)
            return null;

        map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return traversal3(preorder, 0, preorder.length,
                inorder, 0, inorder.length);
    }
    private TreeNode traversal3(int[] preorder, int preBegin, int preEnd
            , int[] inorder, int inBegin, int inEnd) {
        if (preBegin >= preEnd || inBegin >= inEnd) return null;

        int rootValue = preorder[preBegin];
        TreeNode root = new TreeNode(rootValue);
        int cutIndex = map.get(rootValue);
        int leftLength = cutIndex - inBegin;

        //左前序和左中序
        root.left = traversal3(preorder, preBegin + 1, preBegin + 1 + leftLength,
                inorder, inBegin, cutIndex);
        //右前序和右中序
        //因为是右开，所以右前序begin可以直接为preBegin + 1 + leftLength,而不用+1
        root.right = traversal3(preorder, preBegin + 1 + leftLength, preEnd,
                inorder, cutIndex + 1, inEnd);
        return root;
    }

    public static void main(String[] args) {
        BuildTree buildTree = new BuildTree();
//        int[] inorder = {9,3,15,20,7};
//        int[] postorder = {9,15,7,20,3};
        int[] inorder = {8,9,6,3,15,20,7};
        int[] postorder = {8,6,9,15,7,20,3};
        TreeNode root = buildTree.buildTree2(inorder, postorder);
        List<List<Integer>> lists = LevelTraversal.levelOrder(root);
        for (List<Integer> list : lists){
            for (Integer i : list) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }
}
