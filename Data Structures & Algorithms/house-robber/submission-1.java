class Solution {
    public int rob(int[] nums) {
        int[] cost = new int[nums.length];
        Arrays.fill(cost, -1);
        int i = 0;
        return dfs(cost, nums, 0);
    }

    private int dfs(int[] cost, int[] nums, int i) {
        if (i >= nums.length) {
            return 0;
        }
        if (cost[i] != -1) {
            return cost[i];
        }
        cost[i] = Math.max(dfs(cost, nums, i + 1), nums[i] + dfs(cost, nums, i + 2));
    
        return cost[i];
    }
}
