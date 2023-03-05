package leetcode.basic.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 重排链表
 * @author: xuefei
 * @date: 2023/02/25 13:11
 */
public class ReorderList {

	public void reorderList(ListNode head) {
		if (head == null) {
			return;
		}
		List<ListNode> list = new ArrayList<>();
		ListNode node = head;
		while (node != null) {
			list.add(node);
			node = node.next;
		}
		int i = 0;
		int j = list.size() - 1;
		while (i < j) {
			list.get(i).next = list.get(j);
			i++;
			if (i == j) {
				break;
			}
			list.get(j).next = list.get(i);
			j--;
		}
		list.get(i).next = null;
	}

}
