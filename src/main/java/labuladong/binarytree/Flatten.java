package labuladong.binarytree;

/**
 * @description:
 * @author: xuefei
 * @date: 2023/02/18 14:44
 */
public class Flatten {

    // 虚拟头节点，dummy.right 就是结果
    TreeNode dummy = new TreeNode(-1);
    // 用来构建链表的指针
    TreeNode p = dummy;

    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序位置
        p.right = new TreeNode(root.val);
        p = p.right;

        traverse(root.left);
        traverse(root.right);
    }


    // 定义：将以 root 为根的树拉平为链表
    void flatten(TreeNode root) {
        // base case
        if (root == null) {
            return;
        }

        // 利用定义，把左右子树拉平
        flatten(root.left);
        flatten(root.right);

        /**** 后序遍历位置 ****/
        // 1、左右子树已经被拉平成一条链表
        TreeNode left = root.left;
        TreeNode right = root.right;

        // 2、将左子树作为右子树
        root.left = null;
        root.right = left;

        // 3、将原先的右子树接到当前右子树的末端
        TreeNode p = root;
        while (p.right != null) {
            p = p.right;
        }
        p.right = right;
    }
}
