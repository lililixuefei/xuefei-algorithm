package leetcode.basic.list;


import java.util.HashSet;
import java.util.Set;

/**
 * @description:
 * @author: xuefei
 * @date: 2023/11/01 14:41
 */
public class RemoveRepetition {


    public static void removeRep1(ListNode head) {
        if (head == null) {
            return;
        }
        HashSet<Integer> set = new HashSet<>();
        ListNode pre = head;
        ListNode cur = head.next;
        set.add(head.val);
        while (cur != null) {
            if (set.contains(cur.val)) {
                pre.next = cur.next;
            } else {
                set.add(cur.val);
                pre = cur;
            }
            cur = cur.next;
        }
    }


    public ListNode removeDuplicateNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        Set<Integer> set = new HashSet<>();
        ListNode temp = head;
        set.add(temp.val);
        while (temp.next != null) {
            if (set.contains(temp.next.val)) {
                temp.next = temp.next.next;
            } else {
                set.add(temp.next.val);
                temp = temp.next;
            }
        }
        return head;
    }


}
