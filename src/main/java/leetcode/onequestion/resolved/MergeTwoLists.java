package leetcode.onequestion.resolved;

import labuladong.list.ListNode;

/**
 * @description: 合并两个有序链表
 * @author: xuefei
 * @date: 2023/08/05 21:20
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode head = new ListNode();
        ListNode dummy = head;
        while (list1 != null && list2 != null) {
            int val1 = list1.val;
            int val2 = list2.val;
            if (val1 < val2) {
                dummy.next = list1;
                list1 = list1.next;
            } else {
                dummy.next = list2;
                list2 = list2.next;
            }
            dummy = dummy.next;
        }
        if (list1 != null) {
            dummy.next = list1;

        }
        if (list2 != null) {
            dummy.next = list2;

        }
        return head.next;
    }
}
