package zuoshen.binary_tree;

/**
 * @description: 二叉树获取某节点的后继节点
 * @author: xuefei
 * @date: 2022/07/05 00:03
 */
public class SuccessorNode {

    public TreeNode getInorderSuccessorNode(TreeNode node) {
        if (node == null) {
            return null;
        }
        if (node.right != null) {
            return getLeftMost(node.right);
        }
        TreeNode parent = node.parent;
        while (parent != null && parent.right == node) {
            node = parent;
            parent = node.parent;
        }
        return parent;
    }

    private TreeNode getLeftMost(TreeNode node) {
        if (node == null) {
            return null;
        }
        while (node.left != null) {
            node = node.left;
        }
        return node;
    }
}
