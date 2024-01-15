package labuladong.review.binarytree;

import labuladong.binarytree.TreeNode;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description:
 * @author: xuefei
 * @date: 2024/01/10 20:15
 */
public class LevelTraverse {


    void levelTraverse(TreeNode root) {
        if (root == null){
            return;
        }
        Deque<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();
                // 将下一层节点放入队列
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }
            }
        }
    }


}
