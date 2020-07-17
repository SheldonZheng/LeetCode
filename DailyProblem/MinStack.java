/**
 * LeetCode 155 Min Stack
 */
class MinStack {
        private Stack<Integer> container;
        private Stack<Integer> minStack;

        /** initialize your data structure here. */
        public MinStack() {
            container = new Stack<Integer>();
            minStack = new Stack<Integer>();

        }

        public void push(int x) {
            if (container.isEmpty()) {
                minStack.push(x);
                container.push(x);
            } else {
                if (x < minStack.peek()) {
                    minStack.push(x);
                } else {
                    minStack.push(minStack.peek());
                }
                container.push(x);
            }
        }

        public void pop() {
            container.pop();
            minStack.pop();
            return ;
        }

        public int top() {
            return container.peek();
        }

        public int getMin() {
            return minStack.peek();
        }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
