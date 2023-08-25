package leetcode.onequestion.resolved;

import labuladong.binarytree.TreeNode;

/**
 * @description: 1448. 统计二叉树中好节点的数目
 * @author: xuefei
 * @date: 2023/08/25 22:14
 */
public class GoodNodes {


    public int goodNodes(TreeNode root) {
        int ans = 1;
        ans += dfs(root.left, root.val);
        ans += dfs(root.right, root.val);
        return ans;
    }

    private int dfs(TreeNode node, int val) {
        if (node == null) {
            return 0;
        }

        int ans = 0;
        if (node.val >= val) {
            ans++;
            val = node.val;
        }
        ans += dfs(node.left, val);
        ans += dfs(node.right, val);
        return ans;
    }
}
