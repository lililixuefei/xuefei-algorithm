package study.zuoshen.binary_tree;

/**
 * @description: 对称的二叉树   https://leetcode.cn/problems/dui-cheng-de-er-cha-shu-lcof/
 * @author: xuefei
 * @date: 2022/08/21 23:18
 */
public class Symmetric {

    public boolean isSymmetric(TreeNode root) {
        return isSymmetric(root,root);
    }

    public boolean isSymmetric(TreeNode p, TreeNode q) {
        if (p == null ^ q == null) {
            return false;
        }
        if (p == null) {
            return true;
        }
        return p.val == q.val && isSymmetric(p.left, q.right) && isSymmetric(p.right, q.left);
    }
}
