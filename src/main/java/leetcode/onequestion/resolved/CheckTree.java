package leetcode.onequestion.resolved;

import labuladong.binarytree.TreeNode;

/**
 * @description: 判断根结点是否等于子结点之和
 * @author: xuefei
 * @date: 2023/08/20 22:54
 */
public class CheckTree {

    public boolean checkTree(TreeNode root) {
        return root.val == root.left.val + root.right.val;
    }

}
