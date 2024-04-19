package leetcode.top100.greed;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author xuefei
 * @Date 2024/3/24 19:55
 * @Version 1.0
 */
public class PartitionLabels {

	public static void main(String[] args) {
		String s = "ababcbacadefegdehijhklij";
		List<Integer> partition = partitionLabels(s);
		System.out.println(partition.toString());
	}


	public static List<Integer> partitionLabels(String s) {
		int[] last = new int[26];
		int length = s.length();
		for (int i = 0; i < length; i++) {
			last[s.charAt(i) - 'a'] = i;
		}
		List<Integer> partition = new ArrayList<Integer>();
		int start = 0, end = 0;
		for (int i = 0; i < length; i++) {
			end = Math.max(end, last[s.charAt(i) - 'a']);
			if (i == end) {
				partition.add(end - start + 1);
				start = end + 1;
			}
		}
		return partition;
	}

}
