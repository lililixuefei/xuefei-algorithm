package leetcode.swordfingeroffer.unresolved;



import leetcode.swordfingeroffer.Node;

import java.util.HashMap;

/**
 * @description: 剑指 Offer 35. 复杂链表的复制
 * @author: xuefei
 * @date: 2023/07/16 18:59
 */
public class CopyRandomList {

	public Node copyRandomList(Node head) {
		HashMap<Node, Node> originToClone = new HashMap<>();

		// 第一次遍历，先把所有节点克隆出来
		for (Node p = head; p != null; p = p.next) {
			if (!originToClone.containsKey(p)) {
				originToClone.put(p, new Node(p.val));
			}
		}

		// 第二次遍历，把克隆节点的结构连接好
		for (Node p = head; p != null; p = p.next) {
			if (p.next != null) {
				originToClone.get(p).next = originToClone.get(p.next);
			}
			if (p.random != null) {
				originToClone.get(p).random = originToClone.get(p.random);
			}
		}
		// 返回克隆之后的头结点
		return originToClone.get(head);
	}

}
