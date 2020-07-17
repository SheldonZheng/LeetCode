/**
 * LeetCode Interview 59 队列的最大值LCOF
 */
class MaxQueue {

        private Deque<Integer> container;
        private Queue<Integer> queue;

        public MaxQueue() {
             container = new LinkedList<>();
             queue = new LinkedList<>();
        }

        public int max_value() {
            return container.isEmpty() ? -1 : container.peek();
        }

        public void push_back(int value) {
            queue.offer(value);
            while (!container.isEmpty() && container.peekLast() < value) {
                container.pollLast();
            }
            container.offerLast(value);
        }

        public int pop_front() {
            if (queue.isEmpty()) {
                return -1;
            }
            int value = queue.poll();
            if (!container.isEmpty() && value == container.peek()) {
                container.poll();
            }
            return value;
        }
    }

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
