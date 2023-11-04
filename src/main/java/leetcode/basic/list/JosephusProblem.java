package leetcode.basic.list;


/**
 * @description:
 * @author: xuefei
 * @date: 2023/11/02 11:00
 */
public class JosephusProblem {

    public static ListNode josephusKill(ListNode head, int m) {
        if (head == null || head.next == null || m < 1) {
            return head;
        }
        ListNode last = head;
        while (last.next != head) {
            last = last.next;
        }
        int count = 0;
        while (head != last) {
            if (++count == m) {
                last.next = head.next;
                count = 0;
            } else {
                last = last.next;
            }
            head = last.next;
        }
        return head;
    }
}
