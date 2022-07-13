package done;

import java.util.List;

/**
 * @description: 合并两个有序链表
 * @author: xuefei
 * @date: 2022/07/14 00:19
 */
public class MergeTwoLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode dummy = new ListNode();
        ListNode temp = dummy;

        while (list1 != null || list2 != null){
            if (list1 == null){
                dummy.next = list2;
                break;
            }
            if (list2 == null){
                dummy.next = list1;
                break;
            }

            if (list1.val <= list2.val){
                dummy.next = list1;
                list1 = list1.next;
            }else {
                dummy.next = list2;
                list2 = list2.next;
            }
            dummy = dummy.next;

        }
        return temp.next;
    }
}
