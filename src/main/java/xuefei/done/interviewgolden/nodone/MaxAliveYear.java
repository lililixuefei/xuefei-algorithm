package xuefei.done.interviewgolden.nodone;


/**
 * @description: 生存人数
 * @author: xuefei
 * @date: 2023/03/13 23:23
 */
public class MaxAliveYear {

	public int maxAliveYear(int[] birth, int[] death) {
		int maxAliveYear = 0;
		int maxAliveCount = 0;
		for (int i = 1900; i <= 2000; i++) {
			int aliveCount = 0;
			for (int k = 0; k < birth.length; k++) {
				if (i >= birth[k] && i <= death[k]) {
					aliveCount++;
					if (aliveCount > maxAliveCount) {
						maxAliveCount = aliveCount;
						maxAliveYear = i;
					}
				}
			}
		}
		return maxAliveYear;
	}

}
