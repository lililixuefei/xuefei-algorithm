package leetcode.basic.binarytree;


/**
 * @description: 填充每个节点的下一个右侧节点指针
 * @author: xuefei
 * @date: 2023/02/27 22:49
 */
public class Connect {

	public Node connect(Node root) {
		if (root == null){
			return null;
		}
		traverse(root.left, root.right);
		return root;
	}


	public void traverse(Node left, Node right) {
		if (left == null || right == null) {
			return;
		}

		left.next = right;

		Node lLeft = left.left;
		Node lRight = left.right;
		Node rLeft = right.left;
		Node rRight = right.right;

		traverse(lLeft, lRight);
		traverse(lRight, rLeft);
		traverse(rLeft, rRight);
	}

}
