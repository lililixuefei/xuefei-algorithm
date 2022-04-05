package linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * @description: 链表是否有环
 * @author: xuefei
 * @date: 2022/03/03 00:16
 */
public class HasCycle {
    public static void main(String[] args) {

    }

    /**
     * 链表是否有环-使用Set
     *
     * @param head
     * @return
     */
    public boolean hasCycleUseSet(Node head) {
        Set<Node> s = new HashSet();
        //定义一个set，然后不断遍历
        while (head != null) {
            //只要某个节点在set中出现过，说明遍历到重复元素了
            if (s.contains(head)) {
                return true;
            }
            s.add(head);
            head = head.next;
        }
        return false;
    }

    /**
     * 链表是否有环-快慢指针
     *
     * @param head
     * @return
     */
    public boolean hasCycleUseSF(Node head) {
        if (head == null || head.next == null) {
            return false;
        }
        //定义两个指针i和j，i是慢指针，j是快指针
        Node i = head;
        Node j = head.next;
        while (j != null && j.next != null) {
            if (i == j) {
                return true;
            }
            //i每次走一步，j每次走两步
            i = i.next;
            j = j.next.next;
        }
        return false;
    }
}
