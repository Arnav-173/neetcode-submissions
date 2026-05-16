class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map<Character, Integer> indexMap = new HashMap<>();
        char[] arr = s.toCharArray();
        int size = 0;
        int start = 0;
        int end = 0;
        while (end < arr.length) {
            if (indexMap.containsKey(arr[end])) {
                if (end - start > size) {
                    size = end - start;
                }
                int index = indexMap.get(arr[end]);
                while (start <= index) {
                    indexMap.remove(arr[start++]);
                }
                indexMap.put(arr[end], end);
                end++;
            } else {
                indexMap.put(arr[end], end);
                end++;
            }
        }
        if (end - start > size) {
            size = end - start;
        }
        return size;
    }
}
