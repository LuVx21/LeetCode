
public int heightChecker(int[] heights) {
    int length = heights.length;
    int[] temp = Arrays.copyOf(heights, length);
    Arrays.sort(temp);

    int result = 0;
    for (int i = 0; i < length; i++) {
        if (temp[i] != heights[i]) {
            result++;
        }
    }

    return result;
}
