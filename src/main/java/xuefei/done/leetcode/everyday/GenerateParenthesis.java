package xuefei.done.leetcode.everyday;

import java.util.ArrayList;
import java.util.List;

/**
 * @description: 括号生成   https://leetcode.cn/problems/generate-parentheses/
 * @author: xuefei
 * @date: 2022/05/10 23:44
 */
public class GenerateParenthesis {

    public static void main(String[] args) {
        System.out.println(generateParenthesis(3).toString());
    }



    public static final char LEFT_SMALL_PARENTHESIS = '(';

    public static final char RIGHT_SMALL_PARENTHESIS = ')';


    public static final char QUOTATION_MARK = '"';


    public static final char COMMA = ',';

    public static List<String> generateParenthesis(int n) {
        List<String> stringList = new ArrayList<>();
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < n; i++) {
            stringBuilder.append(QUOTATION_MARK);
            for (int j = 0; j < n; j++) {
                stringBuilder.append(LEFT_SMALL_PARENTHESIS);
            }
            for (int j = 0; j < n; j++) {
                stringBuilder.append(RIGHT_SMALL_PARENTHESIS);
            }
            stringBuilder.append(QUOTATION_MARK);

            if (i + 1 != n) {
                stringBuilder.append(COMMA);
            }
        }
        stringList.add(stringBuilder.toString());
        return stringList;
    }
}
