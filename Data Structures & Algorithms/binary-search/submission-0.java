class Solution {
    public int search(int[] nums, int target) {
        int start = 0;
        int end = nums.length;
        return binarySearch(nums, start, end - 1, target);
    }

    public int binarySearch(int[] nums, int start, int end, int target) {
        if (start > end) {
            return -1;
        }
        int mid = start + (end - start)/2;
        if (nums[mid] == target) {
            return mid;
        } 
        if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, end, target);
        } else {
            return binarySearch(nums, start, mid - 1, target);
        }
    }
}
