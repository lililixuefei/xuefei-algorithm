package leetcode.interviewgolden.unresolved;

import labuladong.binarytree.TreeNode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/**
 * @description: 首个共同祖先
 * @author: xuefei
 * @date: 2023/08/26 17:12
 */
public class LowestCommonAncestor {


    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        // 到底了还没找到，返回 null
        if (root == null) {
            return null;
        }
        // 如果找到了 p 或 q，返回它
        if (root == p || root == q) {
            return root;
        }
        TreeNode left = lowestCommonAncestor2(root.left, p, q);  // left 记录 p 或 q 是在左子树找到的
        TreeNode right = lowestCommonAncestor2(root.right, p, q); // right 记录 p 或 q 是在右子树找到的
        // 如果 left 和 right 都记录了找到的节点，那么肯定是一个记录了 p ，另一个记录了 q
        // 它们分别在以 root 为根的左右子树中，所以 root 就是它们的最近公共祖先
        if (left != null && right != null) {
            return root;
        }
        // 由于节点 p,q 一定在二叉树中，left和right不会同时为null
        // 若 left != null && right == null，说明在左子树中找到 p 或 q，而在右子树找不到 p 或 q，则剩下一个也在左子树
        // 所以 left 就是最近公共祖先
        // 另一种情况同理
        return (left != null) ? left : right;
    }


    Map<TreeNode, TreeNode> map = new HashMap<>();

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        buildParentMap(root, null);

        Set<TreeNode> set = new HashSet<>();
        while (p != null) {
            set.add(p);
            p = map.get(p);
        }
        while (q != null) {
            if (set.contains(q)) {
                break;
            }
            q = map.get(q);
        }
        return q;
    }


    private void buildParentMap(TreeNode node, TreeNode parent) {
        if (node == null) {
            return;
        }
        map.put(node, parent);
        buildParentMap(node.left, node);
        buildParentMap(node.right, node);
    }

}
