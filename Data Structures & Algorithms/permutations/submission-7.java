class Solution {
    public List<List<Integer>> permute(int[] nums) {
        /**
         * 1. Iterate over nums, for each num
         * 2. Pass remaining list to function
         * 3. Function returns permutations of remaining list
         * 4. Pre-pend num to each of the permutations
         */
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            numList.add(nums[i]);
        }
        List<List<Integer>> permuations = permuteSubList(numList, result, numList.size());
        if (permuations.size() == 1) result.addAll(permuations);
        return result;
    }

    private List<List<Integer>> permuteSubList(List<Integer> numList, List<List<Integer>> result, int size) {
        if (numList.size() == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> subPermutations = new ArrayList<>();
        if (numList.size() == 1) {
            subPermutations.add(numList);
            return subPermutations;
        }
        for (int i = 0; i < numList.size(); i++) {
            Integer num = numList.get(i);
            List<Integer> remainingList = new ArrayList<>();
            remainingList.addAll(numList.subList(0, i));
            remainingList.addAll((numList.subList(i + 1, numList.size())));
            List<List<Integer>> permutations = permuteSubList(remainingList, result, size);
            for (List<Integer> permutationList : permutations) {
                permutationList.addFirst(num);
                if (numList.size() == size) {
                    result.add(permutationList);
                } else {
                    subPermutations.add(permutationList);
                }
            }
        }
        return subPermutations;
    }
}