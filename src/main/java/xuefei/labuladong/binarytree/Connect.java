package xuefei.labuladong.binarytree;

/**
 * @description:
 * @author: xuefei
 * @date: 2023/02/18 14:34
 */
public class Connect {

    // 主函数
    TreeNode connect(TreeNode root) {
        if (root == null) {
            return null;
        }
        // 遍历「三叉树」，连接相邻节点
        traverse(root.left, root.right);
        return root;
    }

    // 三叉树遍历框架
    void traverse(TreeNode treeNode1, TreeNode treeNode2) {
        if (treeNode1 == null || treeNode2 == null) {
            return;
        }
        // 将传入的两个节点穿起来
        treeNode1.next = treeNode2;

        // 连接相同父节点的两个子节点
        traverse(treeNode1.left, treeNode1.right);
        traverse(treeNode2.left, treeNode2.right);
        // 连接跨越父节点的两个子节点
        traverse(treeNode1.right, treeNode2.left);
    }
}
