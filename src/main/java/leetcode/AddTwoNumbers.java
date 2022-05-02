package leetcode;

import xuefei.jdk.LinkedList;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import java.util.stream.Collectors;

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

//    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
//        List<Integer> list1 = new ArrayList<>();
//        List<Integer> list2 = new ArrayList<>();
//        while (l1 != null) {
//            list1.add(l1.val);
//            l1 = l1.next;
//        }
//        while (l2 != null) {
//            list2.add(l2.val);
//            l2 = l2.next;
//        }
//
//        StringBuilder sb1 = new StringBuilder();
//        StringBuilder sb2 = new StringBuilder();
//
//        for (int i = list1.size() - 1; i >= 0; i--) {
//            sb1.append(list1.get(i));
//        }
//        for (int i = list2.size() - 1; i >= 0; i--) {
//            sb2.append(list2.get(i));
//        }
//        long result = Long.parseLong(sb1.toString()) + Long.parseLong(sb2.toString());
//
//        String resultStr = String.valueOf(result);
//
//        char[] chars = resultStr.toCharArray();
//
//        List<ListNode> listNodes = new ArrayList<>();
//
//        for (int i = 0; i < chars.length; i++) {
//            ListNode listNode = new ListNode();
//            listNode.val = Integer.parseInt(String.valueOf(chars[i]));
//            listNodes.add(listNode);
//        }
//
//
//        for (int i = 0; i < listNodes.size(); i++) {
//            if (i + 1 < listNodes.size()) {
//                listNodes.get(i).next = listNodes.get(i + 1);
//            }
//        }
//
//        return listNodes.get(0);
//    }
}

class ListNode {
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
