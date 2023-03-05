package leetcode.basic.queue;

import java.util.Arrays;

/**
 * @description: 无法吃午餐的学生数量
 * @author: xuefei
 * @date: 2023/02/25 19:29
 */
public class CountStudents {

	public int countStudents(int[] students, int[] sandwiches) {
		int s1 = Arrays.stream(students).sum();
		int s0 = students.length - s1;
		for (int sandwich : sandwiches) {
			if (sandwich == 0 && s0 > 0) {
				s0--;
			} else if (sandwich == 1 && s1 > 0) {
				s1--;
			} else {
				break;
			}
		}
		return s0 + s1;
	}

}
