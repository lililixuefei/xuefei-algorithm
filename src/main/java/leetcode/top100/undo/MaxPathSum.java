package leetcode.top100.undo;

import leetcode.basic.binarytree.bst.TreeNode;

/**
 * @Description 二叉树中的最大路径和
 * @Author xuefei
 * @Date 2023/11/27 22:38
 * @Version 1.0
 */
public class MaxPathSum {

    int res = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        if (root == null) {
            return 0;
        }
        dfs(root);
        return res;
    }

    public int dfs(TreeNode root) {
        if (root == null) {
            return 0;
        }
        /**
         Q：左右孩子贡献为什么要大于等于0？
         A: 因为计算从某一节点出发的路径和的时候，计算公式为： 当前节点值 + 左孩子贡献 + 右孩子贡献，
         而左右孩子贡献是「可选的」，也就是说当某一边贡献小于0的时候，我可以在计算路径和时不算这一边
         这种情况也就相当于其贡献为 0，但是注意路径和至少包含「当前节点的值」。
         **/
        int leftMax = Math.max(0, dfs(root.left));         // 左孩子贡献
        int rightMax = Math.max(0, dfs(root.right));        // 右孩子贡献
        res = Math.max(res, root.val + leftMax + rightMax); // 更新res
        return root.val + Math.max(leftMax, rightMax);      // 返回当前节点的总贡献
    }

}
