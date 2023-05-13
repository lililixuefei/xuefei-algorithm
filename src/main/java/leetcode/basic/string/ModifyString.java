package leetcode.basic.string;


/**
 * @description: 替换所有的问号
 * @author: xuefei
 * @date: 2023/02/09 22:38
 */
public class ModifyString {


    public static void main(String[] args) {
        System.out.println(modifyString("?fgh"));
    }

    public static String modifyString(String s) {
        int n = s.length();
        char[] arr = s.toCharArray();
        for (int i = 0; i < n; ++i) {
            if (arr[i] == '?') {
                for (char ch = 'a'; ch <= 'c'; ++ch) {
                    if ((i > 0 && arr[i - 1] == ch) || (i < n - 1 && arr[i + 1] == ch)) {
                        continue;
                    }
                    arr[i] = ch;
                    break;
                }
            }
        }
        return new String(arr);
    }

}
