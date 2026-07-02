class Solution {
    List<List<Integer>> eligiblePaths = new ArrayList<>();
    Set<List<Integer>>  eligiblePathsSet = new HashSet<>();
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<Integer> path = new ArrayList<>();
        for (int i = 0; i< nums.length; i++) {
            int sum = 0;
            decision(nums, target, path, sum, i);
        }
        return eligiblePaths;
    }

    private void decision(int[] nums, int target, List<Integer> path, int sum, int i) {
        if (sum == target) {
            List<Integer> pathCopy = new ArrayList<>(path);
            Collections.sort(pathCopy);
            if (!eligiblePathsSet.contains(pathCopy)) {
                eligiblePathsSet.add(pathCopy);
                eligiblePaths.add(new ArrayList<>(path));
            }
            return;
        }
        sum = sum + nums[i];
        if (sum > target) {
            return;
        }
        path.add(nums[i]);
        for (int j = 0; j < nums.length; j++) {
            decision(nums, target, path, sum, j);
            if (j == nums.length - 1) {
                path.remove(path.size() - 1);
            }
        }
    }
}
