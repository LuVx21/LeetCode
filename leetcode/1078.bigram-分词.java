

class Solution {
    public String[] findOcurrences(String text, String first, String second) {
        List<String> result = new ArrayList<>();

        String[] array = text.split(" ");
        int length = array.length;
        for (int i = 0; i < length - 2; i++) {
            String str = array[i];
            if (str.equals(first) && array[i + 1].equals(second)) {
                result.add(array[i + 2]);
            }
        }

        return result.toArray(new String[result.size()]);
    }
}
