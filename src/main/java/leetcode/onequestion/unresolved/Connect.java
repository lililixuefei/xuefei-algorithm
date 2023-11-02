package leetcode.onequestion.unresolved;


import leetcode.basic.binarytree.Node;

import java.util.LinkedList;
import java.util.Queue;

/**
 * @Description 填充每个节点的下一个右侧节点指针 II
 * @Author xuefei
 * @Date 2023/11/3 0:31
 * @Version 1.0
 */
public class Connect {

    public Node connect(Node root) {
        if (root == null) {
            return root;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int levelCount = queue.size();
            Node pre = null;
            for (int i = 0; i < levelCount; i++) {
                Node node = queue.poll();
                //如果pre为空就表示node节点是这一行的第一个，
                //没有前一个节点指向他，否则就让前一个节点指向他
                if (pre != null) {
                    pre.next = node;
                }
                //然后再让当前节点成为前一个节点
                pre = node;
                //左右子节点如果不为空就入队
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
            }
        }
        return root;
    }
}
