package leetcode.interviewgolden.resolved;

/**
 * @Description 交换数字
 * @Author xuefei
 * @Date 2023/9/16 14:36
 * @Version 1.0
 */
public class SwapNumbers {

    public int[] swapNumbers(int[] numbers) {
        numbers[0] = numbers[0] ^ numbers[1];
        numbers[1] = numbers[0] ^ numbers[1];
        numbers[0] = numbers[0] ^ numbers[1];
        return numbers;
    }


}
