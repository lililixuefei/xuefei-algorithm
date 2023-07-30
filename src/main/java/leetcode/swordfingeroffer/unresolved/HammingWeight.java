package leetcode.swordfingeroffer.unresolved;

/**
 * @description: 剑指 Offer 15. 二进制中1的个数
 * @author: xuefei
 * @date: 2023/07/30 18:46
 */
public class HammingWeight {

    public int hammingWeight(int n) {
        int ans = 0;
        while (n != 0) {
            ans += (n & 1);
            n >>>= 1;
        }
        return ans;
    }


    public int hammingWeight1(int n) {
        String binaryString = Integer.toBinaryString(n);
        int count = 0;
        for (int i = 0; i < binaryString.length(); i++) {
            if (binaryString.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

}
