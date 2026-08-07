class Solution {
    public int minCostClimbingStairs(int[] cost) {
        Map<Integer, Integer> stepCost = new HashMap<>();
        return Math.min(minCost(cost, stepCost, 0), minCost(cost, stepCost, 1));
    }
    public int minCost(int[] cost, Map<Integer, Integer> stepCost, int i) {
        if (i >= cost.length) {
            return 0;
        }
        if (stepCost.get(i) != null) {
            return stepCost.get(i);
        }
        stepCost.put(i, cost[i] + Math.min(minCost(cost, stepCost, i + 1),
        minCost(cost, stepCost, i + 2)));
        return stepCost.get(i);
    }
}
