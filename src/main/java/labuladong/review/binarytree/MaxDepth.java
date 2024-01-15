package labuladong.review.binarytree;

import labuladong.binarytree.TreeNode;

/**
 * @description:
 * @author: xuefei
 * @date: 2024/01/10 19:56
 */
public class MaxDepth {

    int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
    }


}
