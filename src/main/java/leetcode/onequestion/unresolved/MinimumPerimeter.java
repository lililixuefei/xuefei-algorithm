package leetcode.onequestion.unresolved;

/**
 * @Description
 * @Author xuefei
 * @Date 2023/12/24 16:47
 * @Version 1.0
 */
public class MinimumPerimeter {

	public long minimumPerimeter(long neededApples) {
		long n = (long) Math.cbrt(neededApples / 4.0);
		if (2 * n * (n + 1) * (2 * n + 1) < neededApples) {
			n++;
		}
		return 8 * n;
	}

}
