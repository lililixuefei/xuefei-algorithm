package zuoshen.follow;

/**
 * @description: 汉诺塔问题
 * @author: xuefei
 * @date: 2023/05/13 20:09
 */
public class HanoiProblem {

	public static void main(String[] args) {
		HanoiProblem hanoiProblem = new HanoiProblem();
		hanoiProblem.hanoi1(3);
		System.out.println("-----");
		hanoiProblem.hanoi2(3);
	}


	public void hanoi1(int n) {
		leftToRight(n);
	}

	public void hanoi2(int n) {
		func(n, "left", "right", "other");
	}

	public void func(int n, String from, String to, String other) {
		if (n == 1) {
			System.out.println("move 1 " + from + " to " + to);
		} else {
			func(n - 1, from, other, to);
			System.out.println("move " + n + " " + from + " to " + to);
			func(n - 1, other, to, from);
		}
	}

	private void leftToRight(int n) {
		if (n == 1) {
			System.out.println("move 1 left to right");
			return;
		}
		leftToMid(n - 1);
		System.out.println("move " + n + " left to right");
		midToRight(n - 1);
	}

	private void leftToMid(int n) {
		if (n == 1) {
			System.out.println("move 1 left to mid");
			return;
		}
		leftToRight(n - 1);
		System.out.println("move " + n + " left to mid");
		rightToMid(n - 1);

	}

	private void rightToMid(int n) {
		if (n == 1) {
			System.out.println("move 1 right to mid");
			return;
		}
		rightToLeft(n - 1);
		System.out.println("move " + n + " right to mid");
		leftToMid(n - 1);
	}

	private void rightToLeft(int n) {
		if (n == 1) {
			System.out.println("move 1 right to left");
			return;
		}
		rightToMid(n - 1);
		System.out.println("move " + n + " right to left");
		midToLeft(n - 1);
	}


	private void midToRight(int n) {
		if (n == 1) {
			System.out.println("move 1 mid to right");
			return;
		}
		midToLeft(n - 1);
		System.out.println("move " + n + " mid to right");
		leftToRight(n - 1);
	}

	private void midToLeft(int n) {
		if (n == 1) {
			System.out.println("move 1 mid to left");
			return;
		}
		midToRight(n - 1);
		System.out.println("move " + n + " mid to left");
		rightToLeft(n - 1);
	}


}
