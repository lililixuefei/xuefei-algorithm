package leetcode.onequestion.resolved;

import labuladong.binarytree.TreeNode;
import xuefei.done.jdk.LinkedList;

import java.util.Objects;

/**
 * @description: 序列化和反序列化二叉搜索树
 * @author: xuefei
 * @date: 2023/09/04 22:32
 */
public class Codec {

    private final String SEP = ",";

    private final String NULL = "null";

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder stringBuilder = new StringBuilder();
        pre(root, stringBuilder);
        return stringBuilder.toString();
    }

    private void pre(TreeNode node, StringBuilder stringBuilder) {
        if (node == null) {
            stringBuilder.append(NULL).append(SEP);
            return;
        }
        stringBuilder.append(node.val).append(SEP);
        pre(node.left, stringBuilder);
        pre(node.right, stringBuilder);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) {
            return null;
        }
        LinkedList<String> nodes = new LinkedList<>();
        for (String s : data.split(SEP)) {
            nodes.add(s);
        }
        return deserialize(nodes);
    }

    private TreeNode deserialize(LinkedList<String> nodes) {
        if (nodes.size() == 0) {
            return null;
        }
        String value = nodes.removeFirst();
        if (Objects.equals(value, NULL)) {
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(value));
        node.left = (deserialize(nodes));
        node.right = (deserialize(nodes));
        return node;
    }

}
