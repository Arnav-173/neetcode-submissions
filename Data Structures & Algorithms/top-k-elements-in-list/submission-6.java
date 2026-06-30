class Solution {

    class FreqObj {
        public int key;
        public int freq;
    }

    public int[] topKFrequent(int[] nums, int k) {
        int[] result = new int[k];
        PriorityQueue<FreqObj> maxHeap = new PriorityQueue<>(Comparator.comparingInt((FreqObj f) -> f.freq).reversed());
        Map<Integer, Integer> freqMap = new HashMap<>();
        for (int n: nums) {
            int count = freqMap.get(n) == null ? 1 : freqMap.get(n) + 1;
            freqMap.put(n, count);
        }
        for (Map.Entry<Integer, Integer> entry : freqMap.entrySet()) {
            FreqObj obj = new FreqObj();
            obj.key = entry.getKey();
            obj.freq = entry.getValue();
            maxHeap.add(obj);
        }
        for (int i = 0; i < k; i++) {
            result[i] = maxHeap.poll().key;
        }
        return result;
    }
}
