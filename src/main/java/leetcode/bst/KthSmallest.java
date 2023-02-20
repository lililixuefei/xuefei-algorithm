package leetcode.bst;

/**
 * @description: 二叉搜索树中第K小的元素
 * @author: xuefei
 * @date: 2023/02/20 23:27
 */
public class KthSmallest {

    int i = 0;
    int res = 0;

    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    public void traverse(TreeNode root, int k) {
        if (root == null){
            return;
        }
        traverse(root.left, k);
        i++;
        if (i == k) {
            res = root.val;
            return;
        }
        traverse(root.right, k);
    }
}
