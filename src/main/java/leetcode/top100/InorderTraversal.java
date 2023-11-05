package leetcode.top100;

import labuladong.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description 二叉树的中序遍历
 * @Author xuefei
 * @Date 2023/11/5 17:42
 * @Version 1.0
 */
public class InorderTraversal {

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> ans = new ArrayList<>();
        process(root, ans);
        return ans;
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
