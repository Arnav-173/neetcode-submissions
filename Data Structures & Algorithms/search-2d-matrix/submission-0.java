class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        boolean exists = false;
        for (int i = 0; i < matrix.length; i++) {
            int length = matrix[i].length;
            exists = binarySearch(matrix[i], 0, length - 1, target);
            if (exists) {
                break;
            }
        }
        return exists;
    }

    public boolean binarySearch(int[] nums, int start, int end, int target) {
        if (start > end) {
            return false;
        }
        int mid = start + (end - start)/2;
        if (nums[mid] == target) {
            return true;
        } 
        if (nums[mid] < target) {
            return binarySearch(nums, mid + 1, end, target);
        } else {
            return binarySearch(nums, start, mid - 1, target);
        }
    }
}
