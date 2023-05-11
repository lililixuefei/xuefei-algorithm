package zuoshen.daily;

/**
 * @description:
 * @author: xuefei
 * @date: 2023/05/11 22:53
 */
public class MinCostMostE {

	/**
	 * 小红拿到了一个仅有r、e、d组成的字符串
	 * 定义一个字符 e 为 好e：当且仅当这个字符 e 和 r 、d 相邻
	 * 例如 "reeder" 只有一个 好e
	 * 小红每次可以将任意字符修改为任意字符
	 * 她希望 好e 的数量尽可能的多
	 * 小红想知道最少需要修改多少次
	 */

	static class Info {
		private final int mostGoodE;
		private final int minCost;

		public Info(int mostGoodE, int minCost) {
			this.mostGoodE = mostGoodE;
			this.minCost = minCost;
		}
	}


	public static Info minCostMostE(char[] s, int i, char prepre, char pre) {
		if (i == s.length) {
			return new Info(0, 0);
		}

		// 可能性1 i-1 [i] -> r
		int cur1Value = prepre == 'd' && pre == 'e' ? 1 : 0;
		int cur1Cost = s[i] == 'r' ? 0 : 1;
		Info info1 = minCostMostE(s, i + 1, pre, 'r');
		int p1Value = cur1Value + info1.mostGoodE;
		int p1Cost = cur1Cost + info1.minCost;

		// 可能性2 i-1 [i] -> e
		int cur2Value = 0;
		int cur2Cost = s[i] == 'e' ? 0 : 1;
		Info info2 = minCostMostE(s, i + 1, pre, 'e');
		int p2Value = cur2Value + info2.mostGoodE;
		int p2Cost = cur2Cost + info2.minCost;

		// 可能性3 i-1 [i] -> d
		int cur3Value = prepre == 'r' && pre == 'e' ? 1 : 0;
		int cur3Cost = s[i] == 'd' ? 0 : 1;
		Info info3 = minCostMostE(s, i + 1, pre, 'd');
		int p3Value = cur3Value + info3.mostGoodE;
		int p3Cost = cur3Cost + info3.minCost;

		int mostE = 0;
		int minCost = Integer.MAX_VALUE;

		if (mostE < p1Value) {
			mostE = p1Value;
			minCost = p1Cost;
		} else if (mostE == p1Value) {
			minCost = Math.min(minCost, p1Cost);
		}

		if (mostE < p2Value) {
			mostE = p2Value;
			minCost = p2Cost;
		} else if (mostE == p2Value) {
			minCost = Math.min(minCost, p2Cost);
		}

		if (mostE < p3Value) {
			mostE = p3Value;
			minCost = p3Cost;
		} else if (mostE == p3Value) {
			minCost = Math.min(minCost, p3Cost);
		}

		return new Info(mostE, minCost);

	}

}
