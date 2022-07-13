package done;

/**
 * @description: 翻转链表
 * @author: xuefei
 * @date: 2022/07/13 23:44
 */
public class ReverseList {

    // 递归
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode node = reverseList(head.next);
        head.next.next = head;
        head.next = null;

//        head.next = null;
//        node.next = head;
        return node;
    }
}
