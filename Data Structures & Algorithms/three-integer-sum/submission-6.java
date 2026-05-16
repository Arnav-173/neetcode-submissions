class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int target = 0;
        Arrays.sort(nums);
        List<Integer> numList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        for (int i = 0; i < nums.length; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) continue;
            for (int j = i + 1; j < nums.length; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) continue;
                int complement = target - nums[i] - nums[j];
                int targetIndex = Collections.binarySearch(numList.subList(j + 1, numList.size()), complement);
                if (targetIndex >= 0) {
                    List<Integer> partList = new ArrayList<>(Arrays.asList(nums[i], nums[j], complement));
                    result.add(partList);
                }
            }
        }
        return result;
    }
}