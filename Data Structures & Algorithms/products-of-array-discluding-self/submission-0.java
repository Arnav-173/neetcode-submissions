class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] prefixArray = new int[nums.length];
        int[] suffixArray = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            if (i == 0) {
                prefixArray[i] = 1;
            } else {
                prefixArray[i] = prefixArray[i-1] * nums[i-1];
            }
        }
        for (int i = nums.length - 1; i >= 0; i--) {
            if (i == nums.length - 1) {
                suffixArray[i] = 1;
            } else {
                suffixArray[i] = suffixArray[i+1] * nums[i+1];
            }
        }
        int[] result = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            result[i] = prefixArray[i] * suffixArray[i];
        }
        return result;
    }
}  
