//LeetCode 155
class MinStack {

        private List<Integer> container;

        private int p;

        private int min;

        /** initialize your data structure here. */
        public MinStack() {
            container = new ArrayList<>();
            p = 0;
            min = Integer.MAX_VALUE;
        }

        public void push(int x) {
            container.add(p,x);
            min = Math.min(min,x);
            p++;
        }

        public void pop() {
            if (p >= 1) {
                if (container.get(p - 1) != null && container.get(p - 1) == min) {
                    container.add(p - 1, null);

                    min = Integer.MAX_VALUE;
                    for (int i = 0; i < p - 1; i++) {
                        Integer integer = container.get(i);
                        if (integer != null) {
                            min = Math.min(integer,min);
                        }
                    }

                } else {
                    container.add(p - 1, null);

                }
            }
            if (p >= 1) {
                p--;
            }
        }

        public int top() {
            if (p >= 1) {
                return container.get(p - 1);
            } else {
                return -1;
            }
        }

        public int getMin() {
            return min;
        }
}
