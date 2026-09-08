class Solution {

    public List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsets(int[] nums) {
        List<Integer> subset = new ArrayList<>();
        int i = 0;
        buildSubset(i, subset, nums);
        return result;
    }

    private void buildSubset(int i, List<Integer> subset, int[] nums) {
        if (i >= nums.length) {
            result.add(List.copyOf(subset));
            return;
        }
        /*decision to include nums[i]*/
        subset.add(nums[i]);
        buildSubset(i + 1, subset, nums);

        /*decision to NOT include nums[i]*/
        subset.remove(subset.size() - 1);
        buildSubset(i + 1, subset, nums);
    }

}
