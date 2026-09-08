class Solution {
    List<List<Integer>> result = new ArrayList<>();
    Set<List<Integer>> resultSet = new HashSet<>();
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<Integer> currList = new ArrayList<>();
        int i = 0;
        Arrays.sort(candidates);
        combineSum(i, target, candidates, currList);
        result = new ArrayList<>(resultSet);
        return result;
    }

    private void combineSum(int i, int target, int[] nums, List<Integer> currList) {
        if (target == 0) {
            resultSet.add(List.copyOf(currList));
            return;
        }
        if (target < 0 || i >= nums.length) {
            return;
        }
        /* include nums[i] */
        currList.add(nums[i]);
        combineSum(i + 1, target - nums[i], nums, currList);

        /* DO NOT include nums[i] */
        currList.remove(currList.size() - 1);
        while (i + 1 < nums.length && nums[i] == nums[i + 1]) {
            i++;
        }
        combineSum(i + 1, target, nums, currList);
    }
}
