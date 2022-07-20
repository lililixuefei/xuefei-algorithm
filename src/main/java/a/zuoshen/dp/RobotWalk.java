package a.zuoshen.dp;

/**
 * @description: 机器人走路
 * @author: xuefei
 * @date: 2022/07/21 00:39
 */
public class RobotWalk {

    public static void main(String[] args) {

    }

    public int walk1(int n, int start, int aim, int k) {

        return process1(start, k, aim, n);
    }

    public int process1(int cur, int rest, int aim, int n) {
        if (rest == 0) {
            return cur == aim ? 1 : 0;
        }
        if (cur == 1) {
            return process1(2, rest - 1, aim, n);
        }

        if (cur == n) {
            return process1(n - 1, rest - 1, aim, n);
        }

        return process1(cur - 1, rest - 1, aim, n) + process1(cur + 1, rest - 1, aim, n);
    }
}
