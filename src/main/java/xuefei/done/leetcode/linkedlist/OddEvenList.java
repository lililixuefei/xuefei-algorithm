package xuefei.done.leetcode.linkedlist;

/**
 * @description: 奇偶链表   https://leetcode.cn/problems/odd-even-linked-list/
 * @author: xuefei
 * @date: 2022/06/08 23:33
 */
public class OddEvenList {

    public static void main(String[] args) {

    }


    public static ListNode oddEvenList(ListNode head) {
        if (head == null) {
            return head;
        }
        ListNode evenHead = head.next;
        ListNode odd = head;
        ListNode even = evenHead;
        while (even != null && even.next != null) {
            odd.next = even.next;
            odd = odd.next;
            even.next = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        return head;
    }
}
