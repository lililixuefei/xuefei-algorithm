package xuefei.done.interviewgolden;

import xuefei.labuladong.list.ListNode;

/**
 * @description: 删除中间节点
 * @author: xuefei
 * @date: 2023/04/02 12:37
 */
public class DeleteNode {

	public void deleteNode(ListNode node) {
		node.val = node.next.val;
		node.next = node.next.next;
	}

}
