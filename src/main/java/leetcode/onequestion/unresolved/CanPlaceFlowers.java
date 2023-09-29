package leetcode.onequestion.unresolved;

/**
 * @Description 种花问题
 * @Author xuefei
 * @Date 2023/9/29 21:13
 * @Version 1.0
 */
public class CanPlaceFlowers {

	public boolean canPlaceFlowers(int[] flowerbed, int n) {
		int count = 0;
		for (int i = 0; i < flowerbed.length; i++) {
			if ((i == 0 || flowerbed[i - 1] == 0) && flowerbed[i] == 0 && (i == flowerbed.length - 1 || flowerbed[i + 1] == 0)) {
				count += 1;
				flowerbed[i] = 1;
			}
		}
		return count >= n;
	}

}
