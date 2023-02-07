package xuefei.done.study.zuoshen;


/**
 * @description: 翻转链表
 * @author: xuefei
 * @date: 2022/05/03 13:18
 */
public class ReverseList {


    public static void main(String[] args) {
        Node node5 = new Node(null, 5);
        Node node4 = new Node(node5, 4);
        Node node3 = new Node(node4, 3);
        Node node2 = new Node(node3, 2);
        Node node1 = new Node(node2, 1);


        Node node = reverseLinkedList(node1);
        while (node != null){
            System.out.println(node.data);
            node = node.next;
        }

    }

    public static Node reverseLinkedList(Node head) {
        Node pre = null;
        Node next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            pre = head;
            head = next;
        }
        return pre;
    }

    public static DoubleNode reverseDoubleLinkedList(DoubleNode head) {
        DoubleNode pre = null;
        DoubleNode next = null;
        while (head != null) {
            next = head.next;
            head.next = pre;
            head.last = next;
            pre = head;
            head = next;
        }
        return pre;
    }

    static class Node {
        Node next;
        Integer data;

        public Node(Node next, Integer data) {
            this.next = next;
            this.data = data;
        }

        public Node() {

        }
    }

    static class DoubleNode {
        DoubleNode last;
        DoubleNode next;
        Integer data;

        public DoubleNode() {

        }
    }

}


