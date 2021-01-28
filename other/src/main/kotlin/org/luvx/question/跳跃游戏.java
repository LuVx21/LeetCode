/**
 * @author: Ren, Xie
 */
public class Main {

    /**
     * 给定一个非负整数数组，你最初位于数组的第一个位置。
     * 首先跳跃一个长度, 为[1, length/2)
     * <p>
     * 之后跳跃长度为此处的元素值
     * <p>
     * 判断能到达最后一个位置时, 最小的跳跃次数, 不能则返回-1
     * <p>
     * 7 5 9 4 2 6 8 3 5 4 3 9 -> 2
     * 1 2 3 7 1 5 9 3 2 1 -> -1
     * 1 2 3 7 5 5 9 3 2 1 -> 2
     *
     * @param nums
     * @return
     */
    public int steps(int[] nums) {
        int result = -1;
        int len = nums.length, half = len / 2;
        for (int i = 1; i < half; i++) {
            int index = i, count = 0;
            while (true) {
                if (index <= len - 1) {
                    count++;
                    if (index == len - 1) {
                        break;
                    }
                } else if (index > len - 1) {
                    count = -1;
                    break;
                }
                int num = nums[index];
                index += num;
            }
            if (result == -1) {
                result = count;
            } else {
                if (count != -1) {
                    result = Math.min(count, result);
                }
            }
        }
        return result;
    }
}
