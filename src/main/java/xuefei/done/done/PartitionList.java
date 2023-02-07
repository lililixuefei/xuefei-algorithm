package xuefei.done.done;

/**
 * @description: 分割链表
 * @author: xuefei
 * @date: 2022/07/14 00:35
 */
public class PartitionList {


    // 构造两个链表
    public ListNode partition(ListNode head, int x) {
        ListNode smallNode = new ListNode();
        ListNode smallTail = smallNode;

        ListNode bigNode = new ListNode();
        ListNode bigTail = bigNode;

        while (head != null) {

            if (head.val < x) {
                smallTail.next = head;
                smallTail = smallTail.next;
            } else {
                bigTail.next = head;
                bigTail = bigTail.next;
            }

            head = head.next;
        }

        bigTail.next = null;
        smallTail.next = bigNode.next;
        return smallNode.next;
    }
}
