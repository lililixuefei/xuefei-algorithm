package labuladong.interval;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/7/11 10:25 AM
 * @Version 1.0
 */
public class IntervalIntersection {


	public int[][] intervalIntersection(int[][] firstList, int[][] secondList) {
		List<int[]> list = new ArrayList<>();

		int i = 0;
		int j = 0;
		int lenFirst = firstList.length;
		int lenSecond = secondList.length;
		while (i < lenFirst && j < lenSecond) {
			//求出两个区间中较小的左边界和较大的右边界
			int start = Math.max(firstList[i][0], secondList[j][0]);
			int end = Math.min(firstList[i][1], secondList[j][1]);

			//结果合法就加入结果
			if (start <= end) {
				list.add(new int[]{start, end});
			}

			//移动指针，移动右边界较小的区间的指针
			if (firstList[i][1] < secondList[j][1]) {
				i++;
			} else {
				j++;
			}
		}
		return list.toArray(new int[list.size()][]);
	}

}
