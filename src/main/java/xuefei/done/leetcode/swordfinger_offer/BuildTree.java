package xuefei.done.leetcode.swordfinger_offer;

import xuefei.done.leetcode.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 剑指 Offer 07. 重建二叉树
 * @author: xuefei
 * @date: 2022/11/13 12:24
 */
public class BuildTree {


    public TreeNode buildTree(int[] preorder, int[] inorder) {
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
