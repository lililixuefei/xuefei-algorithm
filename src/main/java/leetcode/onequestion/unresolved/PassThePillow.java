package leetcode.onequestion.unresolved;

/**
 * @Description 递枕头
 * @Author xuefei
 * @Date 2023/9/26 22:02
 * @Version 1.0
 */
public class PassThePillow {

    public int passThePillow(int n, int time) {
        int t = time % (n - 1);
        return time / (n - 1) % 2 > 0 ? n - t : 1 + t;
    }

}
