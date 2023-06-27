package xuefei.labuladong.binarytree.bst;

import xuefei.labuladong.binarytree.TreeNode;

/**
 * @description:
 * @author: xuefei
 * @date: 2023/02/18 16:31
 */
public class IsInBST {

    boolean isInBST(TreeNode root, int target) {
        if (root == null) {
            return false;
        }
        if (root.val == target) {
            return true;
        }
        if (root.val < target) {
            return isInBST(root.right, target);
        } else {
            return isInBST(root.left, target);
        }
    }
}
