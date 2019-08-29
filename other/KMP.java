import java.util.ArrayList;
import java.util.List;

public class KMP {
    /**
     * 字符串匹配算法
     * KMP算法, 时间复杂度: O(n+m)
     * <pre>
     *              1         2
     * m: 01234567890123456789012
     * S: ABC ABCDAB ABCDABCDABDE
     * W: ABCDABD
     * i: 0123456
     *
     * 部分匹配表: 0, 0, 0, 0, 1, 2, 0
     * </pre>
     */
    public static List<Integer> kmp(String s, String w) {
        List<Integer> index = new ArrayList<>();
        int[] tb = next(w);
        int i = 0;
        for (int m = 0; m < s.length(); m++) {
            while (i > 0 && w.charAt(i) != s.charAt(m)) {
                i = tb[i - 1];
            }
            if (s.charAt(m) == w.charAt(i)) {
                i++;
            }
            if (i == w.length()) {
                index.add(m - w.length() + 1);
                i = tb[i - 1];
            }
        }
        return index;
    }

    /**
     * <pre>
     *    012345678901234
     * W: agctagcagctagct
     * i: 000012312345674
     * </pre>
     *
     * @param w
     * @return
     */
    private static int[] next(String w) {
        int[] tb = new int[w.length()];
        int maxLen = 0;
        for (int i = 1; i < w.length(); i++) {
            while (maxLen > 0 && w.charAt(maxLen) != w.charAt(i)) {
                maxLen = tb[maxLen - 1];
            }
            if (w.charAt(i) == w.charAt(maxLen)) {
                maxLen++;
            }
            tb[i] = maxLen;
        }
        System.out.println(Arrays.toString(tb));
        return tb;
    }

    public static void main(String[] args) {
        System.out.println(kmp("ABC ABCDAB ABCDABCDABDE","ABCDABD"));
    }
}
