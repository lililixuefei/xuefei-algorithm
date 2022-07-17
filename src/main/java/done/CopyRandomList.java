package done;

import java.util.HashMap;
import java.util.Map;

/**
 * @description: 复制带随机指针的链表
 * @author: xuefei
 * @date: 2022/07/17 17:41
 */
public class CopyRandomList {

    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }

        Node temp = head;
        Node dummy = new Node(-1);

        Node tempDummy = dummy;

        Map<Node,Node> map = new HashMap<>();

        while (head != null){
            Node newNode = new Node(head.val);
            map.put(head,newNode);
            dummy.next = newNode;
            head = head.next;
            dummy = dummy.next;
        }

        while (temp != null){
            Node randomNode = temp.random;
            Node copyNode = map.get(temp);
            Node copyRandomNode = map.get(randomNode);
            copyNode.random = copyRandomNode;
            temp = temp.next;
        }

        return tempDummy.next;
    }
}
