package done;

import java.util.Deque;
import java.util.LinkedList;

/**
 * @description: 反转链表 II
 * @author: xuefei
 * @date: 2022/07/14 23:11
 */
public class ReverseBetween {

    public static void main(String[] args) {
//        ListNode node5 = new ListNode(5,null);
//        ListNode node4 = new ListNode(4,node5);
//        ListNode node3 = new ListNode(3,node4);
//        ListNode node2 = new ListNode(2,node3);
//        ListNode node1 = new ListNode(1,node2);


        ListNode node2 = new ListNode(5,null);
        ListNode node1 = new ListNode(3,node2);

        System.out.println(reverseBetween(node1,1,2));
    }

    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if(head.next == null){
            return head;
        }
        ListNode temp = head;
        ListNode temp2 = temp;
        int index = 0;
        Deque<ListNode> stack = new LinkedList<>();
        while (head != null) {
            index++;
            if (index >= left && index <= right) {
                stack.push(head);
            }
            head = head.next;
        }

        ListNode peek = stack.peek();
        ListNode next = peek.next;

        int pre = 1;

        if (left == 1){
            pre = 0;
        }

        while (temp != null) {
            if (++pre == left) {
                break;
            }
            temp = temp.next;
        }

        if (temp != null) {
            while (!stack.isEmpty()) {
                temp.next = stack.pop();
                temp = temp.next;
            }
        }

        if (temp != null) {
            temp.next = next;
        }
        return temp2;
    }
}
