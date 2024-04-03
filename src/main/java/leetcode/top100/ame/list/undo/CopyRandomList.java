package leetcode.top100.ame.list.undo;


import xuefei.done.done.Node;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/4/1 22:21
 * @Version 1.0
 */
public class CopyRandomList {

	public Node copyRandomList(Node head) {
		Map<Node, Node> map = new HashMap<>();
		Node temp = head;
		while (temp != null) {
			map.put(temp, new Node(temp.val));
			temp = temp.next;
		}
		for (Node p = head; p != null; p = p.next) {
			if (p.next != null) {
				map.get(p).next = map.get(p.next);
			}
			if (p.random != null) {
				map.get(p).random = map.get(p.random);
			}
		}
		return map.get(head);
	}

}
