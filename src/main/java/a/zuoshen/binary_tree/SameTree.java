package a.zuoshen.binary_tree;

/**
 * @description: 相同的树   https://leetcode.cn/problems/same-tree/
 * @author: xuefei
 * @date: 2022/08/21 23:12
 */
public class SameTree {


    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null ^ q == null) {
            return false;
        }
        if (p == null) {
            return true;
        }
        return p.val == q.val && isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
