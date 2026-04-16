class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        if (intervals.length == 1) {
            return intervals;
        }
        List<int[]> mergedIntervalList = new ArrayList();
        mergedIntervalList.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= mergedIntervalList.get(mergedIntervalList.size()-1)[1]) {
                int[] interval = new int[2];
                interval[0] = mergedIntervalList.get(mergedIntervalList.size()-1)[0];
                interval[1] = intervals[i][1] > mergedIntervalList.get(mergedIntervalList.size()-1)[1] ? intervals[i][1] : mergedIntervalList.get(mergedIntervalList.size()-1)[1];
                int[] lastInterval = mergedIntervalList.get(mergedIntervalList.size() - 1);
                lastInterval[0] = interval[0];
                lastInterval[1] = interval[1];
            } else {
                int[] interval = new int[2];
                interval[0] = intervals[i][0];
                interval[1] = intervals[i][1];
                mergedIntervalList.add(interval);
            }
        }
        int[][] mergedIntervals = new int[mergedIntervalList.size()][2];
        for (int i = 0; i < mergedIntervalList.size(); i++) {
            mergedIntervals[i][0] = mergedIntervalList.get(i)[0];
            mergedIntervals[i][1] = mergedIntervalList.get(i)[1];
        }
        return mergedIntervals;
    }
}
