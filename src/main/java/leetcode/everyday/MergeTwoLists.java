package leetcode.everyday;

import leetcode.linkedlist.ListNode;

/**
 * @description: 合并两个有序链表   https://leetcode.cn/problems/merge-two-sorted-lists/
 * @author: xuefei
 * @date: 2022/06/28 22:40
 */
public class MergeTwoLists {


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;

        ListNode list1Head = list1;
        ListNode list2Head = list2;
        while (list1Head != null || list2Head != null) {
            if (list1Head == null) {
                dummy.next = list2Head;
                break;
            }
            if (list2Head == null) {
                dummy.next = list1Head;
                break;
            }

            int val1 = list1Head.val;
            int val2 = list2Head.val;
            if (val1 <= val2) {
                dummy.next = list1Head;
                list1Head = list1Head.next;
            } else {
                dummy.next = list2Head;
                list2Head = list2Head.next;
            }
            dummy = dummy.next;
        }
        return head.next;
    }
}
