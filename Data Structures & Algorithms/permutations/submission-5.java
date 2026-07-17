class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> numList = new ArrayList<>();
        for (int num : nums) {
            numList.add(num);
        }
        for (int i = 0; i < numList.size(); i++) {
            int currentNum = numList.get(i);
            List<Integer> remainingList = new ArrayList<>();
            remainingList.addAll(numList.subList(0, i));
            remainingList.addAll(numList.subList(i + 1, numList.size()));
            List<List<Integer>> subPermutations = subPermute(remainingList);
            if (subPermutations.isEmpty()) {
                result.add(List.of(currentNum));
            } else {
                for (List<Integer> subList : subPermutations) {
                    List<Integer> finalList = new ArrayList<>();
                    finalList.add(currentNum);
                    finalList.addAll(subList);
                    result.add(finalList);
                }
            }
        }
        return result;
    }

    private List<List<Integer>> subPermute(List<Integer> remainingList) {
        if (remainingList.isEmpty()) {
            return new ArrayList<>();
        }
        if (remainingList.size() == 1) {
            return List.of(remainingList);
        }
        List<List<Integer>> subList = new ArrayList<>();
        for (int i = 0; i < remainingList.size(); i++) {
            int currentNum = remainingList.get(i);
            List<Integer> remainingSubList = new ArrayList<>();
            remainingSubList.addAll(remainingList.subList(0, i));
            remainingSubList.addAll(remainingList.subList(i + 1, remainingList.size()));
            List<List<Integer>> subPermutations = subPermute(remainingSubList);
            for (List<Integer> sub : subPermutations) {
                List<Integer> remainder = new ArrayList<>();
                remainder.add(currentNum);
                remainder.addAll(sub);
                subList.add(remainder);
            }
        }
        return subList;
    }
}