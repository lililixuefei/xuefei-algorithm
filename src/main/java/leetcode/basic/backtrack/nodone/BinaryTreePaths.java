package leetcode.basic.backtrack.nodone;

import leetcode.basic.binarytree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 二叉树的所有路径
 * @author: xuefei
 * @date: 2023/03/12 14:10
 */
public class BinaryTreePaths {

	public List<String> binaryTreePaths(TreeNode root) {
		List<String> paths = new ArrayList<>();
		constructPaths(root, "", paths);
		return paths;
	}

	public void constructPaths(TreeNode root, String path, List<String> paths) {
		if (root == null) {
			return;
		}
		StringBuilder pathSB = new StringBuilder(path);
		pathSB.append(root.val);
		if (root.left == null && root.right == null) {  // 当前节点是叶子节点
			paths.add(pathSB.toString());  // 把路径加入到答案中
		} else {
			pathSB.append("->");  // 当前节点不是叶子节点，继续递归遍历
			constructPaths(root.left, pathSB.toString(), paths);
			constructPaths(root.right, pathSB.toString(), paths);
		}
	}

}
