class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> numSet = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        int sequenceStart = 0;
        int longestSequence = 0;
        for (Integer i : numSet) {
            if (!numSet.contains(i - 1)) {
                sequenceStart = i;
                int count = 1;
                while (numSet.contains(sequenceStart + 1)) {
                    sequenceStart++;
                    count++;
                }
                if (count > longestSequence) {
                    longestSequence = count;
                }
            }
        }
        return longestSequence;
    }
}
