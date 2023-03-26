package leetcode.basic.list;

/**
 * @description: 合并两个链表
 * @author: xuefei
 * @date: 2023/03/26 20:06
 */
public class MergeInBetween {

	public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
		ListNode dummy = list1;
		int index = 0;
		while (list1 != null) {
			if (index + 1 == a) {
				int p = index;
				while (list1.next != null && p < b) {
					list1.next = list1.next.next;
					p++;
				}
				ListNode nextList = list1.next;
				list1.next = list2;
				while (list1.next != null) {
					list1 = list1.next;
				}
				list1.next = nextList;
			}
			index++;
			list1 = list1.next;
		}
		return dummy;
	}

}
