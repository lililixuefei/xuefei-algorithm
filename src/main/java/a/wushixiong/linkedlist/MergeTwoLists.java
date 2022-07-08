package a.wushixiong.linkedlist;

/**
 * @description: 合并两个有序链表   https://leetcode-cn.com/problems/merge-two-sorted-lists/
 * @author: xuefei
 * @date: 2022/05/03 23:29
 */
public class MergeTwoLists {

    public static void main(String[] args) {

    }


    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        ListNode dummy = new ListNode(-1);
        ListNode pre = dummy;

        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                pre.next = list1;
                list1 = list1.next;
            } else {
                pre.next = list2;
                list2 = list2.next;
            }
            pre = pre.next;
        }
        if (list1 != null) {
            pre.next = list1;
        }

        if (list2 != null) {
            pre.next = list2;
        }
        return dummy.next;

    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
