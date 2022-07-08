package a.wushixiong.linkedlist;


/**
 * @description: 分隔链表   https://leetcode-cn.com/problems/partition-list/
 * @author: xuefei
 * @date: 2022/05/03 23:46
 */
public class PartitionLinkedList {



    /**
     * 输入：head = [1,4,3,2,5,2], x = 3
     * 输出：[1,2,2,4,3,5]
     *
     * @param head
     * @param x
     * @return
     */
    public static ListNode partition(ListNode head, int x) {

        ListNode bigHead = new ListNode(-1);
        ListNode bigTail = bigHead;

        ListNode smallHead = new ListNode(-1);
        ListNode smallTail = smallHead;

        while (head != null) {
            if (head.val < x) {
                smallTail.next = head;
                smallTail = head;
            } else {
                bigTail.next = head;
                bigTail = head;
            }
            head = head.next;
        }
        smallTail.next = bigHead.next;
        bigTail.next = null;
        return smallHead.next;
    }


    public static class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}
