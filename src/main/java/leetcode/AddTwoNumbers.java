package leetcode;


/**
 * @description: 两数相加  https://leetcode-cn.com/problems/add-two-numbers/
 * @author: xuefei
 * @date: 2022/04/28 23:07
 */
public class AddTwoNumbers {
    public static void main(String[] args) {
        ListNode node1 = new ListNode(3, null);
        ListNode node2 = new ListNode(4, node1);
        ListNode l1 = new ListNode(2, node2);

        ListNode node3 = new ListNode(4, null);
        ListNode node4 = new ListNode(6, node3);
        ListNode l2 = new ListNode(5, node4);

        ListNode listNode = addTwoNumbers(l1, l2);
        while (listNode != null) {
            System.out.println(listNode.val);
            listNode = listNode.next;
        }
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode pre = new ListNode(0);
        ListNode cur = pre;
        int carry = 0;
        while (l1 != null || l2 != null) {
            int x = l1 == null ? 0 : l1.val;
            int y = l2 == null ? 0 : l2.val;
            int sum = x + y + carry;

            carry = sum / 10;
            sum = sum % 10;
            cur.next = new ListNode(sum);

            cur = cur.next;
            if (l1 != null) {
                l1 = l1.next;
            }
            if (l2 != null) {
                l2 = l2.next;
            }
        }
        if (carry == 1) {
            cur.next = new ListNode(carry);
        }
        return pre.next;
    }

   static class ListNode {
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


