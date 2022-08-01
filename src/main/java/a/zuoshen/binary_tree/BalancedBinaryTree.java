package a.zuoshen.binary_tree;

/**
 * @description: 平衡二叉树
 * @author: xuefei
 * @date: 2022/08/01 23:32
 */
public class BalancedBinaryTree {

    public boolean isBalanced(TreeNode root) {

        return process(root).isBalanced;
    }

    private Info process(TreeNode node) {
        if (node == null){
            return new Info(true,0);
        }
        Info leftInfo = process(node.left);
        Info rightInfo = process(node.right);

        int height = Math.max(leftInfo.height,rightInfo.height) + 1;

        boolean isBalanced = true;

        if (!leftInfo.isBalanced){
            isBalanced = false;
        }
        if (!rightInfo.isBalanced){
            isBalanced = false;
        }

        if (Math.abs(leftInfo.height - rightInfo.height) > 1){
            isBalanced = false;
        }
        return new Info(isBalanced,height);

    }

    class Info{
        boolean isBalanced;
        int height;

        public Info(boolean isBalanced, int height) {
            this.isBalanced = isBalanced;
            this.height = height;
        }
    }
}

