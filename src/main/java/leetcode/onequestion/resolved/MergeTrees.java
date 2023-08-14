package leetcode.onequestion.resolved;

import labuladong.binarytree.TreeNode;

/**
 * @description: 合并二叉树
 * @author: xuefei
 * @date: 2023/08/14 22:44
 */
public class MergeTrees {


    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        return dfs(root1, root2);
    }

    private TreeNode dfs(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        TreeNode root;
        if (root1 == null) {
            root = new TreeNode(root2.val);
            root.left = dfs(null, root2.left);
            root.right = dfs(null, root2.right);
        } else if (root2 == null) {
            root = new TreeNode(root1.val);
            root.left = dfs(root1.left, null);
            root.right = dfs(root1.right, null);
        } else {
            root = new TreeNode(root2.val + root1.val);
            root.left = dfs(root1.left, root2.left);
            root.right = dfs(root1.right, root2.right);
        }
        return root;
    }

}
