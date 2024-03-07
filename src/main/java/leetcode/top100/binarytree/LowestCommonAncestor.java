package leetcode.top100.binarytree;

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


    // 定义一个哈希映射，用于存储每个节点及其父节点的关系
    Map<TreeNode, TreeNode> map = new HashMap<>();

    /**
     * 寻找二叉树中两个节点的最近公共祖先
     *
     * @param root 二叉树的根节点
     * @param p    第一个节点
     * @param q    第二个节点
     * @return 返回最近公共祖先节点
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        // 构建每个节点与其父节点的映射关系
        buildParentMap(root, null);

        // 使用集合存储从节点p到根节点路径上的所有节点
        Set<TreeNode> set = new HashSet<>();
        while (p != null) {
            set.add(p);
            // 向上移动到p的父节点
            p = map.get(p);
        }
        // 从节点q开始向上遍历，直到找到集合中已存在的节点，即为最近公共祖先
        while (q != null) {
            if (set.contains(q)) {
                break;
            }
            // 向上移动到q的父节点
            q = map.get(q);
        }
        // 返回最近公共祖先节点
        return q;
    }

    /**
     * 递归构建每个节点与其父节点的映射关系
     *
     * @param node   当前遍历到的节点
     * @param parent 当前节点的父节点
     */
    private void buildParentMap(TreeNode node, TreeNode parent) {
        // 如果节点为空，直接返回
        if (node == null) {
            return;
        }
        // 将当前节点及其父节点放入映射中
        map.put(node, parent);
        // 递归构建左子树的父节点映射
        buildParentMap(node.left, node);
        // 递归构建右子树的父节点映射
        buildParentMap(node.right, node);
    }


}
