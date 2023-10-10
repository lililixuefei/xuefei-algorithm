package lingcha;

import java.util.Collections;
import java.util.List;

/**
 * https://leetcode.cn/problems/minimum-processing-time/solutions/2472127/tan-xin-pythonjavacgo-by-endlesscheng-8fzf/
 *
 * @Description 最小处理时间
 * @Author xuefei
 * @Date 2023/10/10 22:02
 * @Version 1.0
 */
public class MinProcessingTime {

    public int minProcessingTime(List<Integer> processorTime, List<Integer> tasks) {
        Collections.sort(processorTime);
        tasks.sort(Collections.reverseOrder());
        int ans = 0;
        for (int i = 0; i < processorTime.size(); i++) {
            ans = Math.max(ans, processorTime.get(i) + tasks.get(i * 4));
        }
        return ans;
    }

}
