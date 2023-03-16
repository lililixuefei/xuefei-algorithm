package leetcode.basic.prefixand;

/**
 * @description: 收集垃圾的最少总时间
 * @author: xuefei
 * @date: 2023/03/16 23:51
 */
public class GarbageCollection {

	public static void main(String[] args) {

		String[] g = new String[]{"G", "P", "GP", "GG"};
		int[] t = new int[]{2, 4, 3};
		System.out.println(garbageCollection(g, t));
	}

	public static int garbageCollection(String[] garbage, int[] travel) {
		int[] mGarbage = new int[garbage.length];
		int[] pGarbage = new int[garbage.length];
		int[] gGarbage = new int[garbage.length];
		for (int i = 0; i < garbage.length; i++) {
			char[] chars = garbage[i].toCharArray();
			int mCount = 0;
			int pCount = 0;
			int gCount = 0;
			for (char aChar : chars) {
				if (aChar == 'M') {
					mCount++;
				} else if (aChar == 'P') {
					pCount++;
				} else {
					gCount++;
				}
			}
			mGarbage[i] = mCount;
			pGarbage[i] = pCount;
			gGarbage[i] = gCount;
		}

		return calcCollectTime(travel, mGarbage) +
				calcCollectTime(travel, pGarbage) +
				calcCollectTime(travel, gGarbage);
	}

	private static int calcCollectTime(int[] travel, int[] garbage) {
		int totalCollectTime = 0;
		for (int collectTime : garbage) {
			if (collectTime == 0) {
				continue;
			}
			totalCollectTime += collectTime;
		}

		int walkTime = 0;
		for (int i = garbage.length - 1; i >= 0; i--) {
			if (garbage[i] != 0) {
				for (int j = 0; j < i; j++) {
					walkTime += travel[j];
				}
				break;
			}
		}
		totalCollectTime += walkTime;
		return totalCollectTime;
	}

}
