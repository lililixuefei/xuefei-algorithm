package labuladong.binarytree.serialize;

import labuladong.binarytree.TreeNode;

import java.util.LinkedList;

/**
 * @description:
 * @author: xuefei
 * @date: 2023/02/19 14:13
 */
public class InSerialize {

    String SEP = ",";
    String NULL = "#";


    /* 主函数，将二叉树序列化为字符串 */
    String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    /* 辅助函数，将二叉树存入 StringBuilder */
    void serialize(TreeNode root, StringBuilder sb) {
        if (root == null) {
            sb.append(NULL).append(SEP);
            return;
        }

        serialize(root.left, sb);
        // 中序位置
        sb.append(root.val).append(SEP);
        serialize(root.right, sb);
    }

    // 中序遍历无法实现反序列化方法


}
