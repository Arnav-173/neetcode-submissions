class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        int sum = 0;
        List<Integer> currList = new ArrayList<>();
        combineSum(0, currList, sum, target, nums);
        return result;
    }

    private void combineSum(int i, List<Integer> currList, int sum, int target, int[] nums) {
        if (sum > target || i >= nums.length) {
            return;
        }
        if (sum == target) {
            result.add(List.copyOf(currList));
            return;
        }
        /* decision to stick with nums[i] and explore */
        currList.add(nums[i]);
        combineSum(i, currList, sum + nums[i], target, nums);

        /* decision to proceed and not use nums[i] and explore */
        currList.remove(currList.size() - 1);
        combineSum(i + 1, currList, sum, target, nums);
    }
    
}
