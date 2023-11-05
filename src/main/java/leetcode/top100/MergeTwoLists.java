package leetcode.top100;

import labuladong.list.ListNode;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/11/5 19:31
 * @Version 1.0
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode temp = dummy;
        while (list1 != null && list2 != null) {
            if (list1.val < list2.val) {
                temp.next = list1;
                list1 = list1.next;
            } else {
                temp.next = list2;
                list2 = list2.next;
            }
            temp = temp.next;
        }
        if (list1 != null){
            temp.next = list1;
        }
        if (list2 != null){
            temp.next = list2;
        }
        return dummy.next;
    }

}
