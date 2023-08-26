package leetcode.interviewgolden.resolved;

import labuladong.binarytree.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

/**
 * @description: 后继者
 * @author: xuefei
 * @date: 2023/08/26 18:58
 */
public class InorderSuccessor {

    public TreeNode inorderSuccessor3(TreeNode root, TreeNode p) {
        Deque<TreeNode> stack = new ArrayDeque<TreeNode>();
        TreeNode prev = null, curr = root;
        while (!stack.isEmpty() || curr != null) {
            while (curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if (prev == p) {
                return curr;
            }
            prev = curr;
            curr = curr.right;
        }
        return null;
    }


    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }
        if (root.val <= p.val) {
            return inorderSuccessor(root.right, p);
        }
        TreeNode ans = inorderSuccessor(root.left, p);
        return ans == null ? root : ans;
    }


    public TreeNode inorderSuccessor2(TreeNode root, TreeNode p) {
        List<TreeNode> ans = new ArrayList<>();

        process(root, ans);

        for (TreeNode an : ans) {
            if (an.val > p.val) {
                return an;
            }
        }
        return null;
    }

    private void process(TreeNode root, List<TreeNode> ans) {
        if (root == null) {
            return;
        }
        process(root.left, ans);
        ans.add(root);
        process(root.right, ans);
    }

}
