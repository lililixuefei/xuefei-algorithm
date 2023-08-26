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
