package xuefei.done.basic.linkedlist.node;

/**
 * @description:
 * @author: xuefei
 * @date: 2022/05/09 23:54
 */
public class ListNode {

    public int val;
    public ListNode next;

    public ListNode() {
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}
