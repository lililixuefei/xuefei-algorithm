package leetcode.swordfingeroffer;

/**
 * @description:
 * @author: xuefei
 * @date: 2023/07/16 19:08
 */
public class Node {
	public int val;
	public Node next;
	public Node random;

	public Node(int val) {
		this.val = val;
		this.next = null;
		this.random = null;
	}
}