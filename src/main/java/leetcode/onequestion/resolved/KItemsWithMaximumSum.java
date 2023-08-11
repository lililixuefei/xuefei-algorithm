package leetcode.onequestion.resolved;

/**
 * @description: K 件物品的最大和
 * @author: xuefei
 * @date: 2023/08/12 00:34
 */
public class KItemsWithMaximumSum {

    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        if (k <= numOnes) {
            return k;
        }
        if (numOnes + numZeros > k) {
            return numOnes;
        }
        int i = k - numOnes - numZeros;
        return numOnes - i;
    }

}
