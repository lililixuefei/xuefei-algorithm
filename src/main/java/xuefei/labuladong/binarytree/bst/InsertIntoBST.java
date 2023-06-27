package xuefei.labuladong.binarytree.bst;

import xuefei.labuladong.binarytree.TreeNode;

/**
 * @description:
 * @author: xuefei
 * @date: 2023/02/18 16:34
 */
public class InsertIntoBST {

    TreeNode insertIntoBST(TreeNode root, int val) {
        // 找到空位置插入新节点
        if (root == null) {
            return new TreeNode(val);
        }
        // if (root.val == val)
        //     BST 中一般不会插入已存在元素
        if (root.val < val) {
            root.right = insertIntoBST(root.right, val);
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        }
        return root;
    }
}
