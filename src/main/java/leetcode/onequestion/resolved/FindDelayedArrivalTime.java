package leetcode.onequestion.resolved;

/**
 * @description: 计算列车到站时间
 * @author: xuefei
 * @date: 2023/09/08 23:12
 */
public class FindDelayedArrivalTime {

    public int findDelayedArrivalTime(int arrivalTime, int delayedTime) {
        return (arrivalTime + delayedTime) % 24;
    }

}
