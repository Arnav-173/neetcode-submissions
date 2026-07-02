class Solution {

    class Task {
        public char t;
        public int num;
        public int time;

        public Task(char a, int n) {
            this.t = a;
            this.num = n;
        }
    }

    public int leastInterval(char[] tasks, int n) {
        PriorityQueue<Task> maxHeap = new PriorityQueue<>(Comparator.comparingInt((Task t) -> t.num).reversed());
        Queue<Task> taskQueue = new LinkedList<>();
        Map<Character, Integer> charCount = new HashMap<>();
        for (int i = 0; i < tasks.length; i++) {
            Integer count = charCount.get(tasks[i]);
            if (count == null) {
                count = 0;
            }
            charCount.put(tasks[i], count + 1);
        }
        for (Map.Entry<Character, Integer> entry: charCount.entrySet()) {
            Task t = new Task(entry.getKey(), entry.getValue());
            maxHeap.offer(t);
        }
        int cycles = 0;
        do {
            if (!taskQueue.isEmpty() && taskQueue.peek().time <= cycles) {
                Task t = taskQueue.poll();
                maxHeap.offer(t);
            }
            if (!maxHeap.isEmpty()) {
                Task t = maxHeap.poll();
                t.num = t.num - 1;
                if (t.num > 0) {
                    t.time = cycles + n + 1;
                    taskQueue.offer(t);
                }
            }
            cycles++;
        } while (!taskQueue.isEmpty() || !maxHeap.isEmpty());
        return cycles;
    }
}
