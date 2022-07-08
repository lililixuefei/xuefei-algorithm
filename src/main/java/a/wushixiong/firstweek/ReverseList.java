package a.wushixiong.firstweek;


/**
 * @description: 翻转链表
 * @author: xuefei
 * @date: 2022/06/12 21:35
 */
public class ReverseList {

    public static void main(String[] args) {

    }


    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode cur = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return cur;
    }
}
