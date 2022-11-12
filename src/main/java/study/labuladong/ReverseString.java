package study.labuladong;

/**
 * @description: 反转字符串
 * @author: xuefei
 * @date: 2022/07/12 22:52
 */
public class ReverseString {


    public void reverseString(char[] s) {
        int left = 0;
        int right = s.length - 1;
        while (left < right){
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left++;
            right--;
        }
    }
}
