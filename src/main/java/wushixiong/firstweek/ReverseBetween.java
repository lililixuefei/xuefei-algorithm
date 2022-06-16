package wushixiong.firstweek;


/**
 * @description: 翻转链表II
 * @author: xuefei
 * @date: 2022/06/16 22:42
 */
public class ReverseBetween {


    public ListNode reverseBetween(ListNode head, int left, int right) {

        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;

        for (int i = 0; i < left - 1; i++) {
            pre = pre.next;
            cur = cur.next;
        }

        for (int i = 0; i < right - left; i++) {

            ListNode temp = cur.next;

            cur.next = cur.next.next;

            temp.next = pre.next;

            pre.next = temp;

        }

        return dummy.next;
    }
}
