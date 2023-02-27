package leetcode.list;

/**
 * @description: 237. 删除链表中的节点
 * @author: xuefei
 * @date: 2023/02/27 23:11
 */
public class DeleteNode {

	public static void main(String[] args) {
		ListNode node1 = new ListNode(2);
		ListNode node2 = new ListNode(0);
		ListNode node3 = new ListNode(1);
		ListNode node4 = new ListNode(3);
		node1.next = node2;
		node2.next = node3;
		node3.next = node4;

		deleteNode(node1);
	}


	public static void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}

}
