package leetcode.basic.list;

/**
 * @description: 合并零之间的节点
 * @author: xuefei
 * @date: 2023/03/26 19:33
 */
public class MergeNodes {

	public ListNode mergeNodes(ListNode head) {
		ListNode dummy = new ListNode();
		ListNode temp = dummy;
		int sum = 0;
		while (head != null) {
			if (head.val == 0) {
				sum = 0;
			} else {
				sum += head.val;
				if (head.next != null && head.next.val == 0) {
					temp.next = new ListNode(sum);
					temp = temp.next;
				}
			}
			head = head.next;
		}
		return dummy.next;
	}

}
