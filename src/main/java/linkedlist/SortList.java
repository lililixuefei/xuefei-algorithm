package linkedlist;

/**
 * @description: 排序链表
 * @author: xuefei
 * @date: 2022/03/07 23:47
 */
public class SortList {


    public Node sortListUseTopDownMergeSort(Node head) {
        return sortList(head, null);
    }

    public Node sortList(Node head, Node tail) {
        if (head == null) {
            return null;
        }
        if (head.next == tail) {
            head.next = null;
            return head;
        }
        Node slow = head, fast = head;
        while (fast != tail) {
            slow = slow.next;
            fast = fast.next;
            if (fast != tail) {
                fast = fast.next;
            }
        }
        Node mid = slow;
        Node list1 = sortList(head, mid);
        Node list2 = sortList(mid, tail);
        Node sorted = merge(list1, list2);
        return sorted;
    }


    public Node sortListUseDownTopMergeSort(Node head) {
        if (head == null) {
            return head;
        }
        int length = 0;
        Node node = head;
        while (node != null) {
            length++;
            node = node.next;
        }
        Node dummyHead = new Node(0, head);
        for (int subLength = 1; subLength < length; subLength <<= 1) {
            Node prev = dummyHead, curr = dummyHead.next;
            while (curr != null) {
                Node head1 = curr;
                for (int i = 1; i < subLength && curr.next != null; i++) {
                    curr = curr.next;
                }
                Node head2 = curr.next;
                curr.next = null;
                curr = head2;
                for (int i = 1; i < subLength && curr != null && curr.next != null; i++) {
                    curr = curr.next;
                }
                Node next = null;
                if (curr != null) {
                    next = curr.next;
                    curr.next = null;
                }
                Node merged = merge(head1, head2);
                prev.next = merged;
                while (prev.next != null) {
                    prev = prev.next;
                }
                curr = next;
            }
        }
        return dummyHead.next;
    }


    public Node merge(Node head1, Node head2) {
        Node dummyHead = new Node(0);
        Node temp = dummyHead, temp1 = head1, temp2 = head2;
        while (temp1 != null && temp2 != null) {
            if (temp1.data <= temp2.data) {
                temp.next = temp1;
                temp1 = temp1.next;
            } else {
                temp.next = temp2;
                temp2 = temp2.next;
            }
            temp = temp.next;
        }
        if (temp1 != null) {
            temp.next = temp1;
        } else if (temp2 != null) {
            temp.next = temp2;
        }
        return dummyHead.next;
    }
}
