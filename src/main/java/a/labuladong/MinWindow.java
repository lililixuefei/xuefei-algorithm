package a.labuladong;


/**
 * @description: 最小覆盖子串
 * @author: xuefei
 * @date: 2022/07/12 00:25
 */
public class MinWindow {

    public static void main(String[] args) {

        String s = "ttezcfpdcjpgrzlpmyboveznllxilqogluhocxteiimzhzrtxujuyiikwfsjyjpjdyzfxslfdzhmzygysrtqabayithgeyshwtpumcbpcibbijbabutdxtbgoiosggcectaovcfxkiatucvxyoawkdeanstvbxzdqatneylqinlcrhzqxzmheqirkdmlaoqsqjfujsksgwuzfwpcxdkcvuvgxktzymtovykhtubbsvaxrqarvmtrgozfyugygzoezylsvmtnjundmnuhbpyjdzqeuweavtewtrpofieperuqgoyjfysiyiosgtudmbzhsqwybcpftlwbbwkgwequmfouyjxmkyvepreqtvxogvphrbnofektlznlimzuluacmfuhcryjnpseriuwmfqzgfkqsjmfdmhrtbbwszhhozofhievpuuxzgntpzyvohmhkpffommfmamvlqtcmnaowphnriifpxoamufdgtiuuwqhpljbylpwbzkshszyr";
        String t = "nyehfhqzrkvncccnngoz";

        System.out.println(minWindow(s, t));
    }

    public static String minWindow(String s, String t) {
        if (s.length() < t.length()) {
            return "";
        }
        int left = -1;
        int right = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String substring = s.substring(i, j + 1);


                int[] count = new int[256];
                for (int k = 0; k < substring.length(); k++) {
                    count[substring.charAt(k)]++;
                }

                boolean contains = true;
                for (int m = 0; m < t.length(); m++) {
                    if (count[t.charAt(m)] > 0) {
                        count[t.charAt(m)]--;
                    } else {
                        contains = false;
                        break;
                    }
                }
                if (contains) {
                    if (min > (j - i)) {
                        left = i;
                        right = j;
                        min = Math.min(min, right - left);
                    }
                }
            }
        }
        if (right == -1) {
            return "";
        } else {
            return s.substring(left, right + 1);
        }
    }


}
