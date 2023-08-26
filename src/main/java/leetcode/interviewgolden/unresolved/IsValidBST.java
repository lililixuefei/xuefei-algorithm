package leetcode.interviewgolden.unresolved;

import labuladong.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 合法二叉搜索树
 * @author: xuefei
 * @date: 2023/08/26 13:21
 */
public class IsValidBST {


    public boolean isValidBST2(TreeNode root) {
        return isValidBST(root, null, null);
    }

    /* 限定以 root 为根的子树节点必须满足 max.val > root.val > min.val */
    public boolean isValidBST(TreeNode root, TreeNode min, TreeNode max) {
        // base case
        if (root == null) {
            return true;
        }
        // 若 root.val 不符合 max 和 min 的限制，说明不是合法 BST
        if (min != null && root.val <= min.val) {
            return false;
        }
        if (max != null && root.val >= max.val) {
            return false;
        }
        // 限定左子树的最大值是 root.val，右子树的最小值是 root.val
        return isValidBST(root.left, min, root) && isValidBST(root.right, root, max);
    }


    public boolean isValidBST(TreeNode root) {
        List<Integer> ans = new ArrayList<>();

        process(root, ans);
        for (int i = 0; i < ans.size() - 1; i++) {
            if (ans.get(i + 1) < ans.get(i)) {
                return false;
            }
        }
        return true;
    }

    private void process(TreeNode root, List<Integer> ans) {
        if (root == null) {
            return;
        }
        process(root.left, ans);
        ans.add(root.val);
        process(root.right, ans);
    }

}
