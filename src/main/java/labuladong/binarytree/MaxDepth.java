package labuladong.binarytree;

/**
 * @description:
 * @author: xuefei
 * @date: 2023/02/18 13:55
 */
public class MaxDepth {


    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        // 分解为算左右子树的最大高度
        int leftMaxDepth = maxDepth(root.left);
        int rightMaxDepth = maxDepth(root.right);
        return Math.max(leftMaxDepth, rightMaxDepth) + 1;
    }
}
