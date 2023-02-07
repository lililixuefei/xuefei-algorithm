package xuefei.done.study.zuoshen.binary_tree;

import java.util.ArrayList;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

/**
 * @description: 后序遍历
 * @author: xuefei
 * @date: 2022/07/22 00:32
 */
public class PostorderTraversal {

    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null){
            return result;
        }
        Deque<TreeNode> stack1 = new LinkedList<>();
        Deque<TreeNode> stack2 = new LinkedList<>();
        stack1.push(root);
        while (!stack1.isEmpty()){
            TreeNode treeNode = stack1.pop();
            stack2.push(treeNode);
            if (treeNode.left != null){
                stack1.push(treeNode.left);
            }
            if (treeNode.right != null){
                stack1.push(treeNode.right);
            }
        }

        while (!stack2.isEmpty()){
            result.add(stack2.pop().val);
        }

        return result;
    }
}
