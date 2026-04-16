class Solution {
    public int[] twoSum(int[] nums, int target) {
        int[] result = new int[2];
        Map<Integer, Integer> indexMap = new HashMap();
        for (int i = 0; i < nums.length; i++) {
            indexMap.put(nums[i], i);
        }
        for (int i = 0; i < nums.length; i++) {
            int numToFind = target - nums[i];
            Integer targetIndex = indexMap.get(numToFind);
            if (targetIndex != null && targetIndex != i) {
                result[0] = i;
                result[1] = targetIndex;
                break;
            }
        }
        return result;
    }
}
