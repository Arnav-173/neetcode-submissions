class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int start = 0;
        int end = k;
        List<Integer> maxList = new ArrayList<>();
        while (end <= nums.length) {
            maxList.add(findMax(nums, start, end));
            start++;
            end++;
        }
        int[] maxArr = new int[maxList.size()];
        for (int i = 0; i < maxList.size(); i++) {
            maxArr[i] = maxList.get(i);
        }
        return maxArr;
    }

    private int findMax(int[] nums, int start, int end) {
        int max = Integer.MIN_VALUE;
        for (int i = start; i < end; i++) {
            if (nums[i] > max) {
                max = nums[i];
            }
        }
        return max;
    }
}
