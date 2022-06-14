package wushixiong.firstweek;


/**
 * @description: 分隔链表
 * @author: xuefei
 * @date: 2022/06/14 23:27
 */
public class SeparatedList {

    public ListNode partition(ListNode head, int x) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode bigHead = new ListNode(-1);
        ListNode bigTail = bigHead;

        ListNode smallHead = new ListNode(-1);
        ListNode smallTail = smallHead;

        while (head != null) {
            if (head.val >= x) {
                bigTail.next = head;
                bigTail = head;
            } else {
                smallTail.next = head;
                smallTail = head;
            }
            head = head.next;
            bigTail.next = null;
        }
        smallTail.next = bigHead.next;
        return smallHead.next;
    }
}
