package leetcode.basic.list;

import labuladong.list.ListNode;

/**
 * @description:
 * @author: xuefei
 * @date: 2023/10/31 16:26
 */
public class PrintCommonPart {


    public static void printCommonPart(ListNode head1, ListNode head2) {
        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                head1 = head1.next;
            } else if (head1.val > head2.val) {
                head2 = head2.next;
            } else {
                System.out.println(head1.val);
                head1 = head1.next;
                head2 = head2.next;
            }
        }
    }


}
