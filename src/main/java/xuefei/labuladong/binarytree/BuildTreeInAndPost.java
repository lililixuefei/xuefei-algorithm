package xuefei.labuladong.binarytree;

import java.util.HashMap;

/**
 * @description:
 * @author: xuefei
 * @date: 2023/02/19 13:44
 */
public class BuildTreeInAndPost {


    // 存储 inorder 中值到索引的映射
    HashMap<Integer, Integer> valToIndex = new HashMap<>();


    /**
     * 通过后序和中序遍历结果构造二叉树
     *
     * @param inorder
     * @param postorder
     * @return
     */
    TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            valToIndex.put(inorder[i], i);
        }
        return build2(inorder, 0, inorder.length - 1,
                postorder, 0, postorder.length - 1);
    }


    TreeNode build2(int[] inorder, int inStart, int inEnd,
                    int[] postorder, int postStart, int postEnd) {

        if (inStart > inEnd) {
            return null;
        }
        // root 节点对应的值就是后序遍历数组的最后一个元素
        int rootVal = postorder[postEnd];
        // rootVal 在中序遍历数组中的索引
        int index = valToIndex.get(rootVal);
        // 左子树的节点个数
        int leftSize = index - inStart;
        TreeNode root = new TreeNode(rootVal);
        // 递归构造左右子树
        root.left = build2(inorder, inStart, index - 1,
                postorder, postStart, postStart + leftSize - 1);

        root.right = build2(inorder, index + 1, inEnd,
                postorder, postStart + leftSize, postEnd - 1);
        return root;
    }

}
