class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int[] solution = new int[2];
        for (int i = 0; i < numbers.length; i++) {
            int targetIndex = Arrays.binarySearch(numbers, target - numbers[i]);
            if (targetIndex >= 0 && targetIndex != i) {
                solution[0] = i + 1;
                solution[1] = targetIndex + 1;
                return solution;
            }
        }
        return solution;
    }
}
