class Solution {
    public int climbStairs(int n) {
        return countSteps(n);
    }

    public int countSteps(int n) {

        int[] stepCount = {1, 2};
        if (n <= 1) {
            return stepCount[0];
        }
        int i = 2;
        while (i < n) {
            int tmp = stepCount[1];
            stepCount[1] = stepCount[0] + stepCount[1];
            stepCount[0] = tmp;
            i++;
        }
        return stepCount[1];
     }
}
