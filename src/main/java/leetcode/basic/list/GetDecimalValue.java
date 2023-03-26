package leetcode.basic.list;

/**
 * @description: 二进制链表转整数
 * @author: xuefei
 * @date: 2023/03/26 20:38
 */
public class GetDecimalValue {

	public int getDecimalValue(ListNode head) {
		StringBuilder binaryStr = new StringBuilder();
		while (head != null) {
			binaryStr.append(head.val);
			head = head.next;
		}
		return Integer.parseInt(binaryStr.toString(), 2);
	}

}
