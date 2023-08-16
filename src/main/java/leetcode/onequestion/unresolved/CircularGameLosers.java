package leetcode.onequestion.unresolved;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * @description: 找出转圈游戏输家
 * @author: xuefei
 * @date: 2023/08/16 23:04
 */
public class CircularGameLosers {

    public int[] circularGameLosers(int n, int k) {
        Set<Integer> set = new HashSet<>();
        int global = 0;
        int i = 1;
        while (!set.contains(global)) {
            set.add(global);
            global = (global + i * k) % n;
            i++;
        }

        List<Integer> list = new ArrayList<>();
        for (int m = 0; m < n; m++) {
            if (!set.contains(m)) {
                list.add(m + 1);
            }
        }
        return list.stream().mapToInt(x -> x).toArray();
    }

}
