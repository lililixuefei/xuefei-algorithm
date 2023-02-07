package xuefei.done.done;

/**
 * @description: 环形链表 II
 * @author: xuefei
 * @date: 2022/07/14 00:56
 */
public class DetectCycle {

    public ListNode detectCycle(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode a = head;
                ListNode b = fast;
                while (a != b) {
                    a = a.next;
                    b = b.next;
                }
                return a;
            }
        }
        return null;
    }
}
