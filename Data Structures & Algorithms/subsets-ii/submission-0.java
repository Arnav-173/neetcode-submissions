class Solution {
    List<List<Integer>> result = new ArrayList<>();
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            numList.add(nums[i]);
        }
        List<Integer> subset = new ArrayList<>();
        backtrack(0, subset, nums);
        return result;
    }

    private void backtrack(int i, List<Integer> subset, int[] nums) {
        if (i >= nums.length) {
            result.add(List.copyOf(subset));
            return;
        }
        subset.add(nums[i]);
        backtrack(i + 1, subset, nums);
        subset.removeLast();

        while (i < nums.length - 1 && nums[i] == nums[i + 1]) i++;
        backtrack(i + 1, subset, nums);
    }
}
