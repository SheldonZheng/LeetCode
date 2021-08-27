/**
 * LeetCode 295 Find Median from Data Stream
 */
class MedianFinder {

        PriorityQueue<Integer> l = new PriorityQueue<>((i,j) -> (j - i));
        PriorityQueue<Integer> r = new PriorityQueue<>((i,j) -> (i - j));


        /** initialize your data structure here. */
        public MedianFinder() {

        }

        public void addNum(int num) {
            int l1 = l.size(),l2 = r.size();
            if (l1 == l2) {
                if (r.isEmpty() || num <= r.peek()) {
                    l.add(num);
                } else {
                    l.add(r.poll());
                    r.add(num);
                }
            } else {
                if (l.peek() <= num) {
                    r.add(num);
                } else {
                    r.add(l.poll());
                    l.add(num);
                }
            }
        }

        public double findMedian() {
            if (l.size() > r.size()) {
                return l.peek();
            } else {
                return (l.peek() + r.peek()) / 2.0;
            }
        }
    }

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */
