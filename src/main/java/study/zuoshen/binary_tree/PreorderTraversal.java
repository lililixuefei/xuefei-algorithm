package study.zuoshen.binary_tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 先序遍历
 * @author: xuefei
 * @date: 2022/07/22 00:24
 */
public class PreorderTraversal {


    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Deque<TreeNode> stack = new LinkedList<>();
        stack.push(root);
        while (!stack.isEmpty()){
            TreeNode treeNode = stack.pop();
            result.add(treeNode.val);
            if (treeNode.right != null){
                stack.push(treeNode.right);
            }
            if (treeNode.left != null){
                stack.push(treeNode.left);
            }
        }
        return result;
    }
}
