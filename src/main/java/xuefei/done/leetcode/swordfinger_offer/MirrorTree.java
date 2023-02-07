package xuefei.done.leetcode.swordfinger_offer;

import xuefei.done.leetcode.tree.TreeNode;

/**
 * @description: 剑指 Offer 27. 二叉树的镜像
 * @author: xuefei
 * @date: 2022/11/13 16:59
 */
public class MirrorTree {

    public TreeNode mirrorTree(TreeNode root) {
        if (root == null) {
            return null;
        }
        TreeNode mirrorRoot = new TreeNode(root.val);
        process(mirrorRoot, root.right, root.left);
        return mirrorRoot;
    }

    private void process(TreeNode mirrorRoot, TreeNode right, TreeNode left) {
        if (right != null) {
            mirrorRoot.left = new TreeNode(right.val);
            process(mirrorRoot.left, right.right, right.left);
        }
        if (left != null) {
            mirrorRoot.right = new TreeNode(left.val);
            process(mirrorRoot.right, left.right, left.left);
        }
    }
}
