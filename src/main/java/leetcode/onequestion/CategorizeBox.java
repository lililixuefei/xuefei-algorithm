package leetcode.onequestion;

/**
 * @Description 根据规则将箱子分类
 * @Author xuefei
 * @Date 2023/10/20 22:22
 * @Version 1.0
 */
public class CategorizeBox {

    public String categorizeBox(int length, int width, int height, int mass) {
        boolean x = length >= 10000 || width >= 10000 || height >= 10000 || (long) length * width * height >= 1000000000;
        boolean y = mass >= 100;
        if (x && y) {
            return "Both";
        }
        if (x) {
            return "Bulky";
        }
        if (y) {
            return "Heavy";
        }
        return "Neither";
    }


}
