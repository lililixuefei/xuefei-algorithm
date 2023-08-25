package leetcode.interviewgolden.unresolved;

import labuladong.binarytree.TreeNode;

/**
 * @description: 检查平衡性
 * @author: xuefei
 * @date: 2023/08/25 22:52
 */
public class IsBalanced {


    private boolean isBalanced = true;

    public boolean isBalanced2(TreeNode root) {
        maxDepth(root);
        return isBalanced;
    }

    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lDepth = maxDepth(root.left);
        int rDepth = maxDepth(root.right);
        if (Math.abs(lDepth - rDepth) > 1) {
            isBalanced = false;
        }
        return Math.max(lDepth, rDepth) + 1;
    }

    public boolean isBalanced(TreeNode root) {

        return process(root).balanced;

    }

    public Info process(TreeNode node) {
        if (node == null) {
            return new Info(0, true);
        }
        int depth;
        boolean balanced = true;

        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);

        if (Math.abs(leftInfo.depth - rightInfo.depth) > 1) {
            balanced = false;
        }
        if (!leftInfo.balanced || !rightInfo.balanced) {
            balanced = false;
        }

        depth = Math.max(leftInfo.depth, rightInfo.depth) + 1;

        return new Info(depth, balanced);
    }


    class Info {
        int depth;
        boolean balanced;

        public Info(int depth, boolean balanced) {
            this.depth = depth;
            this.balanced = balanced;
        }
    }

}
