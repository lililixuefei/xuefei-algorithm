package xuefei.done.study.zuoshen.binary_tree;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 重建二叉树   https://leetcode.cn/problems/zhong-jian-er-cha-shu-lcof/
 * @author: xuefei
 * @date: 2022/08/21 23:33
 */
public class BuildTree {

    public TreeNode buildTree1(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        if (preorder.length != inorder.length) {
            return null;
        }
        return f1(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode f1(int[] preorder, int l1, int r1, int[] inorder, int l2, int r2) {
        if (l1 > r1) {
            return null;
        }
        TreeNode head = new TreeNode(preorder[l1]);
        if (l1 == r1) {
            return head;
        }
        int find = 0;
        while (inorder[find] != preorder[l1]) {
            find++;
        }
        head.left = f1(preorder, l1 + 1, l1 + find - l2, inorder, l2, find - 1);
        head.right = f1(preorder, l1 + find - l2 + 1, r1, inorder, find + 1, r2);
        return head;
    }

    public TreeNode buildTree2(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        if (preorder.length != inorder.length) {
            return null;
        }
        Map<Integer, Integer> valueIndexMap = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            valueIndexMap.put(inorder[i], i);
        }

        return f2(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1, valueIndexMap);
    }

    public TreeNode f2(int[] preorder, int l1, int r1, int[] inorder, int l2, int r2, Map<Integer, Integer> valueIndexMap) {
        if (l1 > r1) {
            return null;
        }
        TreeNode head = new TreeNode(preorder[l1]);
        if (l1 == r1) {
            return head;
        }
        int find = valueIndexMap.get(preorder[l1]);
        head.left = f2(preorder, l1 + 1, l1 + find - l2, inorder, l2, find - 1, valueIndexMap);
        head.right = f2(preorder, l1 + find - l2 + 1, r1, inorder, find + 1, r2, valueIndexMap);
        return head;
    }
}
