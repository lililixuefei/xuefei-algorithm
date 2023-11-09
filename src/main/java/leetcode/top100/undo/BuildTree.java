package leetcode.top100.undo;

import labuladong.binarytree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 从前序与中序遍历序列构造二叉树
 * @Author xuefei
 * @Date 2023/11/9 23:01
 * @Version 1.0
 */
public class BuildTree {

    Map<Integer, Integer> inOrderMap = new HashMap<>();


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for (int i = 0; i < inorder.length; i++) {
            inOrderMap.put(inorder[i], i);
        }
        return process(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    private TreeNode process(int[] preorder, int preStart, int preEnd, int[] inorder, int inStart, int inEnd) {
        // base case
        if (preStart > preEnd) {
            return null;
        }

        int rootVal = preorder[preStart];
        int index = inOrderMap.get(rootVal);
        int leftSize = index - inStart;

        // 先构造出当前根节点
        TreeNode root = new TreeNode(rootVal);
        // 递归构造左右子树
        root.left = process(preorder, preStart + 1, preStart + leftSize, inorder, inStart, index - 1);

        root.right = process(preorder, preStart + leftSize + 1, preEnd, inorder, index + 1, inEnd);
        return root;
    }

}
