package a.zuoshen.binary_tree;

/**
 * @description: 打印所有折痕
 * @author: xuefei
 * @date: 2022/07/05 00:44
 */
public class PaperFolding {

    public static void main(String[] args) {
        printAllFolds(3);
    }

    public static void printAllFolds(int n) {
        printProcess(1, n, true);
    }

    private static void printProcess(int i, int n, boolean down) {
        if (i > n) {
            return;
        }
        printProcess(i + 1, n, true);
        System.out.println(down ? "凹" : "凸");
        printProcess(i + 1, n, false);
    }

}
