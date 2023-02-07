package xuefei.done.me.binary_tree;

import xuefei.done.leetcode.tree.TreeNode;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 二叉树的直径
 * @author: xuefei
 * @date: 2022/09/03 21:43
 */
public class DiameterBinaryTree {

    int ans;

    public int diameterOfBinaryTree1(TreeNode root) {
        ans = 1;
        depth(root);
        return ans - 1;
    }

    public int depth(TreeNode node) {
        if (node == null) {
            return 0; // 访问到空节点了，返回0
        }
        int L = depth(node.left); // 左儿子为根的子树的深度
        int R = depth(node.right); // 右儿子为根的子树的深度
        ans = Math.max(ans, L + R + 1); // 计算d_node即L+R+1 并更新ans
        return Math.max(L, R) + 1; // 返回该节点为根的子树的深度
    }


    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) {
            return 0;
        }
        if (root.right == null && root.left == null) {
            return 0;
        }
        int curMax = maxDepth(root.left) + maxDepth(root.right);
        int leftMax = diameterOfBinaryTree(root.left);
        int rightMax = diameterOfBinaryTree(root.right);
        return Math.max(curMax, Math.max(leftMax, rightMax));
    }

    Map<TreeNode, Integer> map = new HashMap<>();

    private int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Integer depth = map.get(root);
        if (depth == null) {
            depth = Math.max(maxDepth(root.left), maxDepth(root.right)) + 1;
            map.put(root, depth);
        }
        return depth;
    }
}
