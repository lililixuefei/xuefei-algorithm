package leetcode.onequestion.unresolved;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 拆分成最多数目的正偶数之和
 * @author: xuefei
 * @date: 2023/08/12 00:43
 */
public class MaximumEvenSplit {

    public static void main(String[] args) {
        List<Long> ans = maximumEvenSplit(28);
        for (Long an : ans) {
            System.out.println(an);
        }
    }

    public static List<Long> maximumEvenSplit(long finalSum) {
        List<Long> res = new ArrayList<>();
        if (finalSum % 2 > 0) {
            return res;
        }
        for (long i = 2; i <= finalSum; i += 2) {
            res.add(i);
            finalSum -= i;
        }
        res.set(res.size() - 1, res.get(res.size() - 1) + finalSum);
        return res;

    }

}
