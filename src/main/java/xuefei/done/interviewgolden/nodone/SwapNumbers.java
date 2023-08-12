package xuefei.done.interviewgolden.nodone;

/**
 * @description: 交换数字
 * @author: xuefei
 * @date: 2023/03/13 23:12
 */
public class SwapNumbers {

	public int[] swapNumbers(int[] numbers) {
		numbers[0] ^= numbers[1];
		numbers[1] ^= numbers[0];
		numbers[0] ^= numbers[1];
		return numbers;
	}

	public int[] swapNumbers_2(int[] numbers) {
		numbers[0] = numbers[0] + numbers[1];
		numbers[1] = numbers[0] - numbers[1];
		numbers[0] = numbers[0] - numbers[1];
		return numbers;
	}

	public int[] swapNumbers_3(int[] numbers) {
		numbers[0] = numbers[0] - numbers[1];
		numbers[1] = numbers[0] + numbers[1];
		numbers[0] = numbers[1] - numbers[0];
		return numbers;
	}


}
