package labuladong.binarytree;

import java.util.LinkedList;
import java.util.List;

/**
 * @description:
 * @author: xuefei
 * @date: 2023/02/18 14:08
 */
public class Traverse {


    List<Integer> res = new LinkedList<>();

    // 返回前序遍历结果
    List<Integer> preorderTraverse(TreeNode root) {
        traverse(root);
        return res;
    }

    // 二叉树遍历函数
    void traverse(TreeNode root) {
        if (root == null) {
            return;
        }
        // 前序位置
        res.add(root.val);
        traverse(root.left);
        traverse(root.right);
    }
}
