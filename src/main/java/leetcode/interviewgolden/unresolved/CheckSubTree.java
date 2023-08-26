package leetcode.interviewgolden.unresolved;

import labuladong.binarytree.TreeNode;

/**
 * @description: 检查子树
 * @author: xuefei
 * @date: 2023/08/26 13:00
 */
public class CheckSubTree {

    public boolean checkSubTree(TreeNode t1, TreeNode t2) {
        if (t2 == null) {
            return true;
        }
        if (t1 == null) {
            return false;
        }
        return isTreeEql(t1, t2) || checkSubTree(t1.left, t2) || checkSubTree(t1.right, t2);
    }

    private boolean isTreeEql(TreeNode t1, TreeNode t2) {
        if (t1 == t2) {
            return true;
        }
        if (t1 == null || t2 == null) {
            return false;
        }
        return t1.val == t2.val && isTreeEql(t1.left, t2.left) && isTreeEql(t1.right, t2.right);
    }


}
